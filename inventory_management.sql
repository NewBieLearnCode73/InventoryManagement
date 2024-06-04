/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE TABLE `Inventory` (
  `InventoryID` int NOT NULL AUTO_INCREMENT,
  `Type` varchar(50) DEFAULT NULL,
  `Name` varchar(100) NOT NULL,
  `Quantity` int NOT NULL,
  `Image` varchar(255) DEFAULT NULL,
  `Description` text,
  `PurchasingPrice` decimal(10,2) DEFAULT NULL,
  `SellingPrice` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`InventoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Transaction` (
  `TransactionID` int NOT NULL AUTO_INCREMENT,
  `TransactionType` enum('IN','OUT') NOT NULL,
  `TransactionDate` date NOT NULL,
  `UserID` int DEFAULT NULL,
  PRIMARY KEY (`TransactionID`),
  KEY `UserID` (`UserID`),
  CONSTRAINT `Transaction_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `Users` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `TransactionDetails` (
  `TransactionDetailID` int NOT NULL AUTO_INCREMENT,
  `TransactionID` int DEFAULT NULL,
  `InventoryID` int DEFAULT NULL,
  `Quantity` int NOT NULL,
  PRIMARY KEY (`TransactionDetailID`),
  KEY `TransactionID` (`TransactionID`),
  KEY `InventoryID` (`InventoryID`),
  CONSTRAINT `TransactionDetails_ibfk_1` FOREIGN KEY (`TransactionID`) REFERENCES `Transaction` (`TransactionID`),
  CONSTRAINT `TransactionDetails_ibfk_2` FOREIGN KEY (`InventoryID`) REFERENCES `Inventory` (`InventoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Users` (
  `UserID` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `Username` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Inventory` (`InventoryID`, `Type`, `Name`, `Quantity`, `Image`, `Description`, `PurchasingPrice`, `SellingPrice`) VALUES
(2, 'Ghế ngồi', 'Ghế quỳ tatami', 100, NULL, NULL, '250000.00', '300000.00');


INSERT INTO `Transaction` (`TransactionID`, `TransactionType`, `TransactionDate`, `UserID`) VALUES
(3, 'IN', '2024-05-29', 1);


INSERT INTO `TransactionDetails` (`TransactionDetailID`, `TransactionID`, `InventoryID`, `Quantity`) VALUES
(5, 3, 2, 100);


INSERT INTO `Users` (`UserID`, `Username`, `Password`) VALUES
(1, 'admin', 'admin');



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;