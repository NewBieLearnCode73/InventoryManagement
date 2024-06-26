SET time_zone = '+07:00';

CREATE TABLE `Inventory` (
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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Transactions` (
  `TransactionID` int NOT NULL AUTO_INCREMENT,
  `UserId` int NOT NULL,
  `TransactionDate` datetime NOT NULL,
  `TotalAmount` double DEFAULT NULL,
  PRIMARY KEY (`TransactionID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `TransactionDetails` (
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Users` (
  `UserID` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Role` enum('ADMIN','USER') NOT NULL,
  `Status` enum('Active','Inactive') DEFAULT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `Username` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- $2a$10$9bfwl7VV3UZTFiZc6SIKMegmO1FNz..gKPnv4E.PyX9CmPJiVQJ1i : admin

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
        INSERT INTO Transactions (UserID, TransactionDate, TotalAmount)
        VALUES (@current_user_id, NOW(), 0);

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
        I.Description AS ProductDescription,
        I.Barcode
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

-- Tính lợi nhuận
CREATE PROCEDURE CalculateProfit(OUT profit DOUBLE)
BEGIN
    -- Tính tổng doanh thu từ các giao dịch
    DECLARE totalRevenue DOUBLE DEFAULT 0;
    DECLARE totalCost DOUBLE DEFAULT 0;
    
    -- Tính tổng doanh thu
    SELECT SUM(TD.Quantity * TD.PriceAtTransaction) INTO totalRevenue
    FROM TransactionDetails TD;
    
    -- Tính tổng chi phí
    SELECT SUM(TD.Quantity * TD.PurchasingPriceAtTransaction) INTO totalCost
    FROM TransactionDetails TD;

    -- Tính lợi nhuận
    SET profit = totalRevenue - totalCost;
END;

-- CALL CalculateProfit(@profit);
-- SELECT @profit AS TotalProfit;

-- Lợi nhuận hàng tháng
CREATE FUNCTION GetProfitByMonth(targetMonth INT, targetYear INT)
RETURNS DOUBLE
DETERMINISTIC
BEGIN
    DECLARE totalProfit DOUBLE;

    SELECT COALESCE(SUM(TD.Quantity * (TD.PriceAtTransaction - TD.PurchasingPriceAtTransaction)), 0) INTO totalProfit
    FROM TransactionDetails TD
    JOIN Transactions T ON TD.TransactionID = T.TransactionID
    WHERE MONTH(T.TransactionDate) = targetMonth AND YEAR(T.TransactionDate) = targetYear;

    RETURN totalProfit;
END;

-- SELECT GetProfitByMonth(6,2024);

-- Tổng số tiền thu hàng tháng
CREATE FUNCTION GetTotalAmountForMonthYear(month_val INT, year_val INT)
RETURNS DECIMAL(10, 2)
DETERMINISTIC
BEGIN
    DECLARE total DECIMAL(10, 2);

    SELECT COALESCE(SUM(TotalAmount), 0)
    INTO total
    FROM Transactions
    WHERE MONTH(TransactionDate) = month_val AND YEAR(TransactionDate) = year_val;

    RETURN total;
END;

-- SELECT GetTotalAmountForMonthYear(7, 2024) AS TotalAmount;