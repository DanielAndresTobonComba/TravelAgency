-- MySQL Workbench Forward Engineering

-- CREACIÓN DE LA BASE DE DATOS

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

drop schema if exists `mydb`;
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
  `nombre` VARCHAR(100) NOT NULL unique,
  `Ciudad_id` INT NULL,
  `numeroAeropuerto` VARCHAR(12) null unique,
  PRIMARY KEY (`id`),
  INDEX `fk_Aeropuerto_Ciudad1_idx` (`Ciudad_id` ASC) VISIBLE,
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE,
  CONSTRAINT `fk_Aeropuerto_Ciudad1`
    FOREIGN KEY (`Ciudad_id`)
    REFERENCES `mydb`.`Ciudad` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX serialAeropuerto ON mydb.Aeropuerto (numeroAeropuerto);


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
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  `descripcion` TEXT(50) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Revision_Avion1_idx` (`Avion_id` ASC) VISIBLE,
  CONSTRAINT `fk_Revision_Avion1`
    FOREIGN KEY (`Avion_id`)
    REFERENCES `mydb`.`Avion` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Aerolinea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Aerolinea` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TripulacionRol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TripulacionRol` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Rol` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TipoDocumento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TipoDocumento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Empleado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `fechaIngreso` DATE NULL,
  `Ciudad_id` INT NULL,
  `Aerolinia_id` INT NULL,
  `TripulacionRol_id` INT NULL,
  `TipoDocumento_id` INT NULL,
  `usuario` VARCHAR(25) NULL,
  `contraseña` VARCHAR(70) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Empleado_Ciudad1_idx` (`Ciudad_id` ASC) VISIBLE,
  INDEX `fk_Empleado_Aerolinia1_idx` (`Aerolinia_id` ASC) VISIBLE,
  INDEX `fk_Empleado_TripulacionRol1_idx` (`TripulacionRol_id` ASC) VISIBLE,
  INDEX `fk_Empleado_TipoDocumento1_idx` (`TipoDocumento_id` ASC) VISIBLE,
  CONSTRAINT `fk_Empleado_Ciudad1`
    FOREIGN KEY (`Ciudad_id`)
    REFERENCES `mydb`.`Ciudad` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Empleado_Aerolinia1`
    FOREIGN KEY (`Aerolinia_id`)
    REFERENCES `mydb`.`Aerolinea` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Empleado_TripulacionRol1`
    FOREIGN KEY (`TripulacionRol_id`)
    REFERENCES `mydb`.`Rol` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Empleado_TipoDocumento1`
    FOREIGN KEY (`TipoDocumento_id`)
    REFERENCES `mydb`.`TipoDocumento` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`RevisionEmpleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`RevisionEmpleado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Revision_id` INT NULL,
  `Empleado_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Revision_has_Empleado_Empleado1_idx` (`Empleado_id` ASC) VISIBLE,
  INDEX `fk_Revision_has_Empleado_Revision1_idx` (`Revision_id` ASC) VISIBLE,
  CONSTRAINT `fk_Revision_has_Empleado_Revision1`
    FOREIGN KEY (`Revision_id`)
    REFERENCES `mydb`.`Revision` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Revision_has_Empleado_Empleado1`
    FOREIGN KEY (`Empleado_id`)
    REFERENCES `mydb`.`Empleado` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EmpleadoVueloConexion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`EmpleadoVueloConexion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Empleado_id` INT NULL,
  `VueloConexion_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Empleado_has_VueloConexion_VueloConexion1_idx` (`VueloConexion_id` ASC) VISIBLE,
  INDEX `fk_Empleado_has_VueloConexion_Empleado1_idx` (`Empleado_id` ASC) VISIBLE,
  CONSTRAINT `fk_Empleado_has_VueloConexion_Empleado1`
    FOREIGN KEY (`Empleado_id`)
    REFERENCES `mydb`.`Empleado` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Empleado_has_VueloConexion_VueloConexion1`
    FOREIGN KEY (`VueloConexion_id`)
    REFERENCES `mydb`.`VueloConexion` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
    
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tarifa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Tarifa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(50) NOT NULL,
  `detalle` VARCHAR(50)NOT NULL,
  `precioBase`  DECIMAL(10, 2) NOT NULL,
  `impuesto`  DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL,
  `edad` varchar(2) NULL,
  `TipoDocumento_id` INT NULL,
  `usuario` VARCHAR(25) NULL unique,
  `contraseña` VARCHAR(70) NULL,
  `numeroDocumento` varchar(15) not null unique,
  PRIMARY KEY (`id`),
  INDEX `fk_Cliente_TipoDocumento1_idx` (`TipoDocumento_id` ASC) VISIBLE,
  CONSTRAINT `fk_Cliente_TipoDocumento1`
    FOREIGN KEY (`TipoDocumento_id`)
    REFERENCES `mydb`.`TipoDocumento` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;
CREATE INDEX clienteIdentificacion ON mydb.Cliente (numeroDocumento);

-- -----------------------------------------------------
-- Table `mydb`.`MetodoPago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`MetodoPago` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Reservacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Reservacion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `Viaje_id` INT NULL,
  `Tarifa_id` INT NULL,
  `Cliente_id` INT NULL,
  `MetodoPago_id` INT NULL,
  `estadoPago` TINYINT NOT NULL,
  `nombrePasajero` VARCHAR(50) NOT NULL,
  `edad` INT NOT NULL,
  `dni` VARCHAR(15) NOT NULL,
  `TipoDocumento_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Reservacion_Viaje1_idx` (`Viaje_id` ASC) VISIBLE,
  INDEX `fk_Reservacion_Tarifas1_idx` (`Tarifa_id` ASC) VISIBLE,
  INDEX `fk_Reservacion_Clientes1_idx` (`Cliente_id` ASC) VISIBLE,
  INDEX `fk_Reservacion_MetodoPago1_idx` (`MetodoPago_id` ASC) VISIBLE,
  INDEX `fk_Reservacion_TipoDocumento1_idx` (`TipoDocumento_id` ASC) VISIBLE,
  CONSTRAINT `fk_Reservacion_Viaje1`
    FOREIGN KEY (`Viaje_id`)
    REFERENCES `mydb`.`Viaje` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Reservacion_Tarifas1`
    FOREIGN KEY (`Tarifa_id`)
    REFERENCES `mydb`.`Tarifa` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Reservacion_Clientes1`
    FOREIGN KEY (`Cliente_id`)
    REFERENCES `mydb`.`Cliente` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Reservacion_MetodoPago1`
    FOREIGN KEY (`MetodoPago_id`)
    REFERENCES `mydb`.`MetodoPago` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Reservacion_TipoDocumento1`
    FOREIGN KEY (`TipoDocumento_id`)
    REFERENCES `mydb`.`TipoDocumento` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TarjetaCliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TarjetaCliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titular` VARCHAR(45) NULL,
  `codigoSeguridad` VARCHAR(25) NULL,
  `numeroTarjeta` VARCHAR(25) NULL,
  `Cliente_id` INT NULL,
  INDEX `fk_TarjetaCliente_Cliente1_idx` (`Cliente_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_TarjetaCliente_Cliente1`
    FOREIGN KEY (`Cliente_id`)
    REFERENCES `mydb`.`Cliente` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Boleto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Boleto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `asiento` VARCHAR(12) NOT NULL,
  `VueloConexion_id` INT NULL,
  `Reservacion_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Boleto_VueloConexion1_idx` (`VueloConexion_id` ASC) VISIBLE,
  INDEX `fk_Boleto_Reservacion1_idx` (`Reservacion_id` ASC) VISIBLE,
  CONSTRAINT `fk_Boleto_VueloConexion1`
    FOREIGN KEY (`VueloConexion_id`)
    REFERENCES `mydb`.`VueloConexion` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Boleto_Reservacion1`
    FOREIGN KEY (`Reservacion_id`)
    REFERENCES `mydb`.`Reservacion` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EstadoPago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`EstadoPago` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `estado` VARCHAR(45) NULL,
  `Reservacion_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_EstadoPago_Reservacion1_idx` (`Reservacion_id` ASC) VISIBLE,
  CONSTRAINT `fk_EstadoPago_Reservacion1`
    FOREIGN KEY (`Reservacion_id`)
    REFERENCES `mydb`.`Reservacion` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Permiso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Permiso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigoPermiso` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PermisoEmpleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PermisoEmpleado` (
  `Empleado_id` INT NULL,
  `Permiso_id` INT NULL,
  `status` INT(1) NOT NULL DEFAULT 1,
  `id` INT NOT NULL AUTO_INCREMENT,
  INDEX `fk_Empleado_has_Permiso_Permiso1_idx` (`Permiso_id` ASC) VISIBLE,
  INDEX `fk_Empleado_has_Permiso_Empleado1_idx` (`Empleado_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Empleado_has_Permiso_Empleado1`
    FOREIGN KEY (`Empleado_id`)
    REFERENCES `mydb`.`Empleado` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Empleado_has_Permiso_Permiso1`
    FOREIGN KEY (`Permiso_id`)
    REFERENCES `mydb`.`Permiso` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

--  --------------------------------------------------------------------------- INSERCIONES ---------------------------------------------------------------------

/* INSERCIONES DE DATOS */

-- Insertar datos en la tabla `Pais`
INSERT INTO `mydb`.`Pais` (`nombre`) VALUES
('Estados Unidos'),
('México'),
('Argentina'),
('España'),
('Japón');




-- Insertar datos en la tabla `Ciudad`
INSERT INTO `mydb`.`Ciudad` (`nombre`, `Pais_id`) VALUES
-- Ciudades en Estados Unidos (id = 1)
('Nueva York', 1),
('Los Ángeles', 1),
-- Ciudades en México (id = 2)
('Ciudad de México', 2),
('Guadalajara', 2),
-- Ciudades en Argentina (id = 3)
('Buenos Aires', 3),
('Córdoba', 3),
-- Ciudades en España (id = 4)
('Madrid', 4),
('Barcelona', 4),
-- Ciudades en Japón (id = 5)
('Tokio', 5),
('Osaka', 5);


-- Insertar datos en la tabla `Aeropuerto`
INSERT INTO `mydb`.`Aeropuerto` (`nombre`, `Ciudad_id`, `numeroAeropuerto`) VALUES
-- Aeropuertos en ciudades de Estados Unidos
('Aeropuerto Internacional John F. Kennedy', 1, 'JFK1'),
('Aeropuerto Internacional de Los Ángeles', 2, 'LAX2'),
-- Aeropuertos en ciudades de México
('Aeropuerto Internacional de la Ciudad de México', 3, 'MEX3'),
('Aeropuerto Internacional de Guadalajara', 4, 'GDL4'),
-- Aeropuertos en ciudades de Argentina
('Aeropuerto Internacional Ministro Pistarini', 5, 'EZE5'),
('Aeropuerto Internacional Ingeniero Ambrosio L.V. Taravella', 6, 'COR6'),
-- Aeropuertos en ciudades de España
('Aeropuerto Adolfo Suárez Madrid-Barajas', 7, 'MAD7'),
('Aeropuerto de Barcelona-El Prat', 8, 'BCN8'),
-- Aeropuertos en ciudades de Japón
('Aeropuerto Internacional de Narita', 9, 'NRT9'),
('Aeropuerto Internacional de Kansai', 10, 'KIX0');




-- Insertar en la tabla TipoDocumento
INSERT INTO `mydb`.`TipoDocumento` (`nombre`)
VALUES 
  ('DNI'),
  ('Pasaporte'),
  ('Carné de conducir'),
  ('NIE (Número de Identificación de Extranjero)'),
  ('Tarjeta de residencia');
  
-- Insertar en  la tabla Cliente  
INSERT INTO `Cliente` (`nombre`, `edad`, `TipoDocumento_id`, `usuario`, `contraseña`, `numeroDocumento`)
VALUES
    ('Juan Pérez', 30, 1, 'juanperez30', 'abc123', '12345678'),
    ('María López', 25, 2, 'marialopez25', 'def456', '87654321'),
    ('Carlos Martínez', 40, 3, 'carlosm40', 'ghi789', '56781234'),
    ('Ana Gómez', 28, 4, 'anagomez28', 'jkl012', '43218765'),
    ('Pedro Ramírez', 35, 5, 'pedror35', 'mno345', '98765432'),
    ('Luisa Fernández', 22, 1, 'luisaf22', 'pqr678', '876543211'),
    ('Elena Torres', 33, 2, 'elenat33', 'stu901', '76543218'),
    ('Javier García', 45, 3, 'javierg45', 'vwx234', '67812345'),
    ('Sofía Rodríguez', 26, 4, 'sofiar26', 'yz567', '54321678'),
    ('Martín Sánchez', 31, 5, 'martins31', 'abc890', '32187654');

-- Inserciones para la tabla rol
INSERT INTO `mydb`.`Rol` (`nombre`) VALUES 
('Administrador'), 
('Agente de ventas'),
('Tecnico de mantenimiento'), 
('Desarrollador'), 
('Analista'),
('Capitán'),
('Primer Oficial'),
('Sobrecargo'),
('Auxiliar de Vuelo'),
('Mecánico de Aeronaves');


-- Insertar en la tabla Aerolinea
INSERT INTO Aerolinea (nombre) VALUES 
("Copa Airlines"),
("Avianca"),
("Aeromexico"),
("Aerolineas Argentina"),
("LATAM Airlines"),
("Interjet"),
("American Airlines"),
("United Airlines"),
("Delta Airlines"),
("Southwest Airlines");





-- Insertar datos en la tabla Empleado
INSERT INTO Empleado (name, fechaIngreso, Ciudad_id,  Aerolinia_id, TripulacionRol_id, TipoDocumento_id, usuario, contraseña)
VALUES ("Carlos Jhoan Aguilar Galvis", "2020-01-01", 5, 1, 1, 1, "admin123", "240BE518FABD2724DDB6F04EEB1DA5967448D7E831C08C8FA822809F74C720A9");


INSERT INTO `mydb`.`Empleado` (`name`, `fechaIngreso`, `Ciudad_id`, `Aerolinia_id`, `TripulacionRol_id`, `TipoDocumento_id`, `usuario`, `contraseña`) VALUES
('Juan Pérez', '2022-01-15', 1, 1, 6, 1, 'jperez', 'pwd1'),
('Ana Gómez', '2021-05-22', 2, 2, 7, 2, 'agomez', 'pwd2'),
('Carlos López', '2020-03-10', 3, 3, 8, 3, 'clopez', 'pwd3'),
('María Fernández', '2019-08-05', 4, 4, 9, 4, 'mfernandez', 'pwd4'),
('Luis Martínez', '2018-12-20', 5, 5, 10, 5, 'lmartinez', 'pwd5'),
('Carmen Torres', '2017-11-30', 6, 1, 1, 1, 'ctorres', 'pwd6'),
('José Rodríguez', '2016-06-25', 7, 2, 2, 2, 'jrodriguez', 'pwd7'),
('Laura Ramírez', '2015-09-12', 8, 3, 3, 3, 'lramirez', 'pwd8'),
('Miguel Sánchez', '2014-04-17', 9, 4, 4, 4, 'msanchez', 'pwd9'),
('Elena González', '2013-02-28', 10, 5, 5, 5, 'egonzalez', 'pwd10');

-- Insertar datos en la tabla Estado
INSERT INTO Estado(nombre) VALUES
('Activo'), 
('En reparacion');

-- Insertar datos en la tabla fabricante
INSERT INTO `mydb`.`Fabricante` (`nombre`) VALUES 
('Boeing'),
('Airbus'),
('Embraer'),
('Bombardier'),
('Cessna');

-- Insertar datos en la tabla modelo avion
INSERT INTO `mydb`.`ModeloAvion` (`nombre`, `Fabricante_id`) VALUES 
('737-800', 1),
('A320neo', 2),
('E195-E2', 3),
('CRJ700', 4),
('Citation Longitude', 5),
('787-9', 1),
('A330-900', 2),
('E175', 3),
('Global Express', 4),
('Citation Mustang', 5);

-- Insertar datos en la tabla tarifa
INSERT INTO `mydb`.`Tarifa` (`descripcion`, `detalle`, `precioBase`, `impuesto`) VALUES 
('Tarifa Básica', 'Servicios básicos', 100.00, 15.00),
('Tarifa Premium', 'Servicios premium', 200.00, 30.00),
('Tarifa Económica', 'Servicios económicos', 50.00, 7.50),
('Tarifa Corporativa', 'Servicios para empresas', 500.00, 75.00),
('Tarifa Estudiante', 'Descuento para estudiantes', 75.00, 11.25);


-- Insertar datos en la tabla avion
INSERT INTO `mydb`.`Avion` (`placa`, `capacidad`, `fechaFabricacion`, `ModeloAvion_id`, `Estado_id`) VALUES 
('N737800', 189, '2018-05-20', 1, 1),
('F-A320NEO', 195, '2019-03-15', 2, 1),
('PR-E195E2', 146, '2020-07-10', 3, 2),
('C-CRJ700', 78, '2016-08-30', 4, 1),
('N-CLONG', 12, '2021-11-25', 5, 1),
('N7879', 296, '2017-12-05', 6, 2),
('F-A330900', 287, '2022-09-18', 7, 1),
('PR-E175', 88, '2015-02-20', 8, 1),
('C-GEXPRESS', 19, '2018-10-10', 9, 2),
('N-MUSTANG', 4, '2020-04-14', 10, 1);

INSERT INTO `mydb`.`Revision` (`fecha`, `Avion_id`, `descripcion`) VALUES 
('2024-01-15', 1, 'Revisión general de mantenimiento con cambio de filtros y aceite.'),
('2024-02-10', 2, 'Inspección de motores y pruebas de vuelo después de actualización de software.'),
('2024-03-20', 3, 'Revisión de sistema de frenos y reemplazo de llantas.'),
('2024-04-05', 4, 'Chequeo de sistemas electrónicos y calibración de instrumentos.'),
('2024-05-18', 5, 'Revisión completa de fuselaje y limpieza profunda de interiores.');


INSERT INTO `mydb`.`RevisionEmpleado` (`Revision_id`, `Empleado_id`) VALUES 
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(3, 6),
(4, 7),
(4, 8),
(5, 9),
(5, 10);

-- select * from Revision 
 Select * from Avion;


-- ----------------------------------------------------------------------------- ---------------------------------------------------------------------
--  																PROCEDURES 
-- --------------------------------------------------------------------------------------------------------------------------------------------------

-- Procedure para obtener la información de un Empleado en especìfico
DROP PROCEDURE if EXISTS  ObtainEMpleado;

delimiter &&

CREATE PROCEDURE ObtainEmpleado (IN nombreUsuario VARCHAR(45), IN rolNombre VARCHAR(45))
BEGIN

	SELECT e.id, e.name AS nombreEmpleado, e.fechaIngreso, c.nombre AS ciudadNombre, a.nombre AS aerolinea, r.nombre AS rolNombre, d.nombre AS tipodocumentoNombre, e.usuario, e.contraseña
	FROM Empleado AS  e, Ciudad AS c, TipoDocumento AS d, Rol AS r, Aerolinea AS a
	WHERE c.id = e.Ciudad_id AND
			d.id = e.TipoDocumento_id AND 
			r.id = e.TripulacionRol_id AND
			a.id = e.Aerolinia_id AND
			e.usuario = nombreUsuario AND 
			r.nombre = rolNombre;
		
END &&
delimiter ;

-- Procedure para obtener los Roles

DROP PROCEDURE if EXISTS ObtainRol;

delimiter &&
CREATE PROCEDURE ObtainRol()
BEGIN
	SELECT  nombre
	FROM Rol;
END &&
delimiter ;

-- Procedure para obtener las placas

DROP PROCEDURE IF EXISTS ObtainPlacas;

delimiter &&
CREATE PROCEDURE ObtainPlacas()
BEGIN
	SELECT	placa
    FROM	Avion;
END&&
delimiter ;

-- Procedure para eliminar un Aeropuerto

DELIMITER $$

DROP PROCEDURE IF EXISTS eliminarAeropuerto $$
CREATE PROCEDURE eliminarAeropuerto
   (IN numAeropuerto VARCHAR(12))
BEGIN
    -- Seleccionar los datos del aeropuerto antes de eliminarlo
    SELECT  nombre , ciudad_id , numeroAeropuerto FROM Aeropuerto WHERE numeroAeropuerto = numAeropuerto;
    
    -- Eliminar el aeropuerto
    DELETE FROM Aeropuerto WHERE numeroAeropuerto = numAeropuerto;
END $$

DELIMITER ;


-- Procedure para consultar Aeropuerto

DELIMITER $$

DROP PROCEDURE IF EXISTS consultarAeropuerto $$
CREATE PROCEDURE consultarAeropuerto
   (IN numAeropuerto VARCHAR(12))
BEGIN
    -- Seleccionar los datos del aeropuerto 
    SELECT nombre , ciudad_id , numeroAeropuerto FROM Aeropuerto WHERE numeroAeropuerto = numAeropuerto;
END $$

DELIMITER ;

-- Procedure para actualizar Nombre Aeropuerto


DELIMITER $$

DROP PROCEDURE IF EXISTS actualizarNombreAeropuerto $$
CREATE PROCEDURE actualizarNombreAeropuerto
   (IN num VARCHAR(12) , IN nuevoNombre varchar(50))
BEGIN

		UPDATE Aeropuerto
		SET nombre = nuevoNombre
		where numeroAeropuerto = num;
        
		SELECT nombre , ciudad_id , numeroAeropuerto FROM Aeropuerto WHERE numeroAeropuerto = num;
        
END $$

DELIMITER ;


-- Procedure para actualizar Ciudad

DELIMITER $$

DROP PROCEDURE IF EXISTS actualizarCiudad $$
CREATE PROCEDURE actualizarCiudad
   (IN num VARCHAR(12) , IN nuevaCiudadId int)
BEGIN

		UPDATE Aeropuerto
		SET Ciudad_id = nuevaCiudadId
		where numeroAeropuerto = num;
        
        SELECT nombre , ciudad_id , numeroAeropuerto FROM Aeropuerto WHERE numeroAeropuerto = num;
END $$

DELIMITER ;



-- Procedure para actualizar Numero Serial de un Aeropuerto

DELIMITER $$

DROP PROCEDURE IF EXISTS actualizarNumeroSerial $$
CREATE PROCEDURE actualizarNumeroSerial
   (IN num VARCHAR(12) , IN nuevaSerial varchar(50))
BEGIN

		UPDATE Aeropuerto
		SET numeroAeropuerto = nuevaSerial
		where numeroAeropuerto = num;
        
        SELECT nombre , ciudad_id , numeroAeropuerto FROM Aeropuerto WHERE numeroAeropuerto = num;
END $$

DELIMITER ;

-- Procedure para Registrar un Avion
DROP PROCEDURE IF EXISTS InsertarAvion;

delimiter &&

CREATE PROCEDURE InsertarAvion
(
    IN placaInput VARCHAR(30),
    IN capacidadInput INT,
    IN fechaFabricacionInput DATE,
    IN ModeloAvionIdInput INT,
    IN EstadoIdInput INT
)
BEGIN
	INSERT INTO Avion (placa, capacidad, fechaFabricacion, ModeloAvion_id, Estado_id) VALUES
    (placaInput, capacidadInput, fechaFabricacionInput, ModeloAvionIdInput, EstadoIdInput);
    
    SELECT count(placa) AS numRow 
    FROM Avion
    WHERE placa = placaInput;
    
END &&
delimiter ;

-- -----------------------------------------------------------------------------------------------------------------------
-- 											PROCEDIMIENTOS RELACIONADOS CON EL CLIENTE
-- -----------------------------------------------------------------------------------------------------------------------

-- Procedure para Crear Cliente
DELIMITER $$

DROP PROCEDURE IF EXISTS crearCliente $$

CREATE PROCEDURE crearCliente(
    IN p_nombre VARCHAR(100),
    IN p_edad INT,
    IN p_tipoDocumento INT,
    IN p_numeroDocumento VARCHAR(50),
    IN p_usuario VARCHAR(50),
    IN p_contraseña VARCHAR(70)
)
BEGIN
    -- Declarar variables locales si es necesario
    DECLARE cliente_id varchar(50);

    -- Insertar el nuevo cliente en la tabla Cliente
    INSERT INTO Cliente (nombre, edad, TipoDocumento_id, numeroDocumento, usuario, contraseña)
    VALUES (p_nombre, p_edad, p_tipoDocumento, p_numeroDocumento, p_usuario, p_contraseña);

    -- Obtener el ID del cliente insertado
    SET cliente_id = p_numeroDocumento ;

    -- Seleccionar los datos del cliente insertado y devolverlos como resultado (opcional)
    SELECT nombre, edad, TipoDocumento_id, numeroDocumento, usuario, contraseña FROM Cliente WHERE numeroDocumento = cliente_id;

END $$

DELIMITER ;



-- Procedure para consultar cliente

DELIMITER $$

DROP PROCEDURE IF EXISTS consultarCliente $$
CREATE PROCEDURE consultarCliente
   (IN documento VARCHAR(15))
BEGIN
        
        SELECT nombre, edad, TipoDocumento_id, numeroDocumento, usuario, contraseña FROM Cliente WHERE numeroDocumento = documento;
END $$

DELIMITER ;


-- Procedure para Actualizar el Nombre del Cliente
DELIMITER $$

-- Procedure para actualizar cliente

DROP PROCEDURE IF EXISTS actualizarNombreCliente $$
CREATE PROCEDURE actualizarNombreCliente
   (IN documento VARCHAR(15) , IN nuevoNombre varchar(30) )
BEGIN
        
        UPDATE Cliente
		SET nombre = nuevoNombre
		where numeroDocumento = documento;
        
        SELECT nombre, edad, TipoDocumento_id, numeroDocumento, usuario, contraseña FROM Cliente WHERE numeroDocumento = documento;
END $$

DELIMITER ;
-- Procedure para Actualizar la Edad del Cliente

DELIMITER $$

DROP PROCEDURE IF EXISTS actualizarEdadCliente $$
CREATE PROCEDURE actualizarEdadCliente
   (IN documento VARCHAR(15) , IN nuevaEdad varchar(2) )
BEGIN
        
        UPDATE Cliente
		SET edad = nuevaEdad
		where numeroDocumento = documento;
        
        SELECT nombre, edad, TipoDocumento_id, numeroDocumento, usuario, contraseña FROM Cliente WHERE numeroDocumento = documento;
END $$

DELIMITER ;


<<<<<<< HEAD
-- Procedure para actualizar codumento del cliente

=======
-- Procedure para Actualizar Numero de Documento del Cliente
>>>>>>> 7519df5a7633b6a54af4bc175ec72f8ec30eaab3
DELIMITER $$

DROP PROCEDURE IF EXISTS actualizarNumeroDocumentoCliente $$
CREATE PROCEDURE actualizarNumeroDocumentoCliente
   (IN documento VARCHAR(15) , IN nuevoDocumento varchar(15) )
BEGIN
        
        UPDATE Cliente
		SET numeroDocumento = nuevoDocumento
		where numeroDocumento = documento;
        
        SELECT nombre, edad, TipoDocumento_id, numeroDocumento, usuario, contraseña FROM Cliente WHERE numeroDocumento = nuevoDocumento;
END $$

DELIMITER ;


<<<<<<< HEAD
DELIMITER $$

DROP PROCEDURE IF EXISTS actualizarContraseñaCliente $$
CREATE PROCEDURE actualizarContraseñaCliente
   (IN documento VARCHAR(15) , IN nuevaContraseña varchar(70) )
BEGIN
        
        UPDATE Cliente
		SET contraseña = nuevaContraseña
		where numeroDocumento = documento;
        
        SELECT nombre, edad, TipoDocumento_id, numeroDocumento, usuario, contraseña FROM Cliente WHERE numeroDocumento = documento;
END $$

DELIMITER ;


DELIMITER $$

DROP PROCEDURE IF EXISTS actualizarUsuarioCliente $$
CREATE PROCEDURE actualizarUsuarioCliente
   (IN documento VARCHAR(15) , IN nuevoUsuario varchar(25) )
BEGIN
        
        UPDATE Cliente
		SET usuario = nuevoUsuario
		where numeroDocumento = documento;
        
        SELECT nombre, edad, TipoDocumento_id, numeroDocumento, usuario, contraseña FROM Cliente WHERE numeroDocumento = documento;
END $$

DELIMITER ;



DELIMITER $$

DROP PROCEDURE IF EXISTS actualizarTipoDocumentoCliente $$
CREATE PROCEDURE actualizarTipoDocumentoCliente
   (IN documento VARCHAR(15) , IN nuevoTipoDocumento int )
BEGIN
        
        UPDATE Cliente
		SET TipoDocumento_id = nuevoTipoDocumento
		where numeroDocumento = documento;
        
        SELECT nombre, edad, TipoDocumento_id, numeroDocumento, usuario, contraseña FROM Cliente WHERE numeroDocumento = documento;
END $$

DELIMITER ;


-- -----------------------------------------------------------------------------------------------------------------------
-- 											PROCEDIMIENTOS RELACIONADOS CON TARIFA
-- -----------------------------------------------------------------------------------------------------------------------


-- BUSCAR TARIFA 
DELIMITER $$

DROP PROCEDURE IF EXISTS buscarTarifa $$
CREATE PROCEDURE buscarTarifa
    (IN idEntrante INT)
BEGIN
    SELECT id, descripcion, detalle, precioBase, impuesto
    FROM Tarifa
    WHERE id = idEntrante;
END $$

DELIMITER ;


-- CREAR TARIFA 
DELIMITER $$

DROP PROCEDURE IF EXISTS crearTarifa $$
CREATE PROCEDURE crearTarifa
    (IN in_Descripcion VARCHAR(50), 
     IN in_Detalles VARCHAR(100), 
     IN in_precioBase DOUBLE, 
     IN in_impuestos DOUBLE)
BEGIN
	
    declare idTarifa double;
	
    -- Insertar la nueva tarifa
    INSERT INTO Tarifa (descripcion, detalle, precioBase, impuesto) 
    VALUES (in_Descripcion, in_Detalles, in_precioBase, in_impuestos);
    
    
	SELECT LAST_INSERT_ID() into idTarifa;
    
    -- call buscarTarifa (idTarifa);
    
    Select id , descripcion, detalle, precioBase, impuesto from Tarifa where id = idTarifa;
END $$

DELIMITER ;

select * from Tarifa;


-- Actualizar descripcion tarifa 
DELIMITER $$

DROP PROCEDURE IF EXISTS actualizarDescripcionTarifa $$
CREATE PROCEDURE actualizarDescripcionTarifa
    (IN idEntrante int , IN in_descripcion varchar(50))
BEGIN

	update Tarifa 
    set descripcion = in_descripcion
    where id = idEntrante;
	
	Select id , descripcion, detalle, precioBase, impuesto from Tarifa where id = idEntrante;
    
END $$

DELIMITER ;

-- Actualizar detalle tarifa 
DELIMITER $$

DROP PROCEDURE IF EXISTS actualizarDetalleTarifa $$
CREATE PROCEDURE actualizarDetalleTarifa
    (IN idEntrante int , IN in_detalle varchar(50))
BEGIN

	update Tarifa 
    set detalle = in_detalle
    where id = idEntrante;
	
	Select id , descripcion, detalle, precioBase, impuesto from Tarifa where id = idEntrante;
    
END $$

DELIMITER ;


-- Actualizar impuesto tarifa 
DELIMITER $$

DROP PROCEDURE IF EXISTS actualizarImpuestoTarifa $$
CREATE PROCEDURE actualizarImpuestoTarifa
    (IN idEntrante int , IN in_impuesto decimal(10,2))
BEGIN

	update Tarifa 
    set impuesto = in_impuesto
    where id = idEntrante;
	
	Select id , descripcion, detalle, precioBase, impuesto from Tarifa where id = idEntrante;
    
END $$

DELIMITER ;


-- Actualizar precio tarifa 
DELIMITER $$

DROP PROCEDURE IF EXISTS actualizarPrecioTarifa $$
CREATE PROCEDURE actualizarPrecioTarifa
    (IN idEntrante int , IN in_precio decimal(10,2))
BEGIN

	update Tarifa 
    set precioBase = in_precio
    where id = idEntrante;
	
	Select id , descripcion, detalle, precioBase, impuesto from Tarifa where id = idEntrante;
    
END $$

DELIMITER ;



DELIMITER $$

DROP PROCEDURE IF EXISTS eliminarTarifa $$
CREATE PROCEDURE eliminarTarifa
    (IN idEntrante int)
BEGIN

	delete From tarifa where id = idEntrante;
    
END $$

DELIMITER ;

-- -----------------------------------------------------------------------------------------------------------------------
-- 										PROCEDIMIENTOS RELACIONADOS CON REVISION MANTENIMIENTO
-- -----------------------------------------------------------------------------------------------------------------------

DELIMITER $$

DROP PROCEDURE IF EXISTS consultarAvionDaniel $$
CREATE PROCEDURE consultarAvionDaniel
    (IN placaEntrante varchar(10))
BEGIN

	select av.placa as Placa , ma.nombre as Modelo , av.id as AvionId from Avion as av , ModeloAvion as ma
	where av.ModeloAvion_id = ma.id and av.placa = placaEntrante ;
    
	-- select * from Avion as av , ModeloAvion as ma where av.ModeloAvion_id = ma.id ;
    
END $$

DELIMITER ;

-- CREAR REVISION
DELIMITER $$

DROP PROCEDURE IF EXISTS crearRevision $$
CREATE PROCEDURE crearRevision
    ( IN in_fecha date , IN in_Descripcion varchar(50) , in in_idAvion int)
BEGIN

	declare idRevision int;
	
    -- Insertar la nueva tarifa
    INSERT INTO Revision (descripcion, fecha, Avion_id ) 
    VALUES (in_Descripcion, in_fecha , in_idAvion);
    
	SELECT LAST_INSERT_ID() into idRevision;


	select r.id , r.fecha , r.descripcion , Avion_id   from Revision as r , Avion as av where r.id = idRevision  and av.id = r.Avion_id ;
    
    
END $$
DELIMITER ;
-- call crearCliente ("Daniel" , 20 , 5 , "1002049154" , "dan123" , "dan123");
SELECT * FROM Avion;
DELIMITER $$

DROP PROCEDURE IF EXISTS imprimirRevision $$
CREATE PROCEDURE imprimirRevision
    ( IN in_numero int)
BEGIN

	select r.id as IdRevision , r.fecha as Fecha , r.descripcion as Descripcion , av.placa as Placa_Avion 
    from Revision as r , Avion as av where r.id = in_numero and r.Avion_id = av.id ;
    
    
END $$
DELIMITER ;

-- ELIMINAR REVISIÒN

DELIMITER $$

DROP PROCEDURE IF EXISTS eliminarRevision $$
CREATE PROCEDURE eliminarRevision
    ( IN in_numero int)
BEGIN

	delete 
    from Revision 
    where id = in_numero;
    
    
END $$
DELIMITER ;
-- ACTUALZIAR FECHA DE REVISIÒN 
DELIMITER $$

DROP PROCEDURE IF EXISTS actualizarFechaRevision $$
CREATE PROCEDURE actualizarFechaRevision
    ( IN in_numero int , IN in_fecha DATE)
BEGIN

	update Revision 
    set fecha = in_fecha
    where id = in_numero;
    
    select id , descripcion , fecha , Avion_id from Revision where id = in_numero;
END $$
DELIMITER ;

-- actualizar descripcion de revision
DELIMITER $$

DROP PROCEDURE IF EXISTS actualizarDescripcionRevision $$
CREATE PROCEDURE actualizarDescripcionRevision
    ( IN in_numero int , IN in_descripcion varchar(70))
BEGIN

	update Revision 
    set descripcion = in_descripcion
    where id = in_numero;
    
    select id , descripcion , fecha , Avion_id from Revision where id = in_numero;
END $$
DELIMITER ;

-- PROCEDURE PARA CONSULTAR HISTORIAL DE REVISION DE UN AVION
DELIMITER $$

DROP PROCEDURE IF EXISTS consultarHistorialRevision $$
CREATE PROCEDURE consultarHistorialRevision
    ( IN in_placa varchar(10))
BEGIN
	
    Select r.id as IdRevision , r.fecha as fechaMantenimiento , av.placa as Placa , mv.nombre as Modelo , av.fechaFabricacion as fechaFabricacion , av.capacidad as Capacidad ,
    r.descripcion as Descripcion
    from Avion as av , Revision as r , ModeloAvion as mv
    where av.id = r.Avion_id and av.placa = in_placa  and av.ModeloAvion_id = mv.id  ;
    -- "N737800"
    
END $$
DELIMITER ;

-- PROCEDURE PARA ACTUALIZAR EL AVION DE UNA REVISION
DELIMITER $$

DROP PROCEDURE IF EXISTS actualizarAvionRevision $$
CREATE PROCEDURE actualizarAvionRevision
    (IN in_IdRevision int , in in_IdAvion int)
BEGIN

	update Revision 
    set Avion_id = in_IdAvion 
    where id = in_IdRevision;
    
	select id , fecha , Avion_id , descripcion  from Revision where id =in_IdRevision  ;
    
END $$

DELIMITER ;




-- Procedure para obtener los Modelos de Avion ya registrados

DROP PROCEDURE IF EXISTS ObtainModeloAvion;

delimiter &&

CREATE PROCEDURE ObtainModeloAvion()
BEGIN
			SELECT 	m.id AS idmodelo,
						  CONCAT(m.nombre , " - ", f.nombre) AS modelo
						
						
			FROM 		ModeloAvion AS m,
						Fabricante AS f
			
			WHERE		m.Fabricante_id = f.id;
END &&

delimiter ;



-- Procedure para obtener el Estado del Avión
DROP PROCEDURE IF EXISTS ObtainEstadoAvion;

delimiter &&

CREATE PROCEDURE ObtainEstadoAvion()
BEGIN
			SELECT 	id,
						  nombre AS estado
						
						
			FROM 		Estado;
END &&

delimiter ;

-- Procedure para obtener las placas de los Aviones resgistrados
DROP PROCEDURE IF EXISTS ObtainPlacas;

delimiter &&
CREATE PROCEDURE ObtainPlacas()
BEGIN
	SELECT	placa
    FROM	Avion;
END&&
delimiter ;

-- Procedure para eliminar un Avion
DROP PROCEDURE if EXISTS EliminarAvion;

delimiter &&

CREATE PROCEDURE EliminarAvion(IN placaInput VARCHAR(30))
BEGIN
		DECLARE TIME_BEFORE DATETIME;
		DECLARE TIME_AFTER DATETIME;
	
	
	
		SELECT UPDATE_TIME INTO TIME_BEFORE FROM information_schema.tables WHERE table_schema = 'mydb' AND TABLE_NAME = 'Avion';
		
		DELETE FROM Avion WHERE placa = placaInput;
		
		SELECT UPDATE_TIME INTO TIME_AFTER FROM information_schema.tables WHERE table_schema = 'mydb' AND TABLE_NAME = 'Avion';
		
		SELECT TIME_BEFORE, TIME_AFTER;
	
END &&

delimiter ;

-- Procedure para consultar Avión
/*
DROP PROCEDURE if EXISTS ConsultarAvion;

delimiter &&

CREATE PROCEDURE ConsultarAvion(IN placaInput VARCHAR(30))
BEGIN
		SELECT 	a.id,
					a.placa,
					a.capacidad,
					a.fechaFabricacion,
					ma.nombre AS modelo,
					f.nombre AS fabricante,
					e.nombre AS estado
		FROM   	
					Avion AS a,
					ModeloAvion AS  ma,  
					Fabricante AS f,
					Estado AS e
		WHERE 
					a.ModeloAvion_id = ma.id AND 
					ma.Fabricante_id = f.id AND
					ma.id = a.ModeloAvion_id AND 
					a.Estado_id = e.id AND
					a.placa = placaInput;
END &&
	
delimiter ;
*/
-- Procedure para Actualizar Capacidad  de un Avión
DROP PROCEDURE if EXISTS ActualizarCapacidadAvion;

delimiter &&

CREATE PROCEDURE ActualizarCapacidadAvion(IN placaInput VARCHAR(30), IN capacidadInput INT)
BEGIN
		DECLARE TIME_BEFORE DATETIME;
		DECLARE TIME_AFTER DATETIME;
	
	
	
		SELECT UPDATE_TIME INTO TIME_BEFORE FROM information_schema.tables WHERE table_schema = 'mydb' AND TABLE_NAME = 'Avion';
		
		UPDATE 	Avion
		SET  		capacidad =   capacidadInput
		WHERE 	placa = placaInput;
		
		SELECT UPDATE_TIME INTO TIME_AFTER FROM information_schema.tables WHERE table_schema = 'mydb' AND TABLE_NAME = 'Avion';
		
		SELECT TIME_BEFORE, TIME_AFTER;
END &&
	
delimiter ;


-- Procedure para Actualizar Estado  de un Avión
DROP PROCEDURE if EXISTS ActualizarEstadoAvion

delimiter &&

CREATE PROCEDURE ActualizarEstadoAvion(IN placaIpunt VARCHAR(30), IN estadoIdInput INT)
BEGIN
		DECLARE TIME_BEFORE DATETIME;
		DECLARE TIME_AFTER DATETIME;
	
	
	
		SELECT UPDATE_TIME INTO TIME_BEFORE FROM information_schema.tables WHERE table_schema = 'mydb' AND TABLE_NAME = 'Avion';
		
		UPDATE 	Avion
		SET  		Estado_id =   estadoIdInput
		WHERE 	placa = placaInput;
		
		SELECT UPDATE_TIME INTO TIME_AFTER FROM information_schema.tables WHERE table_schema = 'mydb' AND TABLE_NAME = 'Avion';
		
		SELECT TIME_BEFORE, TIME_AFTER;
END &&
	
delimiter ;


-- Procedure para extraer un Avión de la base de datos
DROP PROCEDURE if EXISTS ExtractAirplane;

delimiter &&

CREATE PROCEDURE ExtractAirplane(IN placaInput VARCHAR(30))
BEGIN
		SELECT 	a.id,
            a.capacidad,
            a.fechaFabricacion,
            a.ModeloAvion_id,
            a.Estado_id

		FROM 		Avion AS a

		WHERE 	a.placa = placaInput;
    
END &&

delimiter ;
