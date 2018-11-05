-- MySQL dump 10.16  Distrib 10.1.26-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: maets
-- ------------------------------------------------------
-- Server version	10.1.26-MariaDB

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
-- Table structure for table `buyerinfo`
--

DROP TABLE IF EXISTS `buyerinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buyerinfo` (
  `userName` int(11) NOT NULL,
  `money` int(11) NOT NULL,
  `region` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyerinfo`
--

LOCK TABLES `buyerinfo` WRITE;
/*!40000 ALTER TABLE `buyerinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `buyerinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carts`
--

DROP TABLE IF EXISTS `carts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carts` (
  `productID` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  PRIMARY KEY (`productID`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carts`
--

LOCK TABLES `carts` WRITE;
/*!40000 ALTER TABLE `carts` DISABLE KEYS */;
/*!40000 ALTER TABLE `carts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gamelaunchers`
--

DROP TABLE IF EXISTS `gamelaunchers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gamelaunchers` (
  `productID` int(11) NOT NULL AUTO_INCREMENT,
  `fileLocation` varchar(100) NOT NULL,
  `revision` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gamelaunchers`
--

LOCK TABLES `gamelaunchers` WRITE;
/*!40000 ALTER TABLE `gamelaunchers` DISABLE KEYS */;
INSERT INTO `gamelaunchers` VALUES (7,'Blizzard.com',0),(8,'Blizzard.com',0);
/*!40000 ALTER TABLE `gamelaunchers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gamesstoreinfo`
--

DROP TABLE IF EXISTS `gamesstoreinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gamesstoreinfo` (
  `productID` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `price` double NOT NULL,
  `ageRating` int(2) NOT NULL,
  `description` varchar(500) NOT NULL,
  `minimumSpecs` varchar(100) NOT NULL,
  `genres` varchar(50) NOT NULL,
  `publisherID` int(11) NOT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gamesstoreinfo`
--

LOCK TABLES `gamesstoreinfo` WRITE;
/*!40000 ALTER TABLE `gamesstoreinfo` DISABLE KEYS */;
INSERT INTO `gamesstoreinfo` VALUES (0,'Game_Name',69.99,12,'This is a video game.','You\'ll need a lot to run this bad boy.','Horror',1),(7,'Diablo Immortal',0,12,'We milking you bois','Credit Card','MicroTransaction',1),(8,'Diablo Immortal',0,12,'We milking you bois','Credit Card','MicroTransaction',1);
/*!40000 ALTER TABLE `gamesstoreinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moviestoreinfo`
--

DROP TABLE IF EXISTS `moviestoreinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `moviestoreinfo` (
  `productID` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `price` double NOT NULL,
  `ageRating` int(2) NOT NULL,
  `description` varchar(500) NOT NULL,
  `runtime` int(11) NOT NULL,
  `genres` varchar(50) NOT NULL,
  `publisherID` int(11) NOT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moviestoreinfo`
--

LOCK TABLES `moviestoreinfo` WRITE;
/*!40000 ALTER TABLE `moviestoreinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `moviestoreinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `name` varchar(250) NOT NULL,
  `productID` int(11) NOT NULL AUTO_INCREMENT,
  `publisherID` int(11) NOT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('iohedf',1,1),('iohedf',2,1),('iohedf',3,1),('iohedf',4,1),('ojf',5,1),('ojf',6,1),('Diablo Immortal',7,1),('Diablo Immortal',8,1);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisherinfo`
--

DROP TABLE IF EXISTS `publisherinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publisherinfo` (
  `userName` varchar(32) NOT NULL,
  `publisherID` int(11) NOT NULL AUTO_INCREMENT,
  `publisherName` varchar(32) NOT NULL,
  PRIMARY KEY (`publisherID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisherinfo`
--

LOCK TABLES `publisherinfo` WRITE;
/*!40000 ALTER TABLE `publisherinfo` DISABLE KEYS */;
INSERT INTO `publisherinfo` VALUES ('jake1',1,'jakee');
/*!40000 ALTER TABLE `publisherinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessionrecords`
--

DROP TABLE IF EXISTS `sessionrecords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sessionrecords` (
  `userName` varchar(32) NOT NULL,
  `loginTime` datetime(6) DEFAULT NULL,
  `LogoutTime` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessionrecords`
--

LOCK TABLES `sessionrecords` WRITE;
/*!40000 ALTER TABLE `sessionrecords` DISABLE KEYS */;
INSERT INTO `sessionrecords` VALUES ('jhon_1','2018-10-30 18:49:20.000000',NULL),('newuser','2018-11-01 15:21:40.000000',NULL),('jhon_1','2018-11-05 12:23:26.000000',NULL),('jake1','2018-11-08 12:43:03.000000',NULL),('jake1','2018-11-08 12:43:06.000000',NULL),('jake1','2018-11-08 12:45:39.000000',NULL),('jake1','2018-11-08 12:46:39.000000',NULL);
/*!40000 ALTER TABLE `sessionrecords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userlogin`
--

DROP TABLE IF EXISTS `userlogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userlogin` (
  `userName` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `typeID` int(11) DEFAULT NULL,
  UNIQUE KEY `userName` (`userName`),
  KEY `typeID` (`typeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlogin`
--

LOCK TABLES `userlogin` WRITE;
/*!40000 ALTER TABLE `userlogin` DISABLE KEYS */;
INSERT INTO `userlogin` VALUES ('jhon_1','Ab12345678@',1),('jerome','Abcd1234@',3),('newuser','Abcd123$',3),('jake1','Ab12345678@',2);
/*!40000 ALTER TABLE `userlogin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertype`
--

DROP TABLE IF EXISTS `usertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertype` (
  `ID` int(11) NOT NULL,
  `type` varchar(32) NOT NULL,
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertype`
--

LOCK TABLES `usertype` WRITE;
/*!40000 ALTER TABLE `usertype` DISABLE KEYS */;
INSERT INTO `usertype` VALUES (1,'User'),(2,'Publisher'),(3,'Admin');
/*!40000 ALTER TABLE `usertype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-08 12:48:44
