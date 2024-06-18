CREATE TABLE IF NOT EXISTS `Inventory` (
  `InventoryID` int NOT NULL AUTO_INCREMENT,
  `Type` varchar(50) DEFAULT NULL,
  `Name` varchar(100) NOT NULL,
  `Quantity` int unsigned NOT NULL,
  `Image` varchar(255) DEFAULT NULL,
  `Description` text,
  `PurchasingPrice` double DEFAULT NULL,
  `SellingPrice` double DEFAULT NULL,
  `Barcode` int DEFAULT NULL,
  `Status` enum('Active','Inactive') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'Active',
  PRIMARY KEY (`InventoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `Transactions` (
  `TransactionID` int NOT NULL AUTO_INCREMENT,
  `TransactionDate` datetime NOT NULL,
  `TotalAmount` double DEFAULT NULL,
  PRIMARY KEY (`TransactionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `TransactionDetails` (
  `TransactionDetailID` int NOT NULL AUTO_INCREMENT,
  `TransactionID` int DEFAULT NULL,
  `InventoryID` int DEFAULT NULL,
  `Quantity` int unsigned NOT NULL,
  `PurchasingPriceAtTransaction` double unsigned NOT NULL DEFAULT '0',
  `PriceAtTransaction` double unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`TransactionDetailID`),
  KEY `FK_TransactionDetails_Transactions` (`TransactionID`),
  KEY `FK_TransactionDetails_Inventory` (`InventoryID`),
  CONSTRAINT `FK_TransactionDetails_Inventory` FOREIGN KEY (`InventoryID`) REFERENCES `Inventory` (`InventoryID`),
  CONSTRAINT `FK_TransactionDetails_Transactions` FOREIGN KEY (`TransactionID`) REFERENCES `Transactions` (`TransactionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `Users` (
  `UserID` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `Username` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

# Trigger tự động tạo dữ liệu cho hóa đơn, và chi tiếc hóa đơn

CREATE TRIGGER before_insert_transactiondetails
BEFORE INSERT ON TransactionDetails
FOR EACH ROW
BEGIN
    DECLARE current_selling_price DOUBLE;
    DECLARE current_purchasing_price DOUBLE;

    -- Lấy giá bán hiện tại và giá nhập từ bảng Inventory
    SELECT SellingPrice, PurchasingPrice INTO current_selling_price, current_purchasing_price
    FROM Inventory
    WHERE InventoryID = NEW.InventoryID;

    -- Gán giá trị lấy được vào PriceAtTransaction và PurchasingPriceAtTransaction
    SET NEW.PriceAtTransaction = current_selling_price;
    SET NEW.PurchasingPriceAtTransaction = current_purchasing_price;

    -- Kiểm tra xem TransactionID có được cung cấp không, nếu không, sử dụng biến phiên hoặc tạo một giao dịch mới
    IF @current_transaction_id IS NULL THEN
        INSERT INTO Transactions (TransactionDate, TotalAmount)
        VALUES (NOW(), 0);

        -- Lấy TransactionID vừa được chèn và gán nó vào biến phiên
        SET @current_transaction_id = LAST_INSERT_ID();
    END IF;

    -- Gán TransactionID cho TransactionDetails mới
    SET NEW.TransactionID = @current_transaction_id;

    -- Tính tổng số tiền cho giao dịch
    SET @current_total_amount = (SELECT COALESCE(SUM(Quantity * PriceAtTransaction), 0)
                                 FROM TransactionDetails
                                 WHERE TransactionID = NEW.TransactionID);

    -- Cập nhật tổng số tiền trong bảng Transactions
    UPDATE Transactions
    SET TotalAmount = @current_total_amount + (NEW.Quantity * NEW.PriceAtTransaction)
    WHERE TransactionID = NEW.TransactionID;
END;

# Ví dụ cách hoạt động
/*
INSERT INTO Inventory (Type, Name, Quantity, PurchasingPrice, SellingPrice, Barcode, Status)
VALUES ('Electronics', 'Laptop', 50, 500.00, 700.00, 123456, 'Active');

INSERT INTO Inventory (Type, Name, Quantity, PurchasingPrice, SellingPrice, Barcode, Status)
VALUES ('Electronics', 'Smartphone', 100, 300.00, 500.00, 234567, 'Active');

INSERT INTO Inventory (Type, Name, Quantity, PurchasingPrice, SellingPrice, Barcode, Status)
VALUES ('Appliances', 'Refrigerator', 20, 800.00, 1000.00, 345678, 'Active');

INSERT INTO Inventory (Type, Name, Quantity, PurchasingPrice, SellingPrice, Barcode, Status)
VALUES ('Furniture', 'Chair', 200, 50.00, 100.00, 456789, 'Active');


-- Reset biến session
SET @current_transaction_id = NULL;

-- Insert sản phẩm 1
INSERT INTO TransactionDetails (InventoryID, Quantity)
VALUES (1, 5);

-- Insert sản phẩm 2
INSERT INTO TransactionDetails (InventoryID, Quantity)
VALUES (2, 10);

-- Insert sản phẩm 3
INSERT INTO TransactionDetails (InventoryID, Quantity)
VALUES (3, 2);

-- Insert sản phẩm 4
INSERT INTO TransactionDetails (InventoryID, Quantity)
VALUES (4, 7);

-- Kiểm tra TransactionID được tạo
SELECT @current_transaction_id;

-- Kiểm tra chi tiết giao dịch của TransactionID vừa tạo
SELECT * FROM TransactionDetails WHERE TransactionID = @current_transaction_id;

-- Kiểm tra tổng số tiền của giao dịch
SELECT * FROM Transactions WHERE TransactionID = @current_transaction_id;

*/


-- Tạo trigger để giảm số lượng trong bảng Inventory khi thêm TransactionDetails
CREATE TRIGGER after_insert_transactiondetails
AFTER INSERT ON TransactionDetails
FOR EACH ROW
BEGIN
    -- Giảm số lượng trong Inventory
    UPDATE Inventory
    SET Quantity = Quantity - NEW.Quantity
    WHERE InventoryID = NEW.InventoryID;
END;


-- Tạo stored procedure để lấy thông tin giao dịch dựa trên ID
CREATE PROCEDURE GetTransactionDetails(IN transaction_id INT)
BEGIN
    SELECT
        T.TransactionID,
        T.TransactionDate,
        TD.Quantity,
        TD.PriceAtTransaction,
        TD.Quantity * TD.PriceAtTransaction AS TotalPrice,
        I.Name AS ProductName,
        I.Description AS ProductDescription
    FROM
        Transactions T
    JOIN
        TransactionDetails TD ON T.TransactionID = TD.TransactionID
    JOIN
        Inventory I ON TD.InventoryID = I.InventoryID
    WHERE
        T.TransactionID = transaction_id;
END;

-- CALL GetTransactionDetails(3); // lẤY RA THÔNG TIN GIAO DỊCH CÓ ID BẰNG 3

