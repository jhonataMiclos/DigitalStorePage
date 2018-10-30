-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 30, 2018 at 07:58 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `maets`
--

-- --------------------------------------------------------

--
-- Table structure for table `buyerinfo`
--

CREATE TABLE `buyerinfo` (
  `userName` int(11) NOT NULL,
  `money` int(11) NOT NULL,
  `region` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `gamelaunchers`
--

CREATE TABLE `gamelaunchers` (
  `productID` int(11) NOT NULL,
  `fileLocation` varchar(100) NOT NULL,
  `revision` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `gamesstoreinfo`
--

CREATE TABLE `gamesstoreinfo` (
  `productID` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `price` double NOT NULL,
  `ageRating` int(2) NOT NULL,
  `description` varchar(500) NOT NULL,
  `minimumSpecs` varchar(100) NOT NULL,
  `genres` varchar(50) NOT NULL,
  `publisherID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gamesstoreinfo`
--

INSERT INTO `gamesstoreinfo` (`productID`, `name`, `price`, `ageRating`, `description`, `minimumSpecs`, `genres`, `publisherID`) VALUES
(0, 'Game_Name', 69.99, 12, 'This is a video game.', 'You\'ll need a lot to run this bad boy.', 'Horror', 1);

-- --------------------------------------------------------

--
-- Table structure for table `moviestoreinfo`
--

CREATE TABLE `moviestoreinfo` (
  `productID` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `price` double NOT NULL,
  `ageRating` int(2) NOT NULL,
  `description` varchar(500) NOT NULL,
  `runtime` int(11) NOT NULL,
  `genres` varchar(50) NOT NULL,
  `publisherID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `publisherinfo`
--

CREATE TABLE `publisherinfo` (
  `userName` int(11) NOT NULL,
  `publisherID` int(11) NOT NULL,
  `publisherName` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sessionrecords`
--

CREATE TABLE `sessionrecords` (
  `userName` varchar(32) NOT NULL,
  `loginTime` datetime(6) DEFAULT NULL,
  `LogoutTime` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sessionrecords`
--

INSERT INTO `sessionrecords` (`userName`, `loginTime`, `LogoutTime`) VALUES
('jhon_1', '2018-10-30 18:49:20.000000', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `userlogin`
--

CREATE TABLE `userlogin` (
  `userName` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `typeID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userlogin`
--

INSERT INTO `userlogin` (`userName`, `password`, `typeID`) VALUES
('jhon_1', 'Ab12345678@', 1);

-- --------------------------------------------------------

--
-- Table structure for table `usertype`
--

CREATE TABLE `usertype` (
  `ID` int(11) NOT NULL,
  `type` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usertype`
--

INSERT INTO `usertype` (`ID`, `type`) VALUES
(1, 'User'),
(2, 'Publisher'),
(3, 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gamelaunchers`
--
ALTER TABLE `gamelaunchers`
  ADD PRIMARY KEY (`productID`);

--
-- Indexes for table `gamesstoreinfo`
--
ALTER TABLE `gamesstoreinfo`
  ADD PRIMARY KEY (`productID`);

--
-- Indexes for table `moviestoreinfo`
--
ALTER TABLE `moviestoreinfo`
  ADD PRIMARY KEY (`productID`);

--
-- Indexes for table `publisherinfo`
--
ALTER TABLE `publisherinfo`
  ADD UNIQUE KEY `userName` (`userName`);

--
-- Indexes for table `userlogin`
--
ALTER TABLE `userlogin`
  ADD UNIQUE KEY `userName` (`userName`),
  ADD KEY `typeID` (`typeID`);

--
-- Indexes for table `usertype`
--
ALTER TABLE `usertype`
  ADD UNIQUE KEY `ID` (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `gamelaunchers`
--
ALTER TABLE `gamelaunchers`
  MODIFY `productID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
