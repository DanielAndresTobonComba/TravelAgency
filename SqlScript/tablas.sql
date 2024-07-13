-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pais` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Ciudad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Ciudad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `Pais_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Ciudad_Pais_idx` (`Pais_id` ASC) VISIBLE,
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE,
  CONSTRAINT `fk_Ciudad_Pais`
    FOREIGN KEY (`Pais_id`)
    REFERENCES `mydb`.`Pais` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Aeropuerto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Aeropuerto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `Ciudad_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Aeropuerto_Ciudad1_idx` (`Ciudad_id` ASC) VISIBLE,
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE,
  CONSTRAINT `fk_Aeropuerto_Ciudad1`
    FOREIGN KEY (`Ciudad_id`)
    REFERENCES `mydb`.`Ciudad` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`PuertaEmbargue`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PuertaEmbargue` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numeroPuerta` VARCHAR(10) NOT NULL,
  `Aeropuerto_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_PuertaEmbargue_Aeropuerto1_idx` (`Aeropuerto_id` ASC) VISIBLE,
  CONSTRAINT `fk_PuertaEmbargue_Aeropuerto1`
    FOREIGN KEY (`Aeropuerto_id`)
    REFERENCES `mydb`.`Aeropuerto` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Viaje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Viaje` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `precioTotal` DOUBLE NULL,
  `idAeropuertoOrigen` INT NULL,
  `idAeropuertoDestino` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Viaje_Aeropuerto1_idx` (`idAeropuertoOrigen` ASC) VISIBLE,
  INDEX `fk_Viaje_Aeropuerto2_idx` (`idAeropuertoDestino` ASC) VISIBLE,
  CONSTRAINT `fk_Viaje_Aeropuerto1`
    FOREIGN KEY (`idAeropuertoOrigen`)
    REFERENCES `mydb`.`Aeropuerto` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Viaje_Aeropuerto2`
    FOREIGN KEY (`idAeropuertoDestino`)
    REFERENCES `mydb`.`Aeropuerto` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Fabricante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Fabricante` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`ModeloAvion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ModeloAvion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  `Fabricante_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ModeloAvion_Fabricante1_idx` (`Fabricante_id` ASC) VISIBLE,
  CONSTRAINT `fk_ModeloAvion_Fabricante1`
    FOREIGN KEY (`Fabricante_id`)
    REFERENCES `mydb`.`Fabricante` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Estado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Avion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Avion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `placa` VARCHAR(30) NOT NULL,
  `capacidad` INT UNSIGNED NULL,
  `fechaFabricacion` DATE NOT NULL,
  `ModeloAvion_id` INT NULL,
  `Estado_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Avione_ModeloAvion1_idx` (`ModeloAvion_id` ASC) VISIBLE,
  INDEX `fk_Avione_Estado1_idx` (`Estado_id` ASC) VISIBLE,
  UNIQUE INDEX `placa_UNIQUE` (`placa` ASC) VISIBLE,
  CONSTRAINT `fk_Avione_ModeloAvion1`
    FOREIGN KEY (`ModeloAvion_id`)
    REFERENCES `mydb`.`ModeloAvion` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Avione_Estado1`
    FOREIGN KEY (`Estado_id`)
    REFERENCES `mydb`.`Estado` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`VueloConexion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`VueloConexion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numeroConexion` VARCHAR(20) NOT NULL,
  `idAeropuertoOrigen` INT NULL,
  `Viaje_id` INT NULL,
  `Avion_id` INT NULL,
  `idAeropuertoDestino` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_VueloConexion_Aeropuerto1_idx` (`idAeropuertoOrigen` ASC) VISIBLE,
  INDEX `fk_VueloConexion_Viaje1_idx` (`Viaje_id` ASC) VISIBLE,
  INDEX `fk_VueloConexion_Avion1_idx` (`Avion_id` ASC) VISIBLE,
  INDEX `fk_VueloConexion_Aeropuerto2_idx` (`idAeropuertoDestino` ASC) VISIBLE,
  UNIQUE INDEX `numeroConexion_UNIQUE` (`numeroConexion` ASC) VISIBLE,
  CONSTRAINT `fk_VueloConexion_Aeropuerto1`
    FOREIGN KEY (`idAeropuertoOrigen`)
    REFERENCES `mydb`.`Aeropuerto` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_VueloConexion_Viaje1`
    FOREIGN KEY (`Viaje_id`)
    REFERENCES `mydb`.`Viaje` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_VueloConexion_Avion1`
    FOREIGN KEY (`Avion_id`)
    REFERENCES `mydb`.`Avion` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_VueloConexion_Aeropuerto2`
    FOREIGN KEY (`idAeropuertoDestino`)
    REFERENCES `mydb`.`Aeropuerto` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Revision`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Revision` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `Avion_id` INT NULL,
  `descripcion` TEXT(200) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Revision_Avion1_idx` (`Avion_id` ASC) VISIBLE,
  CONSTRAINT `fk_Revision_Avion1`
    FOREIGN KEY (`Avion_id`)
    REFERENCES `mydb`.`Avion` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = Inno
