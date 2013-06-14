CREATE DATABASE  IF NOT EXISTS `proydawii` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */;
USE `proydawii`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: proydawii
-- ------------------------------------------------------
-- Server version	5.5.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comentarios` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `direccion` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `email` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `foto` longblob,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `nombrecomercial` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `ruc` varchar(11) COLLATE latin1_spanish_ci NOT NULL,
  `telefono` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `weburl` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  UNIQUE KEY `nombrecomercial` (`nombrecomercial`),
  UNIQUE KEY `ruc` (`ruc`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
INSERT INTO `empresa` VALUES (1,'','JR. RIOS 1234 LIMA','kfc@mial.com',NULL,'ASUS SAC','KENTUCKY FRIED CHICKEN','98765432112','987444562','');
UNLOCK TABLES;

--
-- Table structure for table `productotienda`
--

DROP TABLE IF EXISTS `productotienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productotienda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `foto` longblob,
  `masFotos` varchar(32) COLLATE latin1_spanish_ci DEFAULT NULL,
  `observaciones` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `precio` decimal(19,2) DEFAULT NULL,
  `categoriaproducto_id` int(11) DEFAULT NULL,
  `tienda_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `descripcion` (`descripcion`),
  KEY `FK14D1745B694BB50C` (`tienda_id`),
  KEY `FK14D1745BB6599C68` (`categoriaproducto_id`),
  CONSTRAINT `FK14D1745B694BB50C` FOREIGN KEY (`tienda_id`) REFERENCES `tienda` (`id`),
  CONSTRAINT `FK14D1745BB6599C68` FOREIGN KEY (`categoriaproducto_id`) REFERENCES `categoriaproducto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productotienda`
--

LOCK TABLES `productotienda` WRITE;
INSERT INTO `productotienda` VALUES (1,'INCA COLA 1LT',NULL,'','',7.00,1,1),(2,'POLLO ENTERO',NULL,'','',45.00,2,1),(3,'MUFFIN',NULL,'','',3.00,3,1),(5,'Bembos grande',NULL,'','',10.00,2,2);
UNLOCK TABLES;

--
-- Table structure for table `distrito`
--

DROP TABLE IF EXISTS `distrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distrito` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distrito`
--

LOCK TABLES `distrito` WRITE;
INSERT INTO `distrito` VALUES (1,'Ancón'),(2,'Ate'),(3,'Barranco'),(4,'Breña'),(5,'Carabayllo'),(6,'Chaclacayo'),(7,'Chorrillos'),(8,'Cieneguilla'),(9,'Comas'),(10,'El Agustino'),(11,'Independencia'),(12,'Jesús María'),(13,'La Molina'),(14,'La Victoria'),(15,'Lince'),(16,'Los Olivos'),(17,'Lurigancho-Chosica'),(18,'Lurín'),(19,'Magdalena Del Mar'),(20,'Pueblo Libre'),(21,'Miraflores'),(22,'Pachacámac'),(23,'Pucusana'),(24,'Puente Piedra'),(25,'Punta Hermosa'),(26,'Punta Negra'),(27,'Rímac'),(28,'San Bartolo'),(29,'San Borja'),(30,'San Isidro'),(31,'San Juan de Lurigancho'),(32,'San Juan de Miraflores'),(33,'San Luis'),(34,'San Martín de Porres'),(35,'San Miguel'),(36,'Santa Anita'),(37,'Santa María del Mar'),(38,'Santa Rosa'),(39,'Santiago de Surco'),(40,'Surquillo'),(41,'Villa El Salvador'),(42,'Villa María del Triunfo'),(43,'Lima'),(44,'Callao Cercado'),(45,'Bellavista'),(46,'Carmen De La Legua'),(47,'La Perla'),(48,'La Punta'),(49,'Ventanilla');
UNLOCK TABLES;

--
-- Table structure for table `tienda`
--

DROP TABLE IF EXISTS `tienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tienda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `calle` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `telefono` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `distrito_id` int(11) DEFAULT NULL,
  `empresa_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `descripcion` (`descripcion`),
  KEY `FK954E4AFBF815B6C` (`distrito_id`),
  KEY `FK954E4AFBFBDAEA28` (`empresa_id`),
  CONSTRAINT `FK954E4AFBFBDAEA28` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id`),
  CONSTRAINT `FK954E4AFBF815B6C` FOREIGN KEY (`distrito_id`) REFERENCES `distrito` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tienda`
--

