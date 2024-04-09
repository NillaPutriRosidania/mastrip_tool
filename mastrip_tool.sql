-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 09 Des 2021 pada 14.35
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mastrip_tool`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `akun_karyawan`
--

CREATE TABLE `akun_karyawan` (
  `username` char(6) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `akun_karyawan`
--

INSERT INTO `akun_karyawan` (`username`, `password`) VALUES
('K0001', '123'),
('IVAN21', '123123'),
('NILLA1', '123123'),
('rayhan', '123123'),
('SUKUR', '123123'),
('BOIM', 'BOIM123');

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_barang`
--

CREATE TABLE `data_barang` (
  `kode_barang` char(6) NOT NULL,
  `nama_barang` varchar(45) DEFAULT NULL,
  `kode_supplier` char(6) NOT NULL,
  `harga_beli` decimal(10,0) DEFAULT NULL,
  `harga_jual` decimal(10,0) DEFAULT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `data_barang`
--

INSERT INTO `data_barang` (`kode_barang`, `nama_barang`, `kode_supplier`, `harga_beli`, `harga_jual`, `stok`) VALUES
('BR001', 'PINTU', 'SP002', '160000', '170000', 143),
('BR002', 'PAKU', 'SP001', '1500', '2000', 145),
('BR003', 'LEM', 'SP001', '5000', '6000', 92),
('BR004', 'CAT', 'SP0003', '15000', '20000', 97),
('BR005', 'Engsel Isumi 3 x 12', 'SP0001', '4600', '6000', 13),
('BR006', 'Engsel KS 3 x 12', 'SP0001', '5000', '6200', 8),
('BR007', 'Engsel Tebal GOMEO 4 x 3', 'SP0001', '11250', '13000', 24),
('BR008', 'Grendel kupukupu', 'SP0001', '850', '1200', 39),
('BR009', 'Gembok 30mm', 'SP0001', '5500', '6600', 10),
('BR010', 'Gembok LIP 50mm', 'SP0001', '8750', '12000', 10),
('BR011', 'Gembok 60mm', 'SP0001', '21500', '24000', 7),
('BR012', 'Gembok 40mm', 'SP0001', '13000', '16000', 21),
('BR013', 'Kanci laci GLOBAL ', 'SP0001', '3960', '5000', 24),
('BR014', 'Tarikan laci/pintu (ukiran cokelat)', 'SP0001', '2500', '3200', 38),
('BR015', 'Body pintu Geser EXITO ', 'SP0001', '21700', '22500', 7),
('BR016', 'Handle pintu geser GDO', 'SP0001', '6000', '7000', 20),
('BR018', 'Handle pintu akrilik 35', 'SP001', '60000', '75000', 2),
('BR019', 'Handle pintu komplit OLYMPUS', 'SP001', '30000', '38000', 5),
('BR020', 'Catut (merah) 6\"', 'SP001', '6000', '8500', 18),
('BR021', 'Tang kombinasi serbaguna', 'SP001', '45000', '48000', 0),
('BR022', 'Tang kombinasi 6\"', 'SP001', '7100', '8500', 5),
('BR023', 'Cetok 7\" OVAL', 'SP001', '4585', '5800', 15),
('BR024', 'Cetok 6\" KOTAK', 'SP001', '5500', '7000', 8),
('BR025', 'Skrap PVC \"S\"', 'SP001', '800', '1000', 30),
('BR026', 'Palu Tukang 100 gr', 'SP003', '10000', '13000', 11);

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_karyawan`
--

CREATE TABLE `data_karyawan` (
  `kode_karyawan` char(6) NOT NULL,
  `nama` varchar(45) DEFAULT NULL,
  `alamat` varchar(45) DEFAULT NULL,
  `no_hp` char(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `data_karyawan`
--

INSERT INTO `data_karyawan` (`kode_karyawan`, `nama`, `alamat`, `no_hp`) VALUES
('BOIM', 'BOIM', 'JEMBER', '082226736845'),
('IVAN21', 'REZA IVANO', 'JEMBER', '089504395516'),
('K0001', 'Rayhan Febriansyah', 'Jember', '089504395516'),
('NILLA1', 'NILLA', 'JEMBER', '089474984633'),
('SUKUR', 'sukur supratman', 'JEMBER', '082228475364');

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_supplier`
--

CREATE TABLE `data_supplier` (
  `kode_supplier` char(6) NOT NULL,
  `nama_supplier` varchar(45) DEFAULT NULL,
  `alamat` varchar(45) DEFAULT NULL,
  `no_hp` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `data_supplier`
--

INSERT INTO `data_supplier` (`kode_supplier`, `nama_supplier`, `alamat`, `no_hp`) VALUES
('SP0001', 'RAYHAN', 'JEMBER', '087456748516'),
('SP0002', 'IVAN', 'jember', '089654783546'),
('SP0003', 'ROKIB', 'JEMBER', '082229474403'),
('SP001', 'WISHAL', 'LANGKAP', '089676857465'),
('SP002', 'suyitno', 'jember', '082229474403'),
('SP003', 'IVANO', 'JEMBER', '087762534273');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `kode_transaksi` varchar(20) NOT NULL,
  `kode_barang` varchar(10) NOT NULL,
  `nama_barang` varchar(45) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` decimal(10,0) NOT NULL,
  `Total` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`kode_transaksi`, `kode_barang`, `nama_barang`, `jumlah`, `harga`, `Total`) VALUES
('TR0002', 'BR001', 'PAKU', 2, '2200', '4400'),
('TR0003', 'BR003', 'SEMEN', 2, '60000', '120000'),
('TR0008', 'BR003', 'SEMEN', 2, '60000', '120000'),
('TR0009', 'BR003', 'SEMEN', 3, '60000', '180000'),
('TR0010', 'BR002', 'PAKU KAYU', 3, '1500', '4500'),
('TR0011', 'BR002', 'PAKU KAYU', 3, '1500', '4500'),
('TR0012', 'BR001', 'PAKU', 7, '2200', '15400'),
('TR0013', 'BR003', 'SEMEN', 5, '60000', '300000'),
('TR0013', 'BR002', 'PAKU KAYU', 2, '1500', '3000'),
('TR0014', 'BR003', 'SEMEN', 5, '60000', '300000'),
('TR0015', 'BR003', 'SEMEN', 2, '60000', '120000'),
('TR0016', 'BR001', 'PAKU', 1, '2200', '2200'),
('TR0017', 'BR001', 'PAKU', 1, '2200', '2200'),
('TR0018', 'BR002', 'PAKU KAYU', 1, '1500', '1500'),
('TR0019', 'BR001', 'PAKU', 1, '2200', '2200'),
('TR0019', 'BR002', 'PAKU KAYU', 2, '1500', '3000'),
('TR0020', 'BR001', 'PINTU', 2, '170000', '340000'),
('TR0021', 'BR001', 'PINTU', 3, '170000', '510000'),
('TR0022', 'BR003', 'LEM', 2, '6000', '12000'),
('TR0023', 'BR004', 'CAT', 2, '20000', '40000'),
('TR0023', 'BR004', 'CAT', 1, '20000', '20000'),
('TR0024', 'BR002', 'PAKU', 2, '2000', '4000'),
('TR0025', 'BR003', 'LEM', 4, '6000', '24000'),
('TR0026', 'BR002', 'PAKU', 1, '2000', '2000'),
('TR0026', 'BR003', 'LEM', 1, '6000', '6000'),
('TR0026', 'BR011', 'Gembok 60mm', 1, '24000', '24000'),
('TR0026', 'BR003', 'LEM', 1, '6000', '6000'),
('TR0027', 'BR001', 'PINTU', 2, '170000', '340000'),
('TR0027', 'BR002', 'PAKU', 2, '2000', '4000'),
('TR0028', 'BR021', 'Tang kombinasi serbaguna', 2, '48000', '96000'),
('TR0028', 'BR021', 'Tang kombinasi serbaguna', 1, '48000', '48000'),
('TR0029', 'BR020', 'Catut (merah) 6\"', 1, '8500', '8500'),
('TR0029', 'BR024', 'Cetok 6\" KOTAK', 1, '7000', '7000'),
('TR0029', 'BR014', 'Tarikan laci/pintu (ukiran cokelat)', 1, '3200', '3200'),
('TR0029', 'BR016', 'Handle pintu geser GDO', 2, '7000', '14000'),
('TR0029', 'BR008', 'Grendel kupukupu', 2, '1200', '2400');

--
-- Trigger `detail_transaksi`
--
DELIMITER $$
CREATE TRIGGER `pengurangan stok` AFTER INSERT ON `detail_transaksi` FOR EACH ROW BEGIN UPDATE data_barang SET stok=stok -new.jumlah WHERE kode_barang=new.kode_barang;END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `kode_transaksi` varchar(20) NOT NULL,
  `tanggal` varchar(20) NOT NULL,
  `id_pelanggan` char(6) NOT NULL,
  `nama_pelanggan` varchar(50) NOT NULL,
  `admin` varchar(50) NOT NULL,
  `Total` decimal(10,0) NOT NULL,
  `kembalian` decimal(10,0) NOT NULL,
  `Bayar` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`kode_transaksi`, `tanggal`, `id_pelanggan`, `nama_pelanggan`, `admin`, `Total`, `kembalian`, `Bayar`) VALUES
('TR0002', '06-12-2021', 'ID0001', 'ryan', '0', '0', '0', '0'),
('TR0003', '06-12-2021', 'ID0002', 'RYAN', '0', '0', '0', '0'),
('TR0004', '06-12-2021', 'ID0003', 'kentung', '0', '0', '0', '0'),
('TR0005', '06-12-2021', 'ID0004', 'kentung', '0', '0', '0', '0'),
('TR0008', '06-12-2021', 'ID0007', 'saki', '0', '0', '0', '0'),
('TR0009', '06-12-2021', 'ID0008', 'saya', '0', '0', '0', '0'),
('TR0010', '06-12-2021', 'ID0009', 'belajar', '0', '0', '0', '0'),
('TR0011', '06-12-2021', 'ID0010', 'rere', '0', '0', '0', '0'),
('TR0012', '06-12-2021', 'ID0011', 'sayang', '0', '0', '0', '0'),
('TR0013', '06-12-2021', 'ID0012', 'TUKIYEM', '0', '0', '0', '0'),
('TR0014', '06-12-2021', 'ID0013', 'pedot', 'rayhan', '0', '0', '0'),
('TR0015', '06-12-2021', 'ID0014', 'dikesyang', '', '0', '10000', '0'),
('TR0016', '06-12-2021', 'ID0015', 'FERY', '', '0', '1800', '0'),
('TR0017', '06-12-2021', 'ID0016', 'IRWAN', '', '0', '1800', '0'),
('TR0018', '06-12-2021', 'ID0017', 'sukitmo', '', '0', '100', '1600'),
('TR0019', '06-12-2021', 'ID0018', 'YUNUS', '', '5200', '400', '5600'),
('TR0020', '06-12-2021', 'ID0019', 'LUKITO', '', '340000', '60000', '400000'),
('TR0021', '06-12-2021', 'ID0020', 'CUKIRO', '', '510000', '40000', '550000'),
('TR0022', '06-12-2021', 'ID0021', 'SUKIJAN', '', '12000', '2000', '14000'),
('TR0023', '06-12-2021', 'ID0022', 'SUKIRAN', 'SUKUR', '60000', '10000', '70000'),
('TR0024', '07-12-2021', 'ID0023', 'NILLA', '', '4000', '1000', '5000'),
('TR0025', '07-12-2021', 'ID0024', 'NILLA', 'rayhan', '24000', '1000', '25000'),
('TR0026', '08-12-2021', 'ID0025', 'Nilla', '', '38000', '12000', '50000'),
('TR0027', '08-12-2021', 'ID0026', 'PIPI', '', '344000', '56000', '400000'),
('TR0028', '09-12-2021', 'ID0027', 'DELA', '', '144000', '6000', '150000'),
('TR0029', '09-12-2021', 'ID0028', 'NELA', 'IVAN21', '35100', '4900', '40000');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `akun_karyawan`
--
ALTER TABLE `akun_karyawan`
  ADD PRIMARY KEY (`username`),
  ADD KEY `password` (`password`);

--
-- Indeks untuk tabel `data_barang`
--
ALTER TABLE `data_barang`
  ADD PRIMARY KEY (`kode_barang`),
  ADD KEY `kode_supplier` (`kode_supplier`);

--
-- Indeks untuk tabel `data_karyawan`
--
ALTER TABLE `data_karyawan`
  ADD PRIMARY KEY (`kode_karyawan`);

--
-- Indeks untuk tabel `data_supplier`
--
ALTER TABLE `data_supplier`
  ADD PRIMARY KEY (`kode_supplier`);

--
-- Indeks untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD KEY `kode_transaksi` (`kode_transaksi`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`kode_transaksi`),
  ADD KEY `id_pelanggan` (`id_pelanggan`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `data_barang`
--
ALTER TABLE `data_barang`
  ADD CONSTRAINT `data_barang_ibfk_1` FOREIGN KEY (`kode_supplier`) REFERENCES `data_supplier` (`kode_supplier`);

--
-- Ketidakleluasaan untuk tabel `data_karyawan`
--
ALTER TABLE `data_karyawan`
  ADD CONSTRAINT `data_karyawan_ibfk_1` FOREIGN KEY (`kode_karyawan`) REFERENCES `akun_karyawan` (`username`);

--
-- Ketidakleluasaan untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `detail_transaksi_ibfk_1` FOREIGN KEY (`kode_transaksi`) REFERENCES `transaksi` (`kode_transaksi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
