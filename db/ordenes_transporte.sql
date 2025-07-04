
-- MariaDB dump 10.19-11.4.2-MariaDB, for osx10.19 (arm64)
-- Host: localhost    Database: ordenes_transporte
-- Server version	11.4.2-MariaDB


DROP TABLE IF EXISTS `DRIVER`;

CREATE TABLE `DRIVER` (
  `ID` uuid NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `LICENSE_NUMBER` varchar(100) DEFAULT NULL,
  `ACTIVE` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) 

DROP TABLE IF EXISTS `ORDER`;

CREATE TABLE `ORDER` (
  `ID` uuid NOT NULL,
  `STATUS` varchar(100) DEFAULT NULL,
  `ORIGIN` varchar(100) DEFAULT NULL,
  `DESTINATION` varchar(100) DEFAULT NULL,
  `CREATED_AT` datetime DEFAULT NULL,
  `UPDATE_AT` datetime DEFAULT NULL,
  `driver_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `ORDER_DRIVER_FK` FOREIGN KEY (`driver_id`) REFERENCES `DRIVER` (`ID`)
) 

