-- MySQL dump 10.16  Distrib 10.1.9-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: slsxpt
-- ------------------------------------------------------
-- Server version	10.1.9-MariaDB

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `salt` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `gold` int(11) DEFAULT '0',
  `progress` int(11) DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  `type` enum('customer','admin','root') NOT NULL DEFAULT 'customer',
  `avatar` varchar(64) DEFAULT NULL,
  `clazz` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `college_id` int(11) DEFAULT NULL,
  `remember_token` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `FK_a4bhkx01s72ifnp31kr6a3220` (`college_id`),
  CONSTRAINT `FK_a4bhkx01s72ifnp31kr6a3220` FOREIGN KEY (`college_id`) REFERENCES `college` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin888','7ca9d77f852e7205d74f7e91bbc5d40d','72acf2e2e5ff4f17882b4173832fa43f',NULL,0,0,'2015-06-28 08:29:32','2015-06-28 08:29:32','lvyahui8@126.com',NULL,'','admin','/upload/images/a25e2626494beb2a0d1f27b28a2032f0.jpg',NULL,NULL,NULL,NULL),(9,'lvyahui','00b25acc721a6989148fd2491233a71a','3464b746e8c44ff9b97c20826cf05348',NULL,0,0,'2015-06-28 14:32:25','2015-06-28 14:32:25','lvyahui6@163.com',NULL,'3340b609ed484d29b3d0da38802afc7a','root','/upload/images/a45b0f9c27ff4ce94a259a5d5961e810.jpg',NULL,NULL,NULL,NULL),(10,'devlyh','f9ad039fbe35fcedcf5482f7ca587d1b','5effef4761b840a29c70839f0279f5e6',NULL,0,0,'2015-07-19 11:57:03','2015-07-19 11:57:03','devlyh@163.com',NULL,'','customer',NULL,NULL,NULL,NULL,NULL),(12,'admin','b757da264780a87e7ef4bbcb75892f91','b5b3beef23de482886603d518d76338e',NULL,0,0,'2015-10-04 06:52:44','2015-10-04 06:52:44','1257069082@qq.com',NULL,'c5ee63af5e7347ff942650739fc645d5','customer',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-21 11:10:21
