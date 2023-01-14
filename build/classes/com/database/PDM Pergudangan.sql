CREATE TABLE `Gudang` (
  `id_Gudang` int PRIMARY KEY,
  `nama_Gudang` varchar(50),
  `alamat` varchar(255)
);

CREATE TABLE `Stack` (
  `id_Stack` int PRIMARY KEY,
  `id_Gudang` int,
  `nama_Stack` varchar(50),
  `kapasitas` int,
  `isFull` boolean
);

CREATE TABLE `Product` (
  `id_Product` int PRIMARY KEY,
  `id_Stack` int,
  `nama_Barang` varchar(50),
  `jenis_Barang` varchar(50),
  `jumlah` int,
  `deskripsi_Barang` varchar(255)
);

CREATE TABLE `User` (
  `id_User` int PRIMARY KEY,
  `nama_User` varchar(50),
  `email` varchar(255),
  `username` varchar(50),
  `password` varchar(255),
  `isUsed` boolean,
  `isAdmin` boolean
);

CREATE TABLE `Pencatatan` (
  `id_Pencatatan` int PRIMARY KEY,
  `nama_Stack` varchar(255),
  `nama_User` varchar(255),
  `nama_Barang` varchar(255),
  `id_Pelanggan` int,
  `tanggal_Pencatatan` date,
  `status` enum
);

CREATE TABLE `Pelanggan` (
  `id_Pelanggan` int PRIMARY KEY,
  `nama_Pelanggan` varchar(50),
  `alamat` varchar(255),
  `email` varchar(255),
  `no_Telepon` varchar(50),
  `status` enum
);

ALTER TABLE `Stack` ADD FOREIGN KEY (`id_Gudang`) REFERENCES `Gudang` (`id_Gudang`);

ALTER TABLE `Product` ADD FOREIGN KEY (`id_Stack`) REFERENCES `Stack` (`id_Stack`);

ALTER TABLE `Pencatatan` ADD FOREIGN KEY (`nama_Stack`) REFERENCES `Stack` (`nama_Stack`);

ALTER TABLE `Pencatatan` ADD FOREIGN KEY (`nama_User`) REFERENCES `User` (`nama_User`);

ALTER TABLE `Pencatatan` ADD FOREIGN KEY (`nama_Barang`) REFERENCES `Product` (`nama_Barang`);

ALTER TABLE `Pencatatan` ADD FOREIGN KEY (`id_Pelanggan`) REFERENCES `Pelanggan` (`id_Pelanggan`);
