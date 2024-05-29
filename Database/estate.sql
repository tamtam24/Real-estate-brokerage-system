-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 13.229.97.6    Database: estateadvance
-- ------------------------------------------------------
-- Server version	8.0.36-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assignmentbuilding`
--

DROP TABLE IF EXISTS `assignmentbuilding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignmentbuilding` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `staffid` bigint NOT NULL,
  `buildingid` bigint NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_building` (`staffid`),
  KEY `fk_building_user` (`buildingid`),
  CONSTRAINT `fk_building_user` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`),
  CONSTRAINT `fk_user_building` FOREIGN KEY (`staffid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmentbuilding`
--

LOCK TABLES `assignmentbuilding` WRITE;
/*!40000 ALTER TABLE `assignmentbuilding` DISABLE KEYS */;
INSERT INTO `assignmentbuilding` VALUES (1,2,1,NULL,NULL,NULL,NULL),(2,2,3,NULL,NULL,NULL,NULL),(3,3,1,NULL,NULL,NULL,NULL),(4,3,4,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `assignmentbuilding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignmentcustomer`
--

DROP TABLE IF EXISTS `assignmentcustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignmentcustomer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `staffid` bigint NOT NULL,
  `customerid` bigint NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_customer` (`staffid`),
  KEY `fk_customer_user` (`customerid`),
  CONSTRAINT `fk_customer_user` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`),
  CONSTRAINT `fk_user_customer` FOREIGN KEY (`staffid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmentcustomer`
--

LOCK TABLES `assignmentcustomer` WRITE;
/*!40000 ALTER TABLE `assignmentcustomer` DISABLE KEYS */;
INSERT INTO `assignmentcustomer` VALUES (1,2,1,NULL,NULL,NULL,NULL),(2,2,3,NULL,NULL,NULL,NULL),(3,3,1,NULL,NULL,NULL,NULL),(4,3,3,NULL,NULL,NULL,NULL),(5,2,4,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `assignmentcustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignmentinstallment`
--

DROP TABLE IF EXISTS `assignmentinstallment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignmentinstallment` (
  `buildingid` bigint DEFAULT NULL,
  `staffid` bigint DEFAULT NULL,
  `installmentid` bigint DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `userid` bigint DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_buildingid_idx` (`buildingid`),
  KEY `fk_staffid_idx` (`staffid`),
  KEY `fk_userid_idx` (`userid`),
  KEY `fk_installmentid_idx` (`installmentid`),
  CONSTRAINT `fk_buildingid` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`),
  CONSTRAINT `fk_installmentid` FOREIGN KEY (`installmentid`) REFERENCES `installment` (`id`),
  CONSTRAINT `fk_staffid` FOREIGN KEY (`staffid`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmentinstallment`
--

LOCK TABLES `assignmentinstallment` WRITE;
/*!40000 ALTER TABLE `assignmentinstallment` DISABLE KEYS */;
INSERT INTO `assignmentinstallment` VALUES (1,1,1,'2024-05-26 13:18:02','2024-05-26 13:18:02','2024-05-26 13:18:02','2024-05-26 13:18:02',2,1),(1,2,1,NULL,NULL,NULL,NULL,1,2),(1,1,19,NULL,NULL,NULL,NULL,2,8),(1,1,20,NULL,NULL,NULL,NULL,2,9),(1,1,21,NULL,NULL,NULL,NULL,2,10),(1,1,22,NULL,NULL,NULL,NULL,2,11),(NULL,NULL,23,NULL,NULL,NULL,NULL,NULL,12),(NULL,NULL,24,NULL,NULL,NULL,NULL,NULL,13),(NULL,NULL,25,NULL,NULL,NULL,NULL,NULL,14),(NULL,NULL,26,NULL,NULL,NULL,NULL,NULL,15),(NULL,NULL,27,NULL,NULL,NULL,NULL,NULL,16),(NULL,NULL,28,NULL,NULL,NULL,NULL,NULL,17),(NULL,NULL,19,NULL,NULL,NULL,NULL,NULL,18),(NULL,NULL,20,NULL,NULL,NULL,NULL,NULL,19),(NULL,NULL,20,NULL,NULL,NULL,NULL,NULL,20),(1,1,29,NULL,NULL,NULL,NULL,7,21),(1,1,30,NULL,NULL,NULL,NULL,7,22);
/*!40000 ALTER TABLE `assignmentinstallment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `building` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `street` varchar(255) DEFAULT NULL,
  `ward` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `structure` varchar(255) DEFAULT NULL,
  `numberofbasement` int DEFAULT NULL,
  `floorarea` int DEFAULT NULL,
  `direction` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `rentprice` int DEFAULT NULL,
  `rentpricedescription` text,
  `servicefee` varchar(255) DEFAULT NULL,
  `carfee` varchar(255) DEFAULT NULL,
  `motofee` varchar(255) DEFAULT NULL,
  `overtimefee` varchar(255) DEFAULT NULL,
  `waterfee` varchar(255) DEFAULT NULL,
  `electricityfee` varchar(255) DEFAULT NULL,
  `deposit` varchar(255) DEFAULT NULL,
  `payment` varchar(255) DEFAULT NULL,
  `renttime` varchar(255) DEFAULT NULL,
  `decorationtime` varchar(255) DEFAULT NULL,
  `brokeragefee` decimal(13,2) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `linkofbuilding` varchar(255) DEFAULT NULL,
  `map` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `managername` varchar(255) DEFAULT NULL,
  `managerphone` varchar(255) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

LOCK TABLES `building` WRITE;
/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` VALUES (1,'Nam Giao Building Tower','59 phan xích long','Phường 2','QUAN_1','',2,500,'','',3,'3 tỷ','','','','',NULL,'','','','','',NULL,'NGUYEN_CAN,TANG_TRET','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Anh Nam-Chị Linh','0915354727',NULL),(2,'ACM Tower','96 cao thắng','Phường 4','QUAN_2','',2,650,'','',4,'4 tỷ','','','','',NULL,'','','','','',NULL,'NGUYEN_CAN','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Chú Thuận','0173546263',NULL),(3,'Alpha 2 Building Tower','153 nguyễn đình chiểu','Phường 6','QUAN_1','',1,200,'','',5,'5 tỷ','','','','',NULL,'','','','','',NULL,'NOI_THAT','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Cô Lý','0555532578',NULL),(4,'IDD 1 Building','111 Lý Chính Thắng','Phường 7','QUAN_1','',1,200,'','',2,'2 tỷ','','','','',NULL,'','','','','',NULL,'NGUYEN_CAN,NOI_THAT,TANG_TRET','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Anh Long','017345253','/building/Screenshot 2023-08-30 213636.png'),(7,'UIT School','Xa Lộ Hà Nội','5','QUAN_1','',0,NULL,'','',5,'','','','','',NULL,'','','','','',NULL,'NGUYEN_CAN,NOI_THAT','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','',NULL);
/*!40000 ALTER TABLE `building` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fullname` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `companyname` varchar(255) DEFAULT NULL,
  `demand` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Luc Van Hai','0905671231','hailv@gmail.com',NULL,NULL,NULL,0,NULL,'2024-05-28 02:23:35',NULL,'nguyenvana'),(2,'Nguyen Xuan Hong','0205671231','hongxuanng@gmail.com','','','DA_XL',1,NULL,'2024-05-26 13:18:22',NULL,'nguyenvana'),(3,'Ta Thi Cuc','0912121231','cucthita1@gmail.com',NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),(4,'Hà Phú Thịnh','0933516434','haphuthinh332004@gmail.com',NULL,'tôi muốn mua nhà hãy giúp tôi','CHUA_XL',1,'2024-05-27 07:36:42','2024-05-27 07:38:21','anonymousUser','nguyenvana'),(5,'','','',NULL,'','CHUA_XL',0,'2024-05-28 01:50:16','2024-05-28 14:36:24','anonymousUser','nguyenvana'),(6,'','','',NULL,'','CHUA_XL',0,'2024-05-28 02:07:43','2024-05-28 14:36:29','anonymousUser','nguyenvana'),(7,'Đặng Lê Thành Tâm','0973752924','danglethanhtam2004@gmail.com',NULL,'Nha sieu to khong lo','CHUA_XL',1,'2024-05-28 14:36:06',NULL,'anonymousUser',NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `installment`
--

DROP TABLE IF EXISTS `installment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `installment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  `amount` bigint DEFAULT NULL,
  `duedate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `installment`
--

LOCK TABLES `installment` WRITE;
/*!40000 ALTER TABLE `installment` DISABLE KEYS */;
INSERT INTO `installment` VALUES (1,'123','Test','',NULL,NULL,NULL,NULL,1,20000000,NULL),(2,'333','test','DANG_XL','2024-05-26 13:18:02',NULL,'nguyenvana',NULL,1,1200000,NULL),(3,'333','test','DA_XL','2024-05-27 03:12:10',NULL,'nguyenvana',NULL,1,1200000,NULL),(4,'333','test','DA_XL','2024-05-27 03:13:04',NULL,'nguyenvana',NULL,1,1200000,NULL),(5,'new','new','DA_XL','2024-05-27 03:14:33',NULL,'nguyenvana',NULL,1,1200000,NULL),(6,'new2','new2','DA_XL','2024-05-27 03:34:25',NULL,'nguyenvana',NULL,1,1200000,NULL),(7,'new2','new2','DA_XL','2024-05-27 03:35:02',NULL,'nguyenvana',NULL,1,1200000,NULL),(8,'333','test','DA_XL','2024-05-27 03:36:49',NULL,'nguyenvana',NULL,1,1200000,NULL),(9,'333','test','DA_XL','2024-05-27 03:37:54',NULL,'nguyenvana',NULL,1,1200000,NULL),(10,'333','test','DA_XL','2024-05-27 03:39:22',NULL,'nguyenvana',NULL,1,1200000,NULL),(11,'333','test','DA_XL','2024-05-27 03:41:27',NULL,'nguyenvana',NULL,1,1200000,NULL),(12,'333','test','DA_XL','2024-05-27 03:45:28',NULL,'nguyenvana',NULL,1,1200000,NULL),(13,'333','test','DA_XL','2024-05-27 03:46:57',NULL,'nguyenvana',NULL,1,1200000,NULL),(14,'333','test','DA_XL','2024-05-27 03:48:41',NULL,'nguyenvana',NULL,1,1200000,NULL),(15,'333','test','DA_XL','2024-05-27 03:51:25',NULL,'nguyenvana',NULL,1,1200000,NULL),(16,'333','test','DA_XL','2024-05-27 03:52:10',NULL,'nguyenvana',NULL,1,1200000,NULL),(17,'newne123','haha','DA_XL','2024-05-27 03:52:40',NULL,'nguyenvana',NULL,1,1200000,NULL),(18,'newne123','test','DA_XL','2024-05-27 03:53:50',NULL,'nguyenvana',NULL,1,1200000,NULL),(19,'newne123','new','DANG_XL',NULL,'2024-05-28 02:28:26',NULL,'nguyenvana',0,1200000123,NULL),(20,'33345','test','DA_XL',NULL,'2024-05-28 02:34:45',NULL,'nguyenvana',0,1200000,NULL),(21,'new','new','DANG_XL','2024-05-27 03:56:03',NULL,'nguyenvana',NULL,1,1200000,NULL),(22,'caiso5','caiso5','DANG_XL','2024-05-27 03:56:20',NULL,'nguyenvana',NULL,1,1200000,NULL),(23,'333','test','DANG_XL','2024-05-27 04:17:01',NULL,'nguyenvana',NULL,1,1200001,NULL),(24,'newne123','new','DANG_XL','2024-05-27 04:21:59',NULL,'nguyenvana',NULL,1,120000023,NULL),(25,'newne123','new','DANG_XL','2024-05-27 04:23:05',NULL,'nguyenvana',NULL,1,123,NULL),(26,'123','Test','CHUA_XL','2024-05-27 04:27:40',NULL,'nguyenvana',NULL,1,12234,NULL),(27,'newne123','new','DANG_XL','2024-05-27 04:28:43',NULL,'nguyenvana',NULL,1,1200023,NULL),(28,'newne123','new','DANG_XL','2024-05-27 04:29:21',NULL,'nguyenvana',NULL,1,120000023,NULL),(29,'TRAGOP01','Tra dot 1','DANG_XL','2024-05-28 13:58:32',NULL,'nguyenvana',NULL,1,100000000,NULL),(30,'TRAGOP02','Tra dot 2','DA_XL','2024-05-28 14:35:13',NULL,'nguyenvana',NULL,1,200000000,NULL);
/*!40000 ALTER TABLE `installment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rentarea`
--

DROP TABLE IF EXISTS `rentarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rentarea` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `value` int DEFAULT NULL,
  `buildingid` bigint DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rentarea_building` (`buildingid`),
  CONSTRAINT `rentarea_building` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentarea`
--

LOCK TABLES `rentarea` WRITE;
/*!40000 ALTER TABLE `rentarea` DISABLE KEYS */;
INSERT INTO `rentarea` VALUES (31,100,1,NULL,NULL,NULL,NULL),(32,200,1,NULL,NULL,NULL,NULL),(33,200,2,NULL,NULL,NULL,NULL),(34,300,2,NULL,NULL,NULL,NULL),(35,400,2,NULL,NULL,NULL,NULL),(36,300,3,NULL,NULL,NULL,NULL),(37,400,3,NULL,NULL,NULL,NULL),(38,500,3,NULL,NULL,NULL,NULL),(39,100,4,NULL,NULL,NULL,NULL),(40,400,4,NULL,NULL,NULL,NULL),(41,250,4,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `rentarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Quản lý','MANAGER',NULL,NULL,NULL,NULL),(2,'Nhân viên','STAFF',NULL,NULL,NULL,NULL),(3,'Khách hàng trả góp','INSTALLMENT_USER',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `customerid` bigint NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `staffid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customer_transaction` (`customerid`),
  CONSTRAINT `fk_customer_transaction` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,'DDX','test',4,'2024-05-27 07:37:25','2024-05-27 07:37:46','nguyenvana','nguyenvana',NULL),(2,'CSKH','Đã chăm sóc',4,'2024-05-27 07:39:17',NULL,'nguyenvanb',NULL,NULL);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `status` int NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'nguyenvana','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van a',NULL,NULL,1,NULL,NULL,NULL,NULL),(2,'nguyenvanb','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van b',NULL,NULL,1,NULL,NULL,NULL,NULL),(3,'nguyenvanc','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van c',NULL,NULL,1,NULL,NULL,NULL,NULL),(4,'nguyenvand','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van d',NULL,NULL,1,NULL,NULL,NULL,NULL),(5,'nguyenvancccc','$2a$10$vE72kqh.1ptf6aqOj9g7lOOkp30s4as05mUILWVpQ9bV5ibfFQWd6','Nguyen Van CC',NULL,NULL,0,'2024-05-26 13:34:50','2024-05-28 15:46:00','nguyenvana','nguyenvana'),(6,'huynh van cc','$2a$10$u4ZpCCmIfREmsqAu908n7.VucvMi3.m56KIaOwt5n5eTm590V.4EC','Huỳnh Văn cc',NULL,NULL,0,'2024-05-27 03:59:12','2024-05-28 15:46:00','nguyenvana','nguyenvana'),(7,'KHACHHANGTRA','$2a$10$E4/0lRGtTxDNwAOY7WGDQOjsAZmMb4u5GhfPHJ5zgoSzPCyegD72C','Nguyễn Văn Trả Góp',NULL,NULL,1,'2024-05-27 08:17:02',NULL,'anonymousUser',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role` (`user_id`),
  KEY `fk_role_user` (`role_id`),
  CONSTRAINT `fk_role_user` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1,NULL,NULL,NULL,NULL),(2,2,2,NULL,NULL,NULL,NULL),(3,2,3,NULL,NULL,NULL,NULL),(4,2,4,NULL,NULL,NULL,NULL),(5,2,5,NULL,NULL,NULL,NULL),(6,2,6,NULL,NULL,NULL,NULL),(7,3,7,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-29  7:30:44
