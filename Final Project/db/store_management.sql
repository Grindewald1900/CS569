-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 22, 2020 at 02:57 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `store management`
--

-- --------------------------------------------------------

--
-- Table structure for table `compose`
--

CREATE TABLE `compose` (
  `ncde` int(11) NOT NULL,
  `reference` varchar(6) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `composed_of`
--

CREATE TABLE `composed_of` (
  `reference` varchar(6) DEFAULT NULL,
  `ref_marchandise` varchar(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `composed_of`
--

INSERT INTO `composed_of` (`reference`, `ref_marchandise`) VALUES
('h=tf', 'hhy'),
('h=tf', 'tttt'),
('hhgh', 'h=tf'),
('hhgh', 'hhy'),
('hhgh', 'juh'),
('hhgh', 'tttt'),
('frff', 'hhgh'),
('frff', 'hhy'),
('frff', 'juh');

-- --------------------------------------------------------

--
-- Table structure for table `contains`
--

CREATE TABLE `contains` (
  `reference` varchar(6) DEFAULT NULL,
  `id_raw_mat` varchar(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contains`
--

INSERT INTO `contains` (`reference`, `id_raw_mat`) VALUES
('frff', 'hhyii'),
('frff', 'hug');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` varchar(6) NOT NULL,
  `full_name_cs` varchar(40) NOT NULL,
  `address_cs` varchar(30) DEFAULT NULL,
  `telephone_cs` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `full_name_cs`, `address_cs`, `telephone_cs`) VALUES
('A5', 'Ayoub Alaoui', 'Sherbrooke, Qc, Canada', '1456985'),
('A123', 'Lexane Trottier', 'North Hatley, Sherbrooke', '81955465'),
('CT208', 'Mathias LeBlanc', '12, road island, Las Vegas, US', '2138567894'),
('T456', 'Alex Grenier', '12, Rue Jonquiere, Qc, Canada', '214568468');

-- --------------------------------------------------------

--
-- Table structure for table `dispose`
--

CREATE TABLE `dispose` (
  `store_id` varchar(6) DEFAULT NULL,
  `reference` varchar(6) DEFAULT NULL,
  `stock_qty` double DEFAULT NULL,
  `price_store` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dispose`
--

INSERT INTO `dispose` (`store_id`, `reference`, `stock_qty`, `price_store`) VALUES
('qq', 'juh', 100, 100);

-- --------------------------------------------------------

--
-- Table structure for table `invoiced_order`
--

CREATE TABLE `invoiced_order` (
  `ncde` int(11) NOT NULL,
  `customer_id` varchar(6) NOT NULL,
  `date_of_order` varchar(50) DEFAULT NULL,
  `date_of_delivery` varchar(50) DEFAULT NULL,
  `payment_method` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `invoiced_order`
--

INSERT INTO `invoiced_order` (`ncde`, `customer_id`, `date_of_order`, `date_of_delivery`, `payment_method`, `state`) VALUES
(14, 'A2', '12/05/2005', '12/05/2006', 'chèque', 'Bon');

-- --------------------------------------------------------

--
-- Table structure for table `machine`
--

CREATE TABLE `machine` (
  `code_m` varchar(6) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `description` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `machine`
--

INSERT INTO `machine` (`code_m`, `designation`, `description`) VALUES
('ID1', 'Sewing machine', 'Used for textile'),
('A256', 'Machine 1', 'Does something'),
('ID2', 'Coffee machine', 'Prepares coffee'),
('ID3', 'Assembly', 'Assembles pieces'),
('ID4', 'Wrapper', 'Wraps merchandise');

-- --------------------------------------------------------

--
-- Table structure for table `merchandise`
--

CREATE TABLE `merchandise` (
  `reference` varchar(6) NOT NULL,
  `desig` varchar(20) NOT NULL,
  `unit_price` double DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `merchandise`
--

INSERT INTO `merchandise` (`reference`, `desig`, `unit_price`, `type`) VALUES
('f1', 'TV', 100, 'B'),
('A1', 'Radio', 140, 'C'),
('AT209', 'Dodge Engine', 2500, 'Mechanic'),
('BA103', 'Play station', 200, 'Games and Entertainm'),
('GT201', 'Toshiba Cosmio', 900, 'Laptop'),
('H201', 'Hamilton Beach', 120, 'Electronic');

-- --------------------------------------------------------

--
-- Table structure for table `passed_by`
--

CREATE TABLE `passed_by` (
  `code_m` varchar(6) DEFAULT NULL,
  `reference` varchar(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `passed_by`
--

INSERT INTO `passed_by` (`code_m`, `reference`) VALUES
('ID1', 'id4'),
('ID4', 'A256'),
('ID4', 'ID3'),
('ID1', 'id3'),
('ID1', 'id2');

-- --------------------------------------------------------

--
-- Table structure for table `prefer`
--

CREATE TABLE `prefer` (
  `customer_id` varchar(6) DEFAULT NULL,
  `store_id` varchar(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `processed_by`
--

CREATE TABLE `processed_by` (
  `code_mat` varchar(6) DEFAULT NULL,
  `code_m` varchar(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `processed_by`
--

INSERT INTO `processed_by` (`code_mat`, `code_m`) VALUES
('GT201', 'ID4'),
('id2', 'ID3'),
('id1', 'A256'),
('AT209', 'ID1');

-- --------------------------------------------------------

--
-- Table structure for table `rawmaterial`
--

CREATE TABLE `rawmaterial` (
  `code_mat` varchar(6) NOT NULL,
  `designation` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rawmaterial`
--

INSERT INTO `rawmaterial` (`code_mat`, `designation`) VALUES
('id1', 'Water'),
('id2', 'Iron'),
('id3', 'Wood'),
('id4', 'Cotton'),
('id5', 'Ground'),
('id6', 'Oil');

-- --------------------------------------------------------

--
-- Table structure for table `store`
--

CREATE TABLE `store` (
  `store_id` varchar(6) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `address` varchar(30) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `store`
--

INSERT INTO `store` (`store_id`, `designation`, `address`, `telephone`) VALUES
('ddff', 'ALPHA', 'Rue de cuni', '12455'),
('qq', 'ddd', 'dd', 'fff'),
('hh', 'hfgfgf', 'ff', '445'),
('hhujhj', 'Nafia', 'sssd', '455');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` varchar(25) NOT NULL,
  `pwd` varchar(25) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `pwd`) VALUES
('sss', 'sss'),
('fff', 'ffffhhhh');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `invoiced_order`
--
ALTER TABLE `invoiced_order`
  ADD PRIMARY KEY (`ncde`);

--
-- Indexes for table `machine`
--
ALTER TABLE `machine`
  ADD PRIMARY KEY (`code_m`);

--
-- Indexes for table `merchandise`
--
ALTER TABLE `merchandise`
  ADD PRIMARY KEY (`reference`);

--
-- Indexes for table `rawmaterial`
--
ALTER TABLE `rawmaterial`
  ADD PRIMARY KEY (`code_mat`);

--
-- Indexes for table `store`
--
ALTER TABLE `store`
  ADD PRIMARY KEY (`store_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
