-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dblibrary$
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


CREATE DATABASE dblibrary;
USE dblibrary;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `idbook` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `gender` varchar(40) NOT NULL,
  `author` varchar(50) NOT NULL,
  `yearPublication` int NOT NULL,
  `state` tinyint NOT NULL,
  `user_numberClient` int DEFAULT NULL,
  PRIMARY KEY (`idbook`),
  KEY `fk_book_user1_idx` (`user_numberClient`),
  CONSTRAINT `fk_book_user1` FOREIGN KEY (`user_numberClient`) REFERENCES `user` (`numberClient`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'20.000 leguas de viajes submarino','Aventura','Julio Vener',2001,1,NULL),(2,'Corazon de Tinta','Fantasia','Cornelia Funke',2001,0,87);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `idEmployee` int NOT NULL AUTO_INCREMENT,
  `yearIncorporation` int NOT NULL,
  `sector` varchar(45) NOT NULL,
  `people_idPeople` int NOT NULL,
  PRIMARY KEY (`idEmployee`),
  KEY `fk_employee_people1_idx` (`people_idPeople`),
  CONSTRAINT `fk_employee_people1` FOREIGN KEY (`people_idPeople`) REFERENCES `people` (`idPeople`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,2020,'CEO',1),(3,1979,'CEO',4),(4,2005,'CEO',5);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `people`
--

DROP TABLE IF EXISTS `people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `people` (
  `idPeople` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `identificacionNumber` int NOT NULL,
  `maritalStatus` varchar(40) NOT NULL,
  PRIMARY KEY (`idPeople`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people`
--

LOCK TABLES `people` WRITE;
/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` VALUES (1,'Kira','Cruzate',565656,'Sotlera'),(2,'Nicolas','Cruzate',101,'Soltero'),(3,'Kira','Cruzate',454545,'Soltera'),(4,'Andreita','Bazan',24242424,'Divorsiada'),(5,'Enzito','Cruzate',18181818,'Soltero'),(6,'Cuchus','Rumim',989898,'Soltero'),(7,'Francisco','Almado',686868,'Soltero'),(8,'Mauro','Funes',878787,'Soltero');
/*!40000 ALTER TABLE `people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `numberClient` int NOT NULL,
  `rentedBooks` int NOT NULL,
  `totalBooksRented` int NOT NULL,
  `people_idPeople` int NOT NULL,
  PRIMARY KEY (`numberClient`),
  KEY `fk_user_people_idx` (`people_idPeople`),
  CONSTRAINT `fk_user_people` FOREIGN KEY (`people_idPeople`) REFERENCES `people` (`idPeople`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,0,1,2),(87,1,2,8);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dblibrary$'
--

--
-- Dumping routines for database 'dblibrary$'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-17 23:39:48
