CREATE TABLE `customer` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(30) NOT NULL,
  `mobile` char(10) DEFAULT NULL,
  `balance` decimal(7,2) DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `customer` VALUES (1,'Avinash','7981468974',1000.00);

CREATE TABLE `invoice` (
  `invoiceId` int(11) NOT NULL AUTO_INCREMENT,
  `custId` int(11) DEFAULT NULL,
  `amount` decimal(7,2) DEFAULT NULL,
  `billDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`invoiceId`),
  KEY `custId` (`custId`),
  CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`custId`) REFERENCES `customer` (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `subscription` (
  `subscriptionId` int(11) NOT NULL AUTO_INCREMENT,
  `titleId` int(11) DEFAULT NULL,
  `custId` int(11) DEFAULT NULL,
  `isActive` tinyint(1) DEFAULT '0',
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  PRIMARY KEY (`subscriptionId`),
  KEY `titleId` (`titleId`),
  KEY `custId` (`custId`),
  CONSTRAINT `subscription_ibfk_1` FOREIGN KEY (`titleId`) REFERENCES `tones` (`toneid`),
  CONSTRAINT `subscription_ibfk_2` FOREIGN KEY (`custId`) REFERENCES `customer` (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `subscription` VALUES (2,1,1,1,'2025-07-31','2025-07-31'),(3,1,1,1,'2025-07-31','2025-08-31'),(4,1,1,1,'2025-07-31','2025-08-31');

CREATE TABLE `tones` (
  `toneId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `artist` varchar(30) DEFAULT NULL,
  `price` decimal(4,2) DEFAULT '0.00',
  PRIMARY KEY (`toneId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tones` VALUES (1,'saregama','arjith',10.00);
