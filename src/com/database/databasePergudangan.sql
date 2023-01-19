-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 19, 2023 at 10:26 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pergudangan`
--

-- --------------------------------------------------------

--
-- Table structure for table `gudang`
--

CREATE TABLE `gudang` (
  `id_Gudang` int(11) NOT NULL,
  `nama_Gudang` varchar(50) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_Pelanggan` int(11) NOT NULL,
  `nama_Pelanggan` varchar(50) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `no_Telepon` varchar(50) NOT NULL,
  `isSupplier` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pencatatan`
--

CREATE TABLE `pencatatan` (
  `id_Pencatatan` int(11) NOT NULL,
  `id_Stack` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `id_Product` int(11) NOT NULL,
  `id_Pelanggan` int(11) NOT NULL,
  `tanggal_Pencatatan` date NOT NULL,
  `status` enum('INCOMING','OUTGOING','TRANSFERRED','RETURNED') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id_Product` int(11) NOT NULL,
  `id_Stack` int(11) NOT NULL,
  `nama_Barang` varchar(50) NOT NULL,
  `jenis_Barang` varchar(50) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `deskripsi_Barang` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stack`
--

CREATE TABLE `stack` (
  `id_Stack` int(11) NOT NULL,
  `id_Gudang` int(11) NOT NULL,
  `nama_Stack` varchar(50) NOT NULL,
  `kapasitas` int(11) NOT NULL,
  `isFull` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `nama_User` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `isUsed` tinyint(1) NOT NULL,
  `isAdmin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `nama_User`, `email`, `password`, `isUsed`, `isAdmin`) VALUES
('yann', 'Marcell', 'marcell@gmail', 'yann', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gudang`
--
ALTER TABLE `gudang`
  ADD PRIMARY KEY (`id_Gudang`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_Pelanggan`);

--
-- Indexes for table `pencatatan`
--
ALTER TABLE `pencatatan`
  ADD PRIMARY KEY (`id_Pencatatan`),
  ADD KEY `id_Pelanggan` (`id_Pelanggan`),
  ADD KEY `id_Stack` (`id_Stack`),
  ADD KEY `id_Product` (`id_Product`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id_Product`),
  ADD KEY `id_Stack` (`id_Stack`);

--
-- Indexes for table `stack`
--
ALTER TABLE `stack`
  ADD PRIMARY KEY (`id_Stack`),
  ADD KEY `id_Gudang` (`id_Gudang`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pencatatan`
--
ALTER TABLE `pencatatan`
  MODIFY `id_Pencatatan` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pencatatan`
--
ALTER TABLE `pencatatan`
  ADD CONSTRAINT `pencatatan_ibfk_1` FOREIGN KEY (`id_Pelanggan`) REFERENCES `pelanggan` (`id_Pelanggan`),
  ADD CONSTRAINT `pencatatan_ibfk_2` FOREIGN KEY (`id_Stack`) REFERENCES `stack` (`id_Stack`),
  ADD CONSTRAINT `pencatatan_ibfk_3` FOREIGN KEY (`id_Product`) REFERENCES `product` (`id_Product`),
  ADD CONSTRAINT `pencatatan_ibfk_4` FOREIGN KEY (`username`) REFERENCES `user` (`username`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`id_Stack`) REFERENCES `stack` (`id_Stack`),
  ADD CONSTRAINT `product_ibfk_2` FOREIGN KEY (`id_Stack`) REFERENCES `stack` (`id_Stack`),
  ADD CONSTRAINT `product_ibfk_3` FOREIGN KEY (`id_Stack`) REFERENCES `stack` (`id_Stack`);

--
-- Constraints for table `stack`
--
ALTER TABLE `stack`
  ADD CONSTRAINT `stack_ibfk_1` FOREIGN KEY (`id_Gudang`) REFERENCES `gudang` (`id_Gudang`),
  ADD CONSTRAINT `stack_ibfk_2` FOREIGN KEY (`id_Gudang`) REFERENCES `gudang` (`id_Gudang`),
  ADD CONSTRAINT `stack_ibfk_3` FOREIGN KEY (`id_Gudang`) REFERENCES `gudang` (`id_Gudang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
