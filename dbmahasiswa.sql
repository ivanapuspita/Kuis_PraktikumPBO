-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 09, 2020 at 05:02 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbmahasiswa`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_mhs`
--

CREATE TABLE `data_mhs` (
  `nim` int(9) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `matkul1` varchar(30) NOT NULL,
  `nilai1` int(4) NOT NULL,
  `matkul2` varchar(30) NOT NULL,
  `nilai2` int(4) NOT NULL,
  `rata` float NOT NULL,
  `huruf` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_mhs`
--

INSERT INTO `data_mhs` (`nim`, `nama`, `matkul1`, `nilai1`, `matkul2`, `nilai2`, `rata`, `huruf`) VALUES
(111, 'Ani Cintya', 'Kalkulus', 85, 'Matriks', 90, 87.5, 'A'),
(112, 'Ali', 'AA', 82, 'B inggris', 87, 84.5, 'A'),
(113, 'Lili', 'ui', 78, 'ju', 67, 72.5, 'B'),
(114, 'Mimi', 'oo', 76, 'sas', 78, 77, 'B+'),
(115, 'Zizi', 'kl', 54, 'kjds', 55, 54.5, 'C'),
(116, 'dfg', 'hj', 90, 'kl', 88, 89, 'A');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
