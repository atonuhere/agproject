CREATE DATABASE  IF NOT EXISTS `erm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `erm`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: erm
-- ------------------------------------------------------
-- Server version	5.6.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `eventlog`
--

DROP TABLE IF EXISTS `eventlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventlog` (
  `eventLogId` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation_date` datetime DEFAULT NULL,
  `description` longtext NOT NULL,
  `summary` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`eventLogId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventlog`
--

LOCK TABLES `eventlog` WRITE;
/*!40000 ALTER TABLE `eventlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidentlog`
--

DROP TABLE IF EXISTS `incidentlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incidentlog` (
  `incId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdById` bigint(20) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `dateModified` datetime DEFAULT NULL,
  `modifiedById` bigint(20) DEFAULT NULL,
  `action_taken` varchar(255) DEFAULT NULL,
  `active` int(11) NOT NULL,
  `descriptions` text,
  `inc_category` varchar(255) DEFAULT NULL,
  `inc_date` datetime DEFAULT NULL,
  `inc_location` varchar(255) DEFAULT NULL,
  `inc_number` varchar(50) NOT NULL,
  `inc_status` int(11) DEFAULT NULL,
  `logged_by` bigint(20) DEFAULT NULL,
  `remarks` text,
  `reported_by` varchar(255) NOT NULL,
  `reported_on` datetime DEFAULT NULL,
  `reporter_details` varchar(255) DEFAULT NULL,
  `branch_id` bigint(20) NOT NULL,
  `inc_type` bigint(20) NOT NULL,
  PRIMARY KEY (`incId`),
  UNIQUE KEY `UK_g3ppx2ofa9p0p50bfxtn1u1se` (`inc_number`),
  KEY `FK_6l0w7g9wvv383qptfjoxv7u2v` (`branch_id`),
  KEY `FK_e3chbvxtlexxo91k7ql56noxk` (`inc_type`),
  CONSTRAINT `FK_6l0w7g9wvv383qptfjoxv7u2v` FOREIGN KEY (`branch_id`) REFERENCES `masterbranch` (`branchId`),
  CONSTRAINT `FK_e3chbvxtlexxo91k7ql56noxk` FOREIGN KEY (`inc_type`) REFERENCES `masterincidenttype` (`incTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidentlog`
--

LOCK TABLES `incidentlog` WRITE;
/*!40000 ALTER TABLE `incidentlog` DISABLE KEYS */;
INSERT INTO `incidentlog` VALUES (8,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,'2014-05-06 00:00:00',NULL,'1',1,NULL,NULL,'Maidul',NULL,NULL,1,1);
/*!40000 ALTER TABLE `incidentlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masterbranch`
--

DROP TABLE IF EXISTS `masterbranch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `masterbranch` (
  `branchId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdById` bigint(20) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `dateModified` datetime DEFAULT NULL,
  `modifiedById` bigint(20) DEFAULT NULL,
  `cont_address` text,
  `code` varchar(255) NOT NULL,
  `contactNo` varchar(255) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pan` varchar(255) DEFAULT NULL,
  `btype` int(1) DEFAULT '1',
  `comp_id` bigint(20) NOT NULL,
  PRIMARY KEY (`branchId`),
  UNIQUE KEY `UK_dxdgulyaaqqsph50ofpt638cr` (`code`),
  KEY `FK_cpwld3rhe8tgt3gjl1m1i30ll` (`comp_id`),
  CONSTRAINT `FK_cpwld3rhe8tgt3gjl1m1i30ll` FOREIGN KEY (`comp_id`) REFERENCES `mastercompany` (`compId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masterbranch`
--

LOCK TABLES `masterbranch` WRITE;
/*!40000 ALTER TABLE `masterbranch` DISABLE KEYS */;
INSERT INTO `masterbranch` VALUES (1,NULL,NULL,NULL,NULL,'kolkata','201','99999999','',NULL,NULL,NULL,NULL,1,1);
/*!40000 ALTER TABLE `masterbranch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mastercompany`
--

DROP TABLE IF EXISTS `mastercompany`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mastercompany` (
  `compId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdById` bigint(20) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `dateModified` datetime DEFAULT NULL,
  `modifiedById` bigint(20) DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `isParent` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`compId`),
  UNIQUE KEY `UK_495m356etqqiayceklc1oonp6` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mastercompany`
--

LOCK TABLES `mastercompany` WRITE;
/*!40000 ALTER TABLE `mastercompany` DISABLE KEYS */;
INSERT INTO `mastercompany` VALUES (1,NULL,NULL,NULL,NULL,'202','xxx',2,'GFS');
/*!40000 ALTER TABLE `mastercompany` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masterincidentstatus`
--

DROP TABLE IF EXISTS `masterincidentstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `masterincidentstatus` (
  `incStatusId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdById` bigint(20) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `dateModified` datetime DEFAULT NULL,
  `modifiedById` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`incStatusId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masterincidentstatus`
--

LOCK TABLES `masterincidentstatus` WRITE;
/*!40000 ALTER TABLE `masterincidentstatus` DISABLE KEYS */;
INSERT INTO `masterincidentstatus` VALUES (1,0,NULL,NULL,NULL,'Open');
/*!40000 ALTER TABLE `masterincidentstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masterincidenttype`
--

DROP TABLE IF EXISTS `masterincidenttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `masterincidenttype` (
  `incTypeId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdById` bigint(20) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `dateModified` datetime DEFAULT NULL,
  `modifiedById` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`incTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masterincidenttype`
--

LOCK TABLES `masterincidenttype` WRITE;
/*!40000 ALTER TABLE `masterincidenttype` DISABLE KEYS */;
INSERT INTO `masterincidenttype` VALUES (1,NULL,NULL,NULL,NULL,'Fire');
/*!40000 ALTER TABLE `masterincidenttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `permissionId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdById` bigint(20) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `dateModified` datetime DEFAULT NULL,
  `modifiedById` bigint(20) DEFAULT NULL,
  `function_id` varchar(255) DEFAULT NULL,
  `menu_id` varchar(255) NOT NULL,
  `submenu_id` varchar(255) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`permissionId`),
  KEY `FK_57pohr0344vpxpx85qj80i32s` (`role_id`),
  CONSTRAINT `FK_57pohr0344vpxpx85qj80i32s` FOREIGN KEY (`role_id`) REFERENCES `role` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `roleId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdById` bigint(20) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `dateModified` datetime DEFAULT NULL,
  `modifiedById` bigint(20) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `roleName` varchar(255) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,NULL,NULL,NULL,NULL,'Supervisor','Supervisor');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdById` bigint(20) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `dateModified` datetime DEFAULT NULL,
  `modifiedById` bigint(20) DEFAULT NULL,
  `active` int(11) DEFAULT '1',
  `branchIds` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `lastLoggedin` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `utype` int(11) DEFAULT '1',
  `username` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `UK_e6gkqunxajvyxl5uctpl2vl2p` (`email`),
  KEY `FK_fe6nqh4mlcjr068gcfrstmh2y` (`role_id`),
  CONSTRAINT `FK_fe6nqh4mlcjr068gcfrstmh2y` FOREIGN KEY (`role_id`) REFERENCES `role` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,NULL,NULL,NULL,1,'1',NULL,NULL,NULL,NULL,NULL,1,NULL,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'erm'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-25  0:29:52
