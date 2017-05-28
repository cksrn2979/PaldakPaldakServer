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
  `maxFower` double(7,2) DEFAULT NULL,
  `avgFower` double(7,2) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL,
  `timeing` int(11) DEFAULT NULL,
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
INSERT INTO `fishs` VALUES ('cksrn2979_20140305101851','cksrn2979','물고기','잉어','cksrn2979_20140305101851.jpg',7.21,4.21,'2014/03/05','10:18:51',321,37.523,127.014),('cksrn2979_20140805011031','cksrn2979','물고기','잉어','cksrn2979_20140805011031.jpg',4.21,2.31,'2014/08/05','01:10:31',402,37.525,127.015),('cksrn2979_20170505091034','cksrn2979','럭럭','우럭','cksrn2979_20170505091034.jpg',5.40,5.00,'2017/05/05','09:10:34',120,36.917,129.410),('cksrn2979_20170505101819','cksrn2979','회먹은놈','광어','cksrn2979_20170505101819.jpg',3.50,3.10,'2017/05/05','10:18:19',53,36.917,129.410),('cksrn2979_20170505101851','cksrn2979','잉어킹','잉어','null',2.40,2.00,'2017/05/05','10:18:51',152,37.548,127.110),('cksrn2979_20170508110705','cksrn2979','한강놈','붕어','cksrn2979_20170508110705.jpg',6.40,5.10,'2017/05/08','11:07:05',121,37.536,127.099),('cksrn2979_20170520041113','cksrn2979','서래섬에서','붕어','cksrn2979_20170520041113.jpg',2.12,0.53,'2017 /05 /20','04: 11: 13',17,37.507,126.990),('dongdong_20131218102704','dongdong','첫장어','장어','dongdong_20131218102704.jpg',10.20,6.22,'2013/12/18','10:27:04',452,37.507,127.132),('dongdong_20151208100705','dongdong','내장어!','장어','dongdong_20151208100705.jpg',10.40,8.00,'2015/12/08','10:07:05',1023,37.568,126.990),('dongdong_20161214092302','dongdong','물고기','잉어','dongdong_20161214092302.jpg',8.23,3.21,'2016/12/14','09:23:02',542,37.529,127.052),('jihe_20120718020445','jihe','잡았다요놈','장어','jihe_20120718020445.jpg',12.10,9.23,'2012/07/18','02:04:45',634,37.575,127.207),('jihe_20150718020445','jihe','몸보신함','장어','jihe_20150718020445.jpg',13.10,5.42,'2015/07/18','02:04:45',752,37.575,127.207),('songi_20160405014042','songi','물고기','잉어','songi_20160405014042.jpg',5.42,2.78,'2016/04/05','01:40:42',222,37.715,127.043),('songi_20161205013040','songi','동해에서','우럭','songi_20161205013040.jpg',3.20,4.21,'2016/12/05','01:30:40',100,37.798,128.917),('sooyul_20160512110507','sooyul','횟감','우럭','sooyul_20160512110507.jpg',10.20,7.00,'2016/05/12','11:05:07',450,37.693,129.031),('sooyul_20170508110705','sooyul','붕어찜','붕어','sooyul_20170508110705.jpg',6.60,5.00,'2017/05/08','11:07:05',222,37.715,127.043);
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

-- Dump completed on 2017-05-20 16:34:43
