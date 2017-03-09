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
  `이름` varchar(100) DEFAULT NULL,
  `어종` varchar(100) DEFAULT NULL,
  `사진경로` varchar(200) DEFAULT NULL,
  `최대값` double(7,3) DEFAULT NULL,
  `평균값` double(7,3) DEFAULT NULL,
  `무게` double(7,3) DEFAULT NULL,
  `날짜` varchar(45) DEFAULT NULL,
  `잡은시간` double(7,3) DEFAULT NULL,
  `위치` varchar(300) DEFAULT NULL,
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
INSERT INTO `fishs` VALUES ('cksrn2979_17030919','cksrn2979','꼬북이','놀래미','cksrn2979_1730919.jpg',10.100,5.000,3.000,'2017/03/09',100.000,'HOME'),('cksrn2979_17030920','cksrn2979','고라파덕','금붕어','cksrn2979_1730920.jpg',10.100,4.000,3.000,'2017/03/09',100.000,'HOME'),('cksrn2979_17030921','cksrn2979','어니부기','니모','cksrn2979_1730921.jpg',4.000,1.120,1.120,'2017/03/09',75.000,'HOME'),('cksrn2979_17030923','cksrn2979','잉어킹','잉어','cksrn2979_1730923.gif',1.120,3.000,4.000,'2017/03/09',42.000,'HOME');
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

-- Dump completed on 2017-03-10  0:29:38
