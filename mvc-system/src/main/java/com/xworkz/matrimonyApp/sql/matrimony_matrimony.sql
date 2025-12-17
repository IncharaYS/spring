-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: matrimony
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `matrimony`
--

DROP TABLE IF EXISTS `matrimony`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matrimony` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(30) NOT NULL,
  `create_profile_for` varchar(10) DEFAULT NULL,
  `gender` varchar(15) DEFAULT NULL,
  `date_of_birth` varchar(11) DEFAULT NULL,
  `mother_tongue` varchar(20) DEFAULT NULL,
  `religion` varchar(20) DEFAULT NULL,
  `marital_status` varchar(20) DEFAULT NULL,
  `height` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matrimony`
--

LOCK TABLES `matrimony` WRITE;
/*!40000 ALTER TABLE `matrimony` DISABLE KEYS */;
INSERT INTO `matrimony` VALUES (1,'inchara21102003@gmail.com','Myself','female','7776-09-08','Hindi','Jain','Divorced',4.8),(2,'incharays07@gmail.com','Myself','female','2003-09-08','Kannada','Christian','Never Married',5.6),(3,'incharays@gmail.com','Myself','female','2003-10-08','Kannada','Christian','Never Married',5.6),(4,'sanika@gmail.com','Myself','male','2004-12-10','Malayalam','Buddhist','Widowed',5.2),(5,'sanikamn@gmail.com','Myself','female','2004-12-10','Malayalam','Buddhist','Widowed',5.2),(6,'incharay@gmail.com','Daughter','female','2003-10-21','Hindi','Christian','Divorced',5.3),(7,'incharas@gmail.com','Daughter','female','2003-10-21','Hindi','Others','Never Married',5.3),(8,'mrashmi@gmail.com','Sister','female','2004-04-04','Telugu','Hindu','Never Married',5.2),(9,'mrashmii@gmail.com','Sister','female','2004-04-04','Telugu','Hindu','Never Married',5.2),(10,'sameer123@gmail.com','Myself','Male','2003-09-18','Kannada','Hindu','Never married',5.6);
/*!40000 ALTER TABLE `matrimony` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-17 10:16:43
