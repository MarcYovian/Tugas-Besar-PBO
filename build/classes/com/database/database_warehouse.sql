-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 20, 2023 at 06:09 AM
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
-- Database: `database_warehouse`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_Barang` int(11) NOT NULL,
  `id_Rak` int(11) NOT NULL,
  `nama_Barang` varchar(50) NOT NULL,
  `kategori_Barang` varchar(50) DEFAULT NULL,
  `jumlah` int(11) NOT NULL,
  `deskripsi` varchar(255) DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `gudang`
--

CREATE TABLE `gudang` (
  `id_Gudang` int(11) NOT NULL,
  `nama_Gudang` varchar(50) NOT NULL,
  `alamat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gudang`
--

INSERT INTO `gudang` (`id_Gudang`, `nama_Gudang`, `alamat`) VALUES
(1, 'halo', 'halo');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_Pelanggan` int(11) NOT NULL,
  `nama_Pelanggan` varchar(50) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `no_Telepon` varchar(20) NOT NULL,
  `isSupplier` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pencatatan`
--

CREATE TABLE `pencatatan` (
  `id_Pencatatan` int(11) NOT NULL,
  `id_Rak` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `id_Barang` int(11) NOT NULL,
  `id_Pelanggan` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `status` enum('INCOMING','OUTGOING','TRANSFERRED','RETURNED') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rak_gudang`
--

CREATE TABLE `rak_gudang` (
  `id_Rak` int(11) NOT NULL,
  `id_Gudang` int(11) NOT NULL,
  `nama_Rak` varchar(50) NOT NULL,
  `Kapasitas` int(11) NOT NULL,
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
  `password` varchar(50) NOT NULL,
  `isUsed` tinyint(1) NOT NULL,
  `isAdmin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `nama_User`, `email`, `password`, `isUsed`, `isAdmin`) VALUES
('Danar', 'danar@gmail.com', 'narr', 'hola', 0, 1),
('yann', 'Marcellinus Yovian', 'marcellinus@gmail', 'yann', 1, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_Barang`),
  ADD KEY `id_Rak` (`id_Rak`);

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
  ADD KEY `id_Rak` (`id_Rak`),
  ADD KEY `username` (`username`),
  ADD KEY `id_Barang` (`id_Barang`),
  ADD KEY `id_Pelanggan` (`id_Pelanggan`);

--
-- Indexes for table `rak_gudang`
--
ALTER TABLE `rak_gudang`
  ADD PRIMARY KEY (`id_Rak`),
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
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id_Barang` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `gudang`
--
ALTER TABLE `gudang`
  MODIFY `id_Gudang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id_Pelanggan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pencatatan`
--
ALTER TABLE `pencatatan`
  MODIFY `id_Pencatatan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rak_gudang`
--
ALTER TABLE `rak_gudang`
  MODIFY `id_Rak` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`id_Rak`) REFERENCES `rak_gudang` (`id_Rak`);

--
-- Constraints for table `pencatatan`
--
ALTER TABLE `pencatatan`
  ADD CONSTRAINT `pencatatan_ibfk_1` FOREIGN KEY (`id_Rak`) REFERENCES `rak_gudang` (`id_Rak`),
  ADD CONSTRAINT `pencatatan_ibfk_2` FOREIGN KEY (`username`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `pencatatan_ibfk_3` FOREIGN KEY (`id_Rak`) REFERENCES `rak_gudang` (`id_Rak`),
  ADD CONSTRAINT `pencatatan_ibfk_4` FOREIGN KEY (`username`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `pencatatan_ibfk_5` FOREIGN KEY (`id_Barang`) REFERENCES `barang` (`id_Barang`),
  ADD CONSTRAINT `pencatatan_ibfk_6` FOREIGN KEY (`id_Pelanggan`) REFERENCES `pelanggan` (`id_Pelanggan`);

--
-- Constraints for table `rak_gudang`
--
ALTER TABLE `rak_gudang`
  ADD CONSTRAINT `rak_gudang_ibfk_1` FOREIGN KEY (`id_Gudang`) REFERENCES `gudang` (`id_Gudang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