LOCK TABLES `tienda` WRITE;
INSERT INTO `tienda` VALUES (1,'Jr. Larco 123','KFC Miraflores','321654987',21,1),(2,'jr larco 1234','Bembos Miraflores','951753265',21,1);
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `fechahoraentrada` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `fechahorasalida` datetime DEFAULT NULL,
  `observaciones` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `porcentajeigv` decimal(19,2) DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `estadoregistropedido_id` int(11) DEFAULT NULL,
  `tienda_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8E4203659BAC2888` (`cliente_id`),
  KEY `FK8E420365694BB50C` (`tienda_id`),
  KEY `FK8E4203658BCA0AAC` (`estadoregistropedido_id`),
  CONSTRAINT `FK8E4203659BAC2888` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FK8E420365694BB50C` FOREIGN KEY (`tienda_id`) REFERENCES `tienda` (`id`),
  CONSTRAINT `FK8E4203658BCA0AAC` FOREIGN KEY (`estadoregistropedido_id`) REFERENCES `estadoregistropedido` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
INSERT INTO `pedido` VALUES (3,'2013-06-15 18:54:00','2013-07-10 18:54:00','',18.00,1,1,1);
UNLOCK TABLES;

--
-- Table structure for table `repartidor`
--

DROP TABLE IF EXISTS `repartidor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `repartidor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `dni` varchar(8) COLLATE latin1_spanish_ci DEFAULT NULL,
  `email` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `foto` longblob,
  `nombre` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `telefono` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `tienda_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni` (`dni`),
  KEY `FK5627A04694BB50C` (`tienda_id`),
  CONSTRAINT `FK5627A04694BB50C` FOREIGN KEY (`tienda_id`) REFERENCES `tienda` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repartidor`
--

LOCK TABLES `repartidor` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `detallepedido`
--

DROP TABLE IF EXISTS `detallepedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallepedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `preciounitario` decimal(19,2) DEFAULT NULL,
  `pedido_id` int(11) DEFAULT NULL,
  `producto_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6EE90F5C6B926FC7` (`producto_id`),
  KEY `FK6EE90F5C3440E4CC` (`pedido_id`),
  CONSTRAINT `FK6EE90F5C3440E4CC` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`),
  CONSTRAINT `FK6EE90F5C6B926FC7` FOREIGN KEY (`producto_id`) REFERENCES `productotienda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallepedido`
--

LOCK TABLES `detallepedido` WRITE;
INSERT INTO `detallepedido` VALUES (1,2,7.00,3,3),(2,5,45.00,3,2),(3,5,10.00,3,5),(4,20,7.00,3,1);
UNLOCK TABLES;

--
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `images` (
  `ID` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `GALLERY` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `IMAGE` longblob,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `tipocliente`
--

DROP TABLE IF EXISTS `tipocliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipocliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocliente`
--

LOCK TABLES `tipocliente` WRITE;
INSERT INTO `tipocliente` VALUES (1,'STANDARD'),(2,'VIP');
UNLOCK TABLES;

--
-- Table structure for table `categoriaproducto`
--

DROP TABLE IF EXISTS `categoriaproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoriaproducto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `descripcion` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoriaproducto`
--

LOCK TABLES `categoriaproducto` WRITE;
INSERT INTO `categoriaproducto` VALUES (1,'BEBIDAS'),(2,'COMIDAS'),(3,'POSTRES');
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `calle` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `lote` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `numero` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `urbanizacion` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `dni` varchar(8) COLLATE latin1_spanish_ci NOT NULL,
  `email` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `foto` longblob,
  `nombre` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `telefono` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `distrito_id` int(11) DEFAULT NULL,
  `tipocliente_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni` (`dni`),
  UNIQUE KEY `email` (`email`),
  KEY `FK96841DDAF0E33E08` (`tipocliente_id`),
  KEY `FK96841DDAF815B6C` (`distrito_id`),
  CONSTRAINT `FK96841DDAF0E33E08` FOREIGN KEY (`tipocliente_id`) REFERENCES `tipocliente` (`id`),
  CONSTRAINT `FK96841DDAF815B6C` FOREIGN KEY (`distrito_id`) REFERENCES `distrito` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
INSERT INTO `cliente` VALUES (1,'LOPEZ','JIRON GRAU','','123','','41806423','yvanchus@gmail.com',NULL,'YVAN','984118814',19,2);
UNLOCK TABLES;

--
-- Table structure for table `estadoregistropedido`
--

DROP TABLE IF EXISTS `estadoregistropedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadoregistropedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `descripcion` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoregistropedido`
--

LOCK TABLES `estadoregistropedido` WRITE;
INSERT INTO `estadoregistropedido` VALUES (1,'Activo');
UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-13 19:55:55
