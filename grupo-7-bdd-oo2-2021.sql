-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: grupo-7-bdd-oo2-2021
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Dumping data for table `lugar`
--

LOCK TABLES `lugar` WRITE;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
INSERT INTO `lugar` VALUES (1,'1824','Lanus'),(2,'7600','Mar del Plata'),(3,'1084','CABA'),(4,'1834','Temperley'),(6,'1900','La Plata'),(7,'1870','Avellaneda'),(8,'7165','Villa Gesell'),(9,'1828','Lomas de Zamora');
/*!40000 ALTER TABLE `lugar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `permiso`
--

LOCK TABLES `permiso` WRITE;
/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
INSERT INTO `permiso` VALUES (1,'2021-06-02',34),(2,'2021-06-01',35),(3,'2021-05-19',36),(4,'2021-06-02',37),(5,'2021-06-02',40),(6,'2021-06-02',41),(7,'2021-06-01',42),(8,'2021-06-02',43),(9,'2021-05-30',44),(10,'2021-06-02',45),(11,'2021-05-31',46),(12,'2021-06-02',47),(13,'2021-06-02',48);
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `permiso_desde_hasta`
--

LOCK TABLES `permiso_desde_hasta` WRITE;
/*!40000 ALTER TABLE `permiso_desde_hasta` DISABLE KEYS */;
INSERT INTO `permiso_desde_hasta` VALUES (1,1),(4,1),(7,1),(8,1),(10,1),(12,1),(13,1),(2,2),(4,2),(12,2),(1,3),(2,3),(5,3),(6,3),(7,3),(8,3),(9,3),(11,3),(6,4),(3,7),(9,7),(11,7),(13,7),(3,8),(10,8),(5,9);
/*!40000 ALTER TABLE `permiso_desde_hasta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `permiso_diario`
--

LOCK TABLES `permiso_diario` WRITE;
/*!40000 ALTER TABLE `permiso_diario` DISABLE KEYS */;
INSERT INTO `permiso_diario` VALUES ('Urgencia Familiar',1),('Trabajo',2),('Urgencia Familiar',5),('Urgencia Familiar',7),('Urgencia Familiar',9),('Urgencia Familiar',11),('Urgencia Familiar',13);
/*!40000 ALTER TABLE `permiso_diario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `permiso_periodo`
--

LOCK TABLES `permiso_periodo` WRITE;
/*!40000 ALTER TABLE `permiso_periodo` DISABLE KEYS */;
INSERT INTO `permiso_periodo` VALUES (4,_binary '',3,1),(4,_binary '',4,2),(4,_binary '',6,3),(5,_binary '',8,4),(5,_binary '',10,5),(4,_binary '',12,6);
/*!40000 ALTER TABLE `permiso_periodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'admin','2021-05-25 22:19:58.431003',99999998,'admin@admin.com','admin','DNI','2021-05-26 15:43:10.940336'),(2,'auditor','2021-05-25 22:20:32.829244',88888888,'auditor@auditor.com','auditor','DNI','2021-05-25 22:20:32.829244'),(3,'Sanchez Antelo','2021-05-26 13:57:47.152943',39557118,'Sofiasa@live.com.ar','Sofia','DNI','2021-06-02 17:09:29.668403'),(4,'Perez','2021-05-26 13:59:09.401249',23434232,'laura@hotmail.com','Laura','LE','2021-05-26 13:59:09.401861'),(5,'Rodriguez','2021-05-26 14:00:15.411900',37542129,'rodriguez@gmail.com','Juan','DNI','2021-05-26 15:57:30.693771'),(6,'Lopez','2021-05-26 14:01:09.847190',34324234,'lopez@gmail.com','Daniel','DNI','2021-05-26 14:01:09.847190'),(7,'Perez','2021-05-26 14:01:53.780033',38779443,'analia@live.com.ar','Analia','DNI','2021-05-26 14:01:53.780033'),(8,'Antelo','2021-05-26 15:15:15.997262',534543543,'sofia@live.com.ar','Sofia','DNI','2021-05-26 15:15:15.998259'),(9,'SanchezAntelo','2021-05-26 15:56:15.957863',5454353543,'sofiasa@gmail.com','Sofia','DNI','2021-05-26 15:56:15.957863'),(12,'rodriguez','2021-05-26 16:17:27.778947',432423433,'rodriguez01@gmail.com','rodriguez','DNI','2021-05-26 16:18:05.538905'),(34,'Gonzalez','2021-06-02 15:25:33.799206',43434433,'LucasGonzales@gmail.com','Lucas','DNI','2021-06-02 15:25:33.799206'),(35,'Ruiz','2021-06-02 15:26:40.349944',43212345,'Mariano01@hotmail.com','Mariano','DNI','2021-06-02 15:26:40.349944'),(36,'Fonseca','2021-06-02 15:29:08.344787',12545467,'fonseca@live.com.ar','Natalia','DNI','2021-06-02 15:29:08.344787'),(37,'Perez','2021-06-02 15:32:09.684228',34234322,'PerezLucas@gmail.com','Lucas','DNI','2021-06-02 15:32:09.684228'),(40,'Fernandez','2021-06-02 15:46:46.672757',54556565,'Fernandez@hotmail.com','David','DNI','2021-06-02 15:46:46.672757'),(41,'Gonzalez','2021-06-02 16:33:42.938853',656546554,'martin@hotmail.com','Martin','DNI','2021-06-02 16:33:42.938853'),(42,'Antelo','2021-06-02 16:35:37.285221',545435443,'sofia1234@hotmail.com','Sofia','DNI','2021-06-02 16:35:37.286219'),(43,'Perez','2021-06-02 16:43:48.558077',545443232,'LucasPerez@live.com.ar','Lucas','DNI','2021-06-02 16:43:48.558077'),(44,'Fernandez','2021-06-02 16:45:25.695086',765543543,'Mariano@gmail.com','Mariano','DNI','2021-06-02 16:45:25.695086'),(45,'Sanchez','2021-06-02 16:49:45.325318',65465454,'Mariano02@hotmail.com','Mariano','DNI','2021-06-02 16:49:45.325318'),(46,'Gonzalez','2021-06-02 16:51:11.741110',67657678,'Gonzales01@live.com.ar','Analia','DNI','2021-06-02 16:51:11.741110'),(47,'Perez','2021-06-02 17:01:52.866404',65464534,'Lorena@hotmail.com','Lorena','DNI','2021-06-02 17:01:52.866404'),(48,'Perez','2021-06-02 17:03:28.520826',76765543,'Romina@live.com.ar','Romina','DNI','2021-06-02 17:03:28.520826');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `rodado`
--

LOCK TABLES `rodado` WRITE;
/*!40000 ALTER TABLE `rodado` DISABLE KEYS */;
INSERT INTO `rodado` VALUES (1,'BZD424','CHEVROLET'),(2,'BFG405','CITROEN'),(3,'BRT567','CHEVROLET'),(4,'BWE456','CHEVROLET'),(5,'TRE345','CHEVROLET'),(6,'GRE123','CHEVROLET');
/*!40000 ALTER TABLE `rodado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'21232f297a57a5a743894a0e4a801fc3','2021-05-25 22:19:58.436843',1,'2021-05-26 15:43:10.943325','admin',1,1),(2,'f7d07071ed9431ecae3a8d45b4c82bb2','2021-05-25 22:20:32.834236',1,'2021-05-25 22:20:32.834236','auditor',2,2),(3,'53c862392de711af620dd0a49ee2f49b','2021-05-26 13:57:47.205444',1,'2021-06-02 17:09:29.670397','Sofiasa',3,1),(4,'680e89809965ec41e64dc7e447f175ab','2021-05-26 13:59:09.411987',0,'2021-05-26 16:18:24.480491','Laura01',4,2),(5,'29da068eb085cf10a453da1a15b47eae','2021-05-26 14:00:15.416747',0,'2021-05-26 15:57:41.101937','Juan',5,2),(6,'aa47f8215c6f30a0dcdb2a36a9f4168e','2021-05-26 14:01:09.852214',1,'2021-05-26 14:01:09.852214','Daniel',6,2),(7,'aaead7e4387cdce408a9dbab7a3f21ee','2021-05-26 14:01:53.785050',1,'2021-05-26 14:01:53.785050','Analia',7,1),(8,'827ccb0eea8a706c4c34a16891f84e7b','2021-05-26 15:15:16.026286',1,'2021-05-26 15:15:16.026286','Sofia',8,2),(9,'827ccb0eea8a706c4c34a16891f84e7b','2021-05-26 15:56:15.966838',1,'2021-05-26 15:56:15.966838','Sofia23',9,2),(10,'1f32aa4c9a1d2ea010adcf2348166a04','2021-05-26 16:17:27.783981',1,'2021-05-26 16:18:05.543890','pablo',12,2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuario_rol`
--

LOCK TABLES `usuario_rol` WRITE;
/*!40000 ALTER TABLE `usuario_rol` DISABLE KEYS */;
INSERT INTO `usuario_rol` VALUES (1,'2021-05-25 22:08:45.062671',1,'ROL_ADMIN','2021-05-25 22:08:45.062671'),(2,'2021-05-25 22:08:51.826094',1,'ROL_AUDITOR','2021-05-25 22:08:51.826094'),(5,'2021-06-02 21:57:07.000521',0,'ROL_USER','2021-06-02 21:58:06.146034');
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

-- Dump completed on 2021-06-02 22:00:57
