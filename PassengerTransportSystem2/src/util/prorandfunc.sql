-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: passenger_manager
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `car_type`
--

DROP TABLE IF EXISTS `car_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_type` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `model_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `seat_num` int(11) NOT NULL,
  `car_num` int(11) NOT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_type`
--

LOCK TABLES `car_type` WRITE;
/*!40000 ALTER TABLE `car_type` DISABLE KEYS */;
INSERT INTO `car_type` VALUES (1,'越野车',4,10),(2,'小巴',31,11),(3,'大巴',40,9),(4,'面包车',10,10),(5,'小型轿车',5,20);
/*!40000 ALTER TABLE `car_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver_list`
--

DROP TABLE IF EXISTS `driver_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `driver_list` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `age` int(11) NOT NULL,
  `driver_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_list`
--

LOCK TABLES `driver_list` WRITE;
/*!40000 ALTER TABLE `driver_list` DISABLE KEYS */;
INSERT INTO `driver_list` VALUES (1,'机器人','99',99,'dfgdg'),(2,'吕洋','99',99,'lvyang'),(3,'张泽峰','119',21,'zzf'),(4,'张旭东','120',21,'zxd');
/*!40000 ALTER TABLE `driver_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_list`
--

DROP TABLE IF EXISTS `order_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_list` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `tid` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) DEFAULT '1',
  PRIMARY KEY (`oid`),
  KEY `uid` (`uid`),
  KEY `tid` (`tid`),
  CONSTRAINT `用户id` FOREIGN KEY (`uid`) REFERENCES `user_list` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `车次id` FOREIGN KEY (`tid`) REFERENCES `trips_list` (`tid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_list`
--

LOCK TABLES `order_list` WRITE;
/*!40000 ALTER TABLE `order_list` DISABLE KEYS */;
INSERT INTO `order_list` VALUES (14,4,5,'2020-06-22 09:35:55',0),(17,4,4,'2020-06-22 08:18:03',0),(18,4,4,'2020-06-22 09:42:38',0),(19,6,4,'2020-06-22 09:48:24',0),(23,1,2,'2020-06-23 01:03:02',1),(26,1,17,'2020-06-23 23:37:14',0);
/*!40000 ALTER TABLE `order_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `add_votes_saled` AFTER INSERT ON `order_list` FOR EACH ROW UPDATE `trips_list` SET `votes_saled`=`votes_saled`+1 WHERE `tid` = NEW.tid */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `route_list`
--

DROP TABLE IF EXISTS `route_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route_list` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `route_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route_list`
--

