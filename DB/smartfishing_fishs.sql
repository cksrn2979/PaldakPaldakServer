-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: smartfishing
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `fishs`
--

DROP TABLE IF EXISTS `fishs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fishs` (
  `id` varchar(100) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `species` varchar(100) DEFAULT NULL,
  `imgFile` varchar(200) DEFAULT NULL,
  `maxFower` double(7,3) DEFAULT NULL,
  `avgFower` double(7,3) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL,
  `timeing` double(7,3) DEFAULT NULL,
  `GPS_lat` double(7,3) DEFAULT NULL,
  `GPS_lot` double(7,3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fishs`
--

LOCK TABLES `fishs` WRITE;
/*!40000 ALTER TABLE `fishs` DISABLE KEYS */;
INSERT INTO `fishs` VALUES ('cksrn2979_20170323104401','cksrn2979','null','null','cksrn2979_20170323104401.jpg',98.871,48.940,'2017/03/23','10:44:01',-1.000,37.715,127.049),('cksrn2979_20170323105103','cksrn2979','null','null','cksrn2979_20170323105103.jpg',94.368,44.900,'2017/03/23','10:51:03',-1.000,37.715,127.049),('cksrn2979_20170323105931','cksrn2979','null','null','null',90.530,44.830,'2017/03/23','10:59:31',-1.000,37.715,127.049),('cksrn2979_20170323111107','cksrn2979','null','null','cksrn2979_20170323111107.jpg',93.908,60.040,'2017/03/23','11:11:07',-1.000,37.715,127.049),('cksrn2979_20170505053133','cksrn2979','null','null','cksrn2979_20170505053133.jpg',98.962,39.140,'2017/05/05','05:31:33',-1.000,37.715,127.049),('cksrn2979_20170505053347','cksrn2979','null','null','cksrn2979_20170505053347.jpg',99.394,52.070,'2017/05/05','05:33:47',-1.000,37.715,127.049),('cksrn2979_20170505090958','cksrn2979','물고기','???','cksrn2979_20170505090958.jpg',98.829,38.450,'2017/05/05','09:09:58',-1.000,37.715,127.049),('cksrn2979_20170505091034','cksrn2979','물고기','???','null',98.829,47.490,'2017/05/05','09:10:34',-1.000,37.715,127.049),('cksrn2979_20170505101819','cksrn2979','물고기','ㄱㅇㅇ','null',99.339,49.720,'2017/05/05','10:18:19',-1.000,37.715,127.049),('cksrn2979_20170505101851','cksrn2979','물고기','ㄹㄱㄱ','null',99.339,51.620,'2017/05/05','10:18:51',-1.000,37.715,127.049);
/*!40000 ALTER TABLE `fishs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-05 22:22:19
