-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: test
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
-- Table structure for table `porder`
--

DROP TABLE IF EXISTS `porder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `porder` (
  `porderId` int NOT NULL AUTO_INCREMENT,
  `product` varchar(45) NOT NULL,
  `amount` int NOT NULL,
  `imgNo` varchar(45) NOT NULL,
  `mode` varchar(45) NOT NULL,
  `items` varchar(45) NOT NULL,
  PRIMARY KEY (`porderId`),
  UNIQUE KEY `imgNo_UNIQUE` (`imgNo`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `porder`
--

LOCK TABLES `porder` WRITE;
/*!40000 ALTER TABLE `porder` DISABLE KEYS */;
INSERT INTO `porder` VALUES (1,'Iphone',3000,'1','15pro 64G','手機'),(2,'Samsung',2500,'2','Galaxy A54 5G','手機'),(3,'OPPO',2000,'3','Reno8 Z 5G','手機'),(4,'MSI',4000,'4','GE78 HX 13V','電腦'),(5,'asus',3000,'5','Vivobook 15 (X1502)','電腦'),(6,'acer',2000,'6','Aspire Vero','電腦'),(7,'PS5',3000,'7','超讚','電動'),(8,'Xbox',3500,'8','Serice X','電動'),(9,'switch',2500,'9','Nintendo Switch™（OLED款式）主機［HEG-001］','電動'),(10,'滑鼠',500,'10','G502 HERO','其他'),(11,'鍵盤',250,'11','V65 巨浪 65% RGB 英文機械式鍵盤','其他'),(12,'耳機',100,'12','無線藍牙頭戴式耳機 ( BTE-3860)','其他');
/*!40000 ALTER TABLE `porder` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-14 16:28:27