LOCK TABLES `route_list` WRITE;
/*!40000 ALTER TABLE `route_list` DISABLE KEYS */;
INSERT INTO `route_list` VALUES (12,'并运线',120),(13,'运并线',130);
/*!40000 ALTER TABLE `route_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route_station`
--

DROP TABLE IF EXISTS `route_station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route_station` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) NOT NULL,
  `sid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  KEY `sid` (`sid`),
  CONSTRAINT `站点` FOREIGN KEY (`sid`) REFERENCES `station_list` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `线路` FOREIGN KEY (`rid`) REFERENCES `route_list` (`rid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route_station`
--

LOCK TABLES `route_station` WRITE;
/*!40000 ALTER TABLE `route_station` DISABLE KEYS */;
INSERT INTO `route_station` VALUES (1,12,1),(2,12,2),(4,12,4),(5,12,5),(6,12,6),(7,13,6),(8,13,5),(9,13,4),(11,13,2),(12,13,1);
/*!40000 ALTER TABLE `route_station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `shows`
--

DROP TABLE IF EXISTS `shows`;
/*!50001 DROP VIEW IF EXISTS `shows`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `shows` AS SELECT 
 1 AS `tid`,
 1 AS `trips_name`,
 1 AS `route_name`,
 1 AS `model_name`,
 1 AS `votes`,
 1 AS `votes_saled`,
 1 AS `start_time`,
 1 AS `end_time`,
 1 AS `status`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `station_list`
--

DROP TABLE IF EXISTS `station_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `station_list` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `station_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `station_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`sid`),
  UNIQUE KEY `station_name_2` (`station_name`),
  KEY `station_name` (`station_name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station_list`
--

LOCK TABLES `station_list` WRITE;
/*!40000 ALTER TABLE `station_list` DISABLE KEYS */;
INSERT INTO `station_list` VALUES (1,'中北大学','nuc'),(2,'太原','taiyuan'),(3,'运城','yuncheng'),(4,'河津','hejin'),(5,'大同','datong'),(6,'吕梁','lvliang');
/*!40000 ALTER TABLE `station_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `statistics`
--

DROP TABLE IF EXISTS `statistics`;
/*!50001 DROP VIEW IF EXISTS `statistics`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `statistics` AS SELECT 
 1 AS `rid`,
 1 AS `mid`,
 1 AS `route_name`,
 1 AS `model_name`,
 1 AS `car_num`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `trips_list`
--

DROP TABLE IF EXISTS `trips_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trips_list` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `trips_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `rid` int(11) NOT NULL,
  `mid` int(11) NOT NULL,
  `votes` int(11) NOT NULL,
  `votes_saled` int(11) NOT NULL DEFAULT '0',
  `did` int(11) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`tid`),
  KEY `rid` (`rid`),
  KEY `mid` (`mid`),
  KEY `did` (`did`),
  CONSTRAINT `线路id` FOREIGN KEY (`rid`) REFERENCES `route_list` (`rid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `车型id` FOREIGN KEY (`mid`) REFERENCES `car_type` (`mid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `驾驶员id` FOREIGN KEY (`did`) REFERENCES `driver_list` (`did`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trips_list`
--

LOCK TABLES `trips_list` WRITE;
/*!40000 ALTER TABLE `trips_list` DISABLE KEYS */;
INSERT INTO `trips_list` VALUES (2,'A711',12,2,40,1,1,'2020-04-01 19:01:05','2020-04-01 21:01:05',1),(3,'B666',12,4,20,0,3,'2020-06-22 21:11:59','2020-06-22 21:12:04',0),(4,'D110',12,5,200,8,2,'2020-01-28 19:01:05','2020-01-01 19:01:05',1),(5,'G110',12,2,20,3,2,'2020-04-01 19:01:05','2020-04-01 21:01:05',1),(6,'D119',13,3,12,1,2,'2020-04-01 19:01:05','2020-04-01 21:01:05',1),(7,'K990',13,4,20,0,1,'2020-06-22 21:17:05','2020-06-22 22:17:08',0),(10,'G119',13,5,12,0,3,'2020-04-01 19:01:05','2020-04-01 21:01:05',0),(11,'T119',13,3,11,0,1,'2020-04-01 19:01:05','2020-04-01 21:01:05',0),(14,'D119',12,1,200,6,1,'2020-06-28 19:01:05','2020-06-28 21:01:05',0),(15,'D114',12,3,200,0,3,'2020-01-28 19:01:05','2020-01-28 22:01:05',0),(17,'D222',12,1,200,1,1,'2020-01-28 19:01:05','2020-01-28 19:01:05',1);
/*!40000 ALTER TABLE `trips_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_list`
--

DROP TABLE IF EXISTS `user_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_list` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_list`
--

LOCK TABLES `user_list` WRITE;
/*!40000 ALTER TABLE `user_list` DISABLE KEYS */;
INSERT INTO `user_list` VALUES (1,'lvyang','123123'),(2,'zzf','1234567'),(3,'xd','laowang'),(4,'hong','123123'),(5,'zs','123123'),(6,'lz','123123');
/*!40000 ALTER TABLE `user_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `shows`
--

/*!50001 DROP VIEW IF EXISTS `shows`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `shows` AS select `trips_list`.`tid` AS `tid`,`trips_list`.`trips_name` AS `trips_name`,`route_list`.`route_name` AS `route_name`,`car_type`.`model_name` AS `model_name`,`trips_list`.`votes` AS `votes`,`trips_list`.`votes_saled` AS `votes_saled`,`trips_list`.`start_time` AS `start_time`,`trips_list`.`end_time` AS `end_time`,`trips_list`.`status` AS `status` from ((`car_type` join `trips_list`) join `route_list`) where ((`car_type`.`mid` = `trips_list`.`mid`) and (`trips_list`.`rid` = `route_list`.`rid`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `statistics`
--

/*!50001 DROP VIEW IF EXISTS `statistics`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `statistics` AS select `rl`.`rid` AS `rid`,`tl`.`mid` AS `mid`,`rl`.`route_name` AS `route_name`,`ct`.`model_name` AS `model_name`,count(0) AS `car_num` from (((`trips_list` `tl` join `car_type` `ct`) join `driver_list` `dl`) join `route_list` `rl`) where ((`tl`.`mid` = `ct`.`mid`) and (`tl`.`did` = `dl`.`did`) and (`tl`.`rid` = `rl`.`rid`)) group by `rl`.`rid`,`tl`.`mid` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-24  9:00:25
