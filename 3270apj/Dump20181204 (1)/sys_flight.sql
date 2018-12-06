-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: sys
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `flight` (
  `idFlight` int(11) NOT NULL AUTO_INCREMENT,
  `departLocation` varchar(45) NOT NULL,
  `arrivalLocation` varchar(45) NOT NULL,
  `departDate` varchar(15) NOT NULL,
  `arrivalDate` varchar(15) NOT NULL,
  `departTime` varchar(10) NOT NULL,
  `arrivalTime` varchar(10) NOT NULL,
  `capacity` int(11) NOT NULL,
  `openSeats` int(185) NOT NULL,
  `layover` varchar(10) NOT NULL,
  `idAirport` int(11) DEFAULT NULL,
  `idAirplane` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFlight`),
  UNIQUE KEY `idFlight_UNIQUE` (`idFlight`),
  KEY `airport_id_idx` (`idAirport`),
  KEY `airplane_id_idx` (`idAirplane`),
  CONSTRAINT `airplane_id` FOREIGN KEY (`idAirplane`) REFERENCES `airplane` (`idairplane`),
  CONSTRAINT `airport_id` FOREIGN KEY (`idAirport`) REFERENCES `airport` (`idairport`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (2,'Atlanta, GA','Denver, CO','12/4/2018','12/12/2018','12:45pm','5:00pm',185,10,'1:30',NULL,NULL),(3,'San Francisco, CA','Atlanta, GA','12/25/2018','1/8/2019','10:45am','3:00pm',185,0,'0',NULL,NULL),(8,'San Diego, CA','Chicago, IL','12/28/2018','1/7/2019','7:30am','11:10pm',185,0,'2:00',NULL,NULL),(9,'Houston, TX','Jacksnville, FL','12/28/2018','1/12/2019','6:00am','4:30pm',185,0,'5:00',NULL,NULL),(10,'Miami, FL','Columbus, OH','12/28/2018','1/12/2019','3:20pm','9:00pm',185,0,'0',NULL,NULL),(11,'Phonix, AZ','Seattle, WA','1/2/2019','1/23/2019','1:50 pm','4:15pm',185,0,'3:20',NULL,NULL);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-04 17:21:00
