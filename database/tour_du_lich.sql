-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: tour_du_lich
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Nhân viên'),(2,'Quản trị viên'),(3,'Chờ xét duyệt');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour`
--

DROP TABLE IF EXISTS `tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tour_name` varchar(255) NOT NULL,
  `tour_time` varchar(255) NOT NULL,
  `start_point` varchar(255) NOT NULL,
  `price` int DEFAULT '0',
  `schedule` varchar(255) DEFAULT NULL,
  `tour_program` varchar(255) DEFAULT NULL,
  `image` text,
  `cate_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_TourCate` (`cate_id`),
  CONSTRAINT `FK_TourCate` FOREIGN KEY (`cate_id`) REFERENCES `tour_category` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour`
--

LOCK TABLES `tour` WRITE;
/*!40000 ALTER TABLE `tour` DISABLE KEYS */;
INSERT INTO `tour` VALUES (1,'Tour Hà Giang','5N4Đ','Hồ Chí Minh',24580000,'HCM - Hà Giang - Đồng Văn - Cao Bằng - Bản Giốc - Pác Bó - Ba Bể','null','tour-ha-giang.jpg',1),(2,'Tour Miền Trung','5N4Đ','Đà Nẵng',8000000,'Đà Nẵng - Sơn Trà - Bà Nà - Hội An - Huế - Phong Nha - Bảo Tàng Phật Học - Chùa Quan Thế Âm','null','tour-da-nang.jpg',2),(3,'Tour Du Lịch Thái Lan','5N4Đ','Hà Nội',6290000,'Hà Nội - Bangkok - Pattaya - Muang Boran','null','tour-thai-lan.jpg',4),(4,'Tour Tây Nguyên','3N3Đ','Hồ Chí Minh',4786000,'Hồ Chí Minh - Tây Nguyên - Buôn Ma Thuột - Pleiku','null','tour-buon-me-thuat.jpg',3);
/*!40000 ALTER TABLE `tour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour_category`
--

DROP TABLE IF EXISTS `tour_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour_category`
--

LOCK TABLES `tour_category` WRITE;
/*!40000 ALTER TABLE `tour_category` DISABLE KEYS */;
INSERT INTO `tour_category` VALUES (1,'Miền Bắc'),(2,'Miền Trung'),(3,'Miền Nam'),(4,'Nước Ngoài');
/*!40000 ALTER TABLE `tour_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour_vehicle`
--

DROP TABLE IF EXISTS `tour_vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour_vehicle` (
  `id` int NOT NULL AUTO_INCREMENT,
  `vehicle_id` int NOT NULL,
  `tour_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_TVehicleTour` (`tour_id`),
  KEY `FK_VehicleTVhe` (`vehicle_id`),
  CONSTRAINT `FK_TVehicleTour` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`id`) on update cascade on delete cascade ,
  CONSTRAINT `FK_VehicleTVhe` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`) on update cascade on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour_vehicle`
--

LOCK TABLES `tour_vehicle` WRITE;
/*!40000 ALTER TABLE `tour_vehicle` DISABLE KEYS */;
/*!40000 ALTER TABLE `tour_vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `image` text,
  `role_id` int DEFAULT '3',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uidx_uEmail` (`email`),
  UNIQUE KEY `uidx_aUsername` (`username`),
  KEY `FK_UserRole` (`role_id`),
  CONSTRAINT `FK_UserRole` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'mihduc','1','Lê Minh Đức','29/10/2003',0,'0936759690','mihduc2910@gmail.com','avatar-default.jpg',2),(2,'phongBVB','11','Bùi Văn Phong','01/01/2003',1,'0987654321','phong@gmail.com','crossed-eye.png',2),(3,'justTuanB','1','Quán Anh Tuấn','01/01/2003',0,'0147852369','tuanquan@gmail.com','avatar-default.jpg',1),(4,'phucman','1','Nguyễn Hoàng Phúc','01/01/2003',1,'0365478921','phucman@gmail.com','avatar-default.jpg',2),(5,'nakadoo','1','Đỗ Năng Khoa','01/01/2003',0,'0569874123','nakado9@gmail.com','avatar-default.jpg',1),(11,'huyentrang','1','Nguyen Thi Huyen Trang','01/01/2003',0,'0123456789','trangnguyen@gmail.com','avatar-default.jpg',1),(12,'linhtruong','1','Trương Đăng Vũ Linh',NULL,0,NULL,'linhtruong@gmail.com','avatar-default.jpg',3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle` (
  `id` int NOT NULL AUTO_INCREMENT,
  `vehicle_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES (1,'Máy bay'),(2,'Ô tô');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-03 21:02:17
