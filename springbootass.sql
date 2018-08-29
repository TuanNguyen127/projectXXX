-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 29, 2018 at 12:47 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 5.6.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `springbootass`
--
CREATE DATABASE IF NOT EXISTS `springbootass` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `springbootass`;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(3),
(3),
(3),
(3);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `idinvoice` int(11) NOT NULL,
  `customername` varchar(50) DEFAULT NULL,
  `numberphone` varchar(20) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`idinvoice`, `customername`, `numberphone`, `address`, `status`) VALUES
(11, 'Bùi Tiến Dũng', '0985390133', '41/32 Đường số 9, P. Linh Tây, Thủ Đức', 'Đang giao hàng'),
(12, 'Nguyễn Văn Tuấn', '04378294278', 'Buôn Ma Thuột, Đăk Lăk, Việt Nam', 'Đang giao hàng');

-- --------------------------------------------------------

--
-- Table structure for table `invoicedetail`
--

CREATE TABLE `invoicedetail` (
  `idinvoicedetail` int(11) NOT NULL,
  `idinvoice` int(11) NOT NULL,
  `idproduct` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `invoicedetail`
--

INSERT INTO `invoicedetail` (`idinvoicedetail`, `idinvoice`, `idproduct`, `quantity`, `price`) VALUES
(5, 11, 15, 1, 8990000),
(6, 11, 16, 1, 1990000),
(7, 11, 12, 3, 83970000),
(8, 11, 14, 1, 40000000),
(9, 12, 18, 2, 15980000);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `idproduct` int(11) NOT NULL,
  `productname` varchar(50) DEFAULT NULL,
  `quantity` varchar(10) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL,
  `image` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`idproduct`, `productname`, `quantity`, `price`, `image`) VALUES
(12, 'Samsung Galaxy S9+', '101', '27990000', 'medium-iphone-x-lock-2.jpg'),
(13, 'IPhone XX', '10', '30000000', 'medium-iphone-x-lock-2.jpg'),
(14, 'LapTop Asus UX370U', '5', '40000000', 'asus-ux370u-i7-8550u-8gb-512gb-win10-c4217ts-but-600x600.jpg'),
(15, 'Nokia 7 Plus', '20', '8990000', 'nokia-7-plus-2-200x200.jpg'),
(16, 'Mobiistar Lai Zumbo S Lite', '8', '1990000', 'mobiistar-zumbo-s-lite-2017-400-400x460.png'),
(17, 'BlackBerry Torch 9810', '11', '6890000', 'dien-thoai-di-dong-BlackBerry-Torch-9810-dienmay.com-b.jpg'),
(18, 'OPPO F7', '22', '7990000', 'oppo-f7-bac-400x460.png'),
(19, 'Samsung Galaxy J6', '43', '4790000', 'samsung-galaxy-j6-2018-1-400x460-400x460-400x460-400x460.png'),
(20, 'iPhone 8 Plus Red 256GB', '5', '28790000', 'iphone-8-plus-do-256gb-400x460.png'),
(21, 'Huawei P20 Pro', '11', '19990000', 'huawei-p20-pro-h1-400x460.png'),
(22, 'Sony Xperia XZ1', '8', '9990000', 'sony-xperia-xz1-xanh-2-400x460.png');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `iduser` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(70) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `role` varchar(20) DEFAULT 'user',
  `avatar` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`iduser`, `username`, `password`, `email`, `role`, `avatar`) VALUES
(15, 'admin', '$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.', 'admin@gmail.com', 'admin', '18033503_1316361428452229_4784812576813699924_n.jpg'),
(16, 'user', '/n/b/n/d/n\\n\\b\\n\\d\\n', 'user@gmail.com', 'user', '18403160_243558402789207_1781303159863596889_n.jpg'),
(18, 'tuan', '123456', 'tuan@gmail.com', 'user', '24129797_159181621481116_3420292741263157417_n.jpg'),
(20, 'admin123', '123123', 'admin123@gmail.com', 'user', '22449911_2016763005206039_8398298410270631644_n.jpg'),
(21, 'themUser', '123123', 'themUser@gmail.com', 'admin', 'oppo-f7-bac-400x460.png'),
(22, 'nguoidung1', '$2a$10$QtxLsn4jVQVcY48a2jN6oeTFYlgb6/G7b9Cn1hfnH8QrLz0gKnrrW', 'nguoidung1@abc.com', 'user', NULL),
(24, 'vudt.93', 'bb1bb8c4-485a-441b-ab71-fe2d4f2e2fce', 'vudt.93@gmail.com', 'user', 'ab01e435-3350-4da1-b433-ab5270cdc81a.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`idinvoice`);

--
-- Indexes for table `invoicedetail`
--
ALTER TABLE `invoicedetail`
  ADD PRIMARY KEY (`idinvoicedetail`),
  ADD KEY `invoicedetail` (`idinvoice`),
  ADD KEY `invoiceproduct` (`idproduct`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`idproduct`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`iduser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `idinvoice` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `invoicedetail`
--
ALTER TABLE `invoicedetail`
  MODIFY `idinvoicedetail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `idproduct` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `invoicedetail`
--
ALTER TABLE `invoicedetail`
  ADD CONSTRAINT `invoicedetail` FOREIGN KEY (`idinvoice`) REFERENCES `invoice` (`idinvoice`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `invoiceproduct` FOREIGN KEY (`idproduct`) REFERENCES `product` (`idproduct`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
