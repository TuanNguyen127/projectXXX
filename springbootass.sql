-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 23, 2018 lúc 04:13 PM
-- Phiên bản máy phục vụ: 10.1.28-MariaDB
-- Phiên bản PHP: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `springbootass`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invoice`
--

CREATE TABLE `invoice` (
  `idinvoice` int(11) NOT NULL,
  `customername` varchar(50) DEFAULT NULL,
  `numberphone` varchar(20) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `productname` varchar(50) DEFAULT NULL,
  `quantity` varchar(10) DEFAULT NULL,
  `money` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `invoice`
--

INSERT INTO `invoice` (`idinvoice`, `customername`, `numberphone`, `address`, `productname`, `quantity`, `money`) VALUES
(1, 'Nguyễn Văn Tuấn', '0123456789', '123 Nguyễn Văn A', 'samsung galaxy ss', '1', '20000000'),
(2, 'Dương Tnành Vũ', '0987654321', '11/11/11 Nguyễn Văn B', 'laptop dell', '2', '100000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `idproduct` int(11) NOT NULL,
  `productname` varchar(50) DEFAULT NULL,
  `quantity` varchar(10) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL,
  `image` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `product`
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
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `iduser` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `role` varchar(20) DEFAULT 'user',
  `avatar` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`iduser`, `username`, `password`, `email`, `role`, `avatar`) VALUES
(15, 'admin', 'admin123', 'admin@gmail.com', 'admin', '18033503_1316361428452229_4784812576813699924_n.jpg'),
(16, 'user', '123456', 'user@gmail.com', 'user', '18403160_243558402789207_1781303159863596889_n.jpg'),
(18, 'tuan', '123456', 'tuan@gmail.com', 'user', '24129797_159181621481116_3420292741263157417_n.jpg'),
(20, 'admin123', '123123', 'admin123@gmail.com', 'user', '22449911_2016763005206039_8398298410270631644_n.jpg'),
(21, 'themUser', '123123', 'themUser@gmail.com', 'admin', 'oppo-f7-bac-400x460.png');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`idinvoice`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`idproduct`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`iduser`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `invoice`
--
ALTER TABLE `invoice`
  MODIFY `idinvoice` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `idproduct` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
