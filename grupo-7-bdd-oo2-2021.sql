CREATE DATABASE  IF NOT EXISTS `grupo-7-bdd-oo2-2021` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `grupo-7-bdd-oo2-2021`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: grupo-7-bdd-oo2-2021
-- ------------------------------------------------------
-- Server version	5.7.29-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='-03:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
  CREATE TABLE `persona` (
  `id` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(45) NOT NULL,
  `createdat` datetime(6) DEFAULT NULL,
  `dni` bigint NOT NULL,
  `email` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `tipo_documento` varchar(8) NOT NULL,
  `updatedat` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1, 'Rosales', '2021-05-22 15:59:59.220179',11111110,'jorge@gmail.com','Jorge', 'DNI', '2021-05-22 15:59:59.220179'),(2, 'Martinez','2021-05-22 15:59:59.220179',11111111,'luis@gmail.com', 'Luis', 'DNI', '2021-05-22 15:59:59.220179');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `clave` varchar(60) NOT NULL,
  `createdat` datetime(6) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `updatedat` datetime(6) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `persona_id` int NOT NULL,
  `rol_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_i02kr8ui5pqddyd7pkm3v4jbt` (`usuario`),
  KEY `FKlse7lqghmt3r1sp298ss9s5bc` (`persona_id`),
  KEY `FKbl9l2tfkiy0krho63kbqmlwyf` (`rol_id`),
  CONSTRAINT `FKbl9l2tfkiy0krho63kbqmlwyf` FOREIGN KEY (`rol_id`) REFERENCES `usuario_rol` (`id`),
  CONSTRAINT `FKlse7lqghmt3r1sp298ss9s5bc` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `usuario`
--
LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'$2a$10$G1ymZR3MR7gZPYlke5zLEucMTiRMyKQRvJ0UTvy.diFK/MVthBxrW','2021-05-22 15:59:59.220179', '1','2021-05-22 15:59:59.220179' ,'Jorge', 1, 1), (2,'$2a$10$G1ymZR3MR7gZPYlke5zLEucMTiRMyKQRvJ0UTvy.diFK/MVthBxrL','2021-05-22 15:59:59.220179', '1','2021-05-22 15:59:59.220179' ,'Luis', 2, 2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_rol`
--

DROP TABLE IF EXISTS `usuario_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_rol` (
  `id` int NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) DEFAULT NULL,
  `rol` varchar(100) NOT NULL,
  `updatedat` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9fb2oynawbjqah9pylnfgkxfj` (`rol`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_rol`
--

LOCK TABLES `usuario_rol` WRITE;
/*!40000 ALTER TABLE `usuario_rol` DISABLE KEYS */;
INSERT INTO `usuario_rol` VALUES (1,'2021-05-22 15:59:59.220179','ADMIN','2021-05-22 15:59:59.220179'),(2,'2021-05-22 15:59:59.220179','AUDITOR','2021-05-22 15:59:59.220179');
/*!40000 ALTER TABLE `usuario_rol` ENABLE KEYS */;
UNLOCK TABLES;


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;