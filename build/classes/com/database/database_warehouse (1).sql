-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 23, 2023 at 01:00 PM
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

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_Barang`, `id_Rak`, `nama_Barang`, `kategori_Barang`, `jumlah`, `deskripsi`, `isDeleted`) VALUES
(1, 2, 'Shampoo Dove', 'Pembersih Rambut Kecantikan', 10, 'Shampoo Dove yang lembut dan aman digunakan untuk semua jenis rambut', 0),
(3, 1, 'Kopi Arabika', 'Minuman', 25, 'Kopi arabika yang diproses dengan metode manual untuk menghasilkan rasa yang kaya', 0),
(4, 1, 'Shampoo Dove', 'Pembersih Rambut Kecantikan', 40, 'Shampoo Dove yang lembut dan aman digunakan untuk semua jenis rambut', 1),
(9, 4, 'Sikat Gigi Colgate', 'Alat Kesehatan', 50, 'Sikat gigi Colgate dengan teknologi terbaru untuk membersihkan gigi secara efektif', 0),
(10, 4, 'Sikat Gigi Colgate', 'Alat Kesehatan', 50, 'Sikat gigi Colgate dengan teknologi terbaru untuk membersihkan gigi secara efektif', 1);

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
(1, 'Gudang A', 'Jl. Jenderal Sudirman No.1, Jakarta'),
(2, 'Gudang B', 'Jl. Jenderal Ahmad Yani No.2, Bandung'),
(3, 'Gudang C', 'Jl. Jenderal Gatot Subroto No.3, Surabaya'),
(4, 'Gudang D', 'Jl. Jenderal Besar Soedirman No.4, Medan'),
(5, 'Gudang E', 'Jl. Jenderal Besar Mohammad Hatta No.5, Makassar'),
(9, 'Gudang F', 'Jl. Kelapa Manis no 10');

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

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_Pelanggan`, `nama_Pelanggan`, `alamat`, `email`, `no_Telepon`, `isSupplier`) VALUES
(1, 'Emily Davis', 'Jl. Melawai No. 20', 'emilydavis@gmail.com', '084567890123', 1),
(2, 'John Doe', 'Jl. Raya No. 1', 'johndoe@gmail.com', '081234567890', 0),
(3, 'Jane Smith', 'Jl. Kebon Jeruk No. 10', 'janesmith@gmail.com', '082345678901', 1),
(4, 'Michael Brown', 'Jl. Sudirman No. 15', 'michaelbrown@gmail.com', '083456789012', 0);

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
  `status` enum('INCOMING','OUTGOING','TRANSFERRED') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pencatatan`
--

INSERT INTO `pencatatan` (`id_Pencatatan`, `id_Rak`, `username`, `id_Barang`, `id_Pelanggan`, `tanggal`, `status`) VALUES
(1, 1, 'yann', 1, 1, '2023-01-22', 'INCOMING'),
(2, 1, 'yann', 3, 1, '2023-01-23', 'INCOMING'),
(3, 1, 'yann', 1, 1, '2023-01-22', 'TRANSFERRED'),
(5, 1, 'yann', 4, 2, '2023-01-22', 'INCOMING'),
(6, 1, 'yann', 4, 2, '2023-01-22', 'INCOMING'),
(7, 1, 'yann', 4, 2, '2023-01-22', 'INCOMING'),
(8, 1, 'yann', 4, 2, '2023-01-22', 'INCOMING'),
(9, 1, 'yann', 4, 2, '2023-01-22', 'OUTGOING'),
(10, 1, 'yann', 4, 4, '2023-01-22', 'OUTGOING'),
(11, 2, 'Danar', 1, 1, '2023-01-22', 'TRANSFERRED'),
(12, 3, 'Danar', 9, 1, '2023-01-23', 'INCOMING'),
(13, 4, 'Danar', 9, 1, '2023-01-23', 'TRANSFERRED'),
(14, 4, 'Danar', 10, 4, '2023-01-23', 'OUTGOING');

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

--
-- Dumping data for table `rak_gudang`
--

INSERT INTO `rak_gudang` (`id_Rak`, `id_Gudang`, `nama_Rak`, `Kapasitas`, `isFull`) VALUES
(1, 1, 'Rak A', 100, 0),
(2, 1, 'Rak C', 100, 0),
(3, 9, 'Rak A', 100, 0),
(4, 5, 'Rak A', 100, 0),
(5, 3, 'Rak A', 100, 0);

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
('aylor', 'William Taylor', 'williamtaylor@gmail.com', 'password666', 1, 1),
('Danar', 'Danar Wija', 'danar@gmail.com', 'hola', 1, 1),
('hael', 'Michael Brown', 'michaelbrown@gmail.com', 'password222', 0, 1),
('mama', 'mama', 'mama@gmail.com', 'mama', 0, 1),
('user1', 'John Doe', 'johndoe@gmail.com', '123456', 1, 1),
('user2', 'Sarah Williams', 'sarahwilliams@gmail.com', '123456', 1, 1),
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
  MODIFY `id_Barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `gudang`
--
ALTER TABLE `gudang`
  MODIFY `id_Gudang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id_Pelanggan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `pencatatan`
--
ALTER TABLE `pencatatan`
  MODIFY `id_Pencatatan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `rak_gudang`
--
ALTER TABLE `rak_gudang`
  MODIFY `id_Rak` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
