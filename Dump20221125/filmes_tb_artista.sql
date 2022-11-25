-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: filmes
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `tb_artista`
--

DROP TABLE IF EXISTS `tb_artista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_artista` (
  `codArtista` int NOT NULL AUTO_INCREMENT,
  `cache` double NOT NULL,
  `nacionalidade` varchar(45) NOT NULL,
  `nascimento` datetime NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`codArtista`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_artista`
--

LOCK TABLES `tb_artista` WRITE;
/*!40000 ALTER TABLE `tb_artista` DISABLE KEYS */;
INSERT INTO `tb_artista` VALUES (1,10000000,'EUA','1974-11-11 00:00:00','Leonardo Di Caprio'),(2,5000000,'Australia','1983-01-11 00:00:00','Cate Blanchett'),(3,8000000,'UK','1999-09-04 00:00:00','Kate Winslet'),(5,5000000.49,'Australia','1983-01-11 00:00:00','Cate Blanchett'),(6,500.73,'Brasil','1966-11-03 00:00:00','Cuca'),(7,10000000.38,'EUA','1974-11-11 00:00:00','Leonardo Di Caprio'),(8,5000000.49,'Australia','1983-01-11 00:00:00','Cate Blanchett'),(9,8000000.51,'UK','1999-09-04 00:00:00','Kate Winslet'),(10,10000000.38,'EUA','1974-05-11 00:00:00','Leonardo Di Caprio'),(11,5000000.49,'Australia','1983-01-29 00:00:00','Cate Blanchett'),(12,8000000.51,'UK','1999-09-04 00:00:00','Kate Winslet');
/*!40000 ALTER TABLE `tb_artista` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-25 10:18:56
