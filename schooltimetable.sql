-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 26, 2023 at 01:10 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `schooltimetable`
--

-- --------------------------------------------------------

--
-- Table structure for table `assessments`
--

CREATE TABLE `assessments` (
  `Ass_No` int(11) NOT NULL,
  `Ass_name` varchar(250) NOT NULL,
  `Acc_year` varchar(20) NOT NULL,
  `Deadline` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `assessments`
--

INSERT INTO `assessments` (`Ass_No`, `Ass_name`, `Acc_year`, `Deadline`) VALUES
(12, 'nf', 'Year 2', '25th nov'),
(2041, 'OOP', 'Year 2', '24th DEC'),
(2045, 'AE', 'Year 2', '24th JAN'),
(2048, 'AN', 'Year 3', '24th FEB');

-- --------------------------------------------------------

--
-- Table structure for table `exam_details`
--

CREATE TABLE `exam_details` (
  `ID` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `year` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `exam_details`
--

INSERT INTO `exam_details` (`ID`, `name`, `year`, `date`) VALUES
(10, 'oop', 'Year 2', '25/12/2022'),
(2041, 'oop', 'Year 2', '21/08/2022'),
(2042, 'oop', 'Year 2', '24/08/2022'),
(2043, 'DSA', 'Year 2', '24/08/2022'),
(2047, 'DSA', 'Year 2', '29/08/2022'),
(2214, 'AE', 'Year 2', '29/08/2022'),
(2217, 'AE', 'Year 2', '29/08/2022');

-- --------------------------------------------------------

--
-- Table structure for table `issue_time`
--

CREATE TABLE `issue_time` (
  `Issue_Id` int(11) NOT NULL,
  `lecture_id` int(11) NOT NULL,
  `lecture_name` varchar(100) NOT NULL,
  `hall_id` int(11) NOT NULL,
  `hall_name` varchar(100) NOT NULL,
  `issue_date` date NOT NULL,
  `status` varchar(25) NOT NULL,
  `issue_time` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `issue_time`
--

INSERT INTO `issue_time` (`Issue_Id`, `lecture_id`, `lecture_name`, `hall_id`, `hall_name`, `issue_date`, `status`, `issue_time`) VALUES
(14, 2, 'pasindu', 1, 'networking', '2022-11-07', 'available', '08:00 - 09:00'),
(15, 2, 'pasindu', 1, 'networking', '2022-11-07', 'available', '09:00 - 10:00'),
(16, 2, 'pasindu', 1, 'networking', '2022-11-10', 'available', '09:00 - 10:00'),
(17, 2, 'pasindu', 1, 'networking', '2022-11-21', 'available', '09:00 - 10:00'),
(18, 2, 'pasindu', 1, 'networking', '2022-11-01', 'available', '09:00 - 10:00'),
(19, 2, 'pasindu', 2, 'IT', '2022-11-09', 'available', '08:00 - 09:00'),
(20, 2, 'pasindu', 2, 'IT', '2022-11-11', 'available', '08:00 - 09:00'),
(21, 2, 'pasindu', 2, 'IT', '2022-11-12', 'available', '08:00 - 09:00'),
(22, 2, 'pasindu', 2, 'IT', '2022-11-14', 'available', '08:00 - 09:00'),
(23, 2, 'pasindu', 2, 'IT', '2022-11-20', 'available', '08:00 - 09:00'),
(24, 2, 'pasindu', 2, 'IT', '2022-11-30', 'available', '08:00 - 09:00'),
(25, 2, 'pasindu', 2, 'IT', '2022-11-28', 'available', '08:00 - 09:00'),
(26, 2, 'pasindu', 2, 'IT', '2022-11-03', 'available', '08:00 - 09:00'),
(27, 2, 'pasindu', 2, 'IT', '2022-11-04', 'available', '08:00 - 09:00'),
(28, 2, 'pasindu', 1, 'networking', '2022-11-08', 'available', '08:00 - 09:00'),
(29, 2149, 'kusal', 12, 'Main building', '2023-01-28', 'issued', '09:00 - 10:00'),
(30, 2149, 'kusal', 12, 'Main building', '2023-01-27', 'issued', '09:00 - 10:00'),
(31, 2149, 'kusal', 12, 'Main building', '2023-01-30', 'issued', '11:00 - 12:00'),
(32, 2149, 'kusal', 12, 'Main building', '2023-01-31', 'issued', '13:00 - 14:00');

-- --------------------------------------------------------

--
-- Table structure for table `lecturers`
--

CREATE TABLE `lecturers` (
  `Lecture_ID` int(11) NOT NULL,
  `lecturer_Name` varchar(100) NOT NULL,
  `Department` varchar(100) NOT NULL,
  `position` varchar(100) NOT NULL,
  `Qualification` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lecturers`
--

INSERT INTO `lecturers` (`Lecture_ID`, `lecturer_Name`, `Department`, `position`, `Qualification`, `email`) VALUES
(2149, 'kusal', 'IT', 'Lecturer', 'BSc', 'kusal@gmail.com'),
(2150, 'dilshan', 'Engineering', 'instructor', 'MSc', 'dilshan@gmail.com'),
(2151, 'sasidu', 'Business', 'Senior Lecturer', 'PhD', 'sasindu@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `location_ID` int(11) NOT NULL,
  `location_name` varchar(100) NOT NULL,
  `Department` varchar(100) NOT NULL,
  `No_seat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`location_ID`, `location_name`, `Department`, `No_seat`) VALUES
(1, 'New building', 'Business', 40),
(12, 'Main building', 'IT', 2),
(45, 'business building', 'Business', 80);

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `ID` int(11) NOT NULL,
  `subject_name` varchar(50) NOT NULL,
  `subject_code` varchar(50) NOT NULL,
  `lecture_hrs` int(11) NOT NULL,
  `lecture_type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`ID`, `subject_name`, `subject_code`, `lecture_hrs`, `lecture_type`) VALUES
(128, 'NF', 'IT1020', 12, 'Lecture'),
(129, 'networking', 'IE2030', 15, 'Lecture'),
(130, 'OOP', 'IT2015', 25, 'LAB'),
(131, 'OOC', 'IT2019', 28, 'Tutorial');

-- --------------------------------------------------------

--
-- Table structure for table `userdetails`
--

CREATE TABLE `userdetails` (
  `ID` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `userType` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userdetails`
--

INSERT INTO `userdetails` (`ID`, `name`, `password`, `userType`, `Email`) VALUES
(1, 'kusal', '123', 'Student', 'kusal@gmail.com'),
(14, 'pasindu', '50As', 'Student', 'pasindu@gmail.com'),
(15, 'nimal', '45zX', 'Lecturer', 'nimal@gmail.com'),
(16, 'kamal', '78Nb', 'Admin', 'kamal@gmail.com'),
(17, 'amal', '45Aw', 'Admin', 'amal@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assessments`
--
ALTER TABLE `assessments`
  ADD PRIMARY KEY (`Ass_No`);

--
-- Indexes for table `exam_details`
--
ALTER TABLE `exam_details`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `issue_time`
--
ALTER TABLE `issue_time`
  ADD PRIMARY KEY (`Issue_Id`);

--
-- Indexes for table `lecturers`
--
ALTER TABLE `lecturers`
  ADD PRIMARY KEY (`Lecture_ID`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`location_ID`);

--
-- Indexes for table `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `userdetails`
--
ALTER TABLE `userdetails`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assessments`
--
ALTER TABLE `assessments`
  MODIFY `Ass_No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2049;

--
-- AUTO_INCREMENT for table `issue_time`
--
ALTER TABLE `issue_time`
  MODIFY `Issue_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `lecturers`
--
ALTER TABLE `lecturers`
  MODIFY `Lecture_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2152;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `location_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123;

--
-- AUTO_INCREMENT for table `subjects`
--
ALTER TABLE `subjects`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=132;

--
-- AUTO_INCREMENT for table `userdetails`
--
ALTER TABLE `userdetails`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
