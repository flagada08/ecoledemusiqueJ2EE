CREATE DATABASE  IF NOT EXISTS `ecoledemusique` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ecoledemusique`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ecoledemusique
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `musicien`
--

DROP TABLE IF EXISTS `musicien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musicien` (
  `id_musicien` int unsigned NOT NULL AUTO_INCREMENT,
  `name` char(25) DEFAULT NULL,
  `firstname` char(25) DEFAULT NULL,
  `password` varchar(56) NOT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `rue` varchar(45) DEFAULT NULL,
  `code_postal` varchar(45) DEFAULT NULL,
  `ville` varchar(45) DEFAULT NULL,
  `telephone` varchar(12) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `instrument` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_musicien`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musicien`
--

LOCK TABLES `musicien` WRITE;
/*!40000 ALTER TABLE `musicien` DISABLE KEYS */;
INSERT INTO `musicien` VALUES (1,'Bombeur','Jean','1234567891','01','rue1','01111','ville1','1234567890','jean.bombeur@gmail.com','Pipo'),(2,'Pull','Amed','12345678922','02','rue2','02222','ville2','+33123456789','pull.amed@gmail.com','Flute'),(3,'Deuf','Jon','123456789333','03','rue3','03333','ville3','0123456789','jon.deuf@gmail.com','Trompette'),(92,'PERSIN','TERENCE','123456789','21B','RUE DE LA CROISETTE','55800','SOMMEILLES','0601858842','flagada08@gmail.com','PIPO'),(94,'NOEL','SOPHIE','1234567894','21B','RUE DE LA CROISETTE','55800','SOMMEILLES','0676233540','sophienoel03@gmail.com','Flute');
/*!40000 ALTER TABLE `musicien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-13 17:51:46
