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
-- Table structure for table `tb_participacao`
--

DROP TABLE IF EXISTS `tb_participacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_participacao` (
  `codParticipacao` int NOT NULL AUTO_INCREMENT,
  `codArtista` int NOT NULL,
  `codFilme` int NOT NULL,
  `desconto` double NOT NULL,
  `personagem` varchar(45) NOT NULL,
  PRIMARY KEY (`codParticipacao`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_participacao`
--

LOCK TABLES `tb_participacao` WRITE;
/*!40000 ALTER TABLE `tb_participacao` DISABLE KEYS */;
INSERT INTO `tb_participacao` VALUES (10,19,12,2000000,'Jack Dawson'),(11,19,11,1000000,'Howard Hughes'),(12,21,12,1000000,'Rose Bukater'),(13,20,11,500000,'Katharine Heburn'),(14,19,12,0,'Joaozinho'),(15,1,2,2000000,'Jack Dawson'),(16,1,1,1000000,'Howard Hughes'),(17,3,2,1000000,'Rose Bukater'),(18,2,1,500000,'Katharine Heburn'),(19,19,11,2000,'krook'),(20,19,11,250,'krool'),(21,19,11,2000,'k'),(22,23,12,3000,'ancora'),(23,22,11,2000,'motor'),(24,19,11,2,'Tom bolado');
/*!40000 ALTER TABLE `tb_participacao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-01  8:49:42
