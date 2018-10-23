-- MySQL dump 10.16  Distrib 10.1.36-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: maets
-- ------------------------------------------------------
-- Server version	10.1.36-MariaDB

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
INSERT INTO `gamesstoreinfo` VALUES (0,'Game_Name',69.99,12,'This is a video game.','You\'ll need a lot to run this bad boy.','Horror',1);
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
-- Table structure for table `publisherinfo`
--

DROP TABLE IF EXISTS `publisherinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publisherinfo` (
  `userName` int(11) NOT NULL,
  `publisherID` int(11) NOT NULL,
  `publisherName` int(11) NOT NULL,
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisherinfo`
--

LOCK TABLES `publisherinfo` WRITE;
/*!40000 ALTER TABLE `publisherinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `publisherinfo` ENABLE KEYS */;
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
INSERT INTO `userlogin` VALUES ('jhon_1','Ab12345678@',1);
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

-- Dump completed on 2018-10-23 16:29:35
