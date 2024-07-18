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
select * from Aeropuerto;

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
  `descripcion` TEXT(200) NOT NULL,
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
  `descripcion` VARCHAR(20) NULL,
  `detalles` VARCHAR(45) NULL,
  `precioBase` DECIMAL NULL,
  `impuestos` DECIMAL NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL,
  `edad` INT NULL,
  `TipoDocumento_id` INT NULL,
  `usuario` VARCHAR(25) NULL unique,
  `contraseña` VARCHAR(70) NULL,
  `numeroDocumento` varchar(15) not null,
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
    ('Luisa Fernández', 22, 1, 'luisaf22', 'pqr678', '87654321'),
    ('Elena Torres', 33, 2, 'elenat33', 'stu901', '76543218'),
    ('Javier García', 45, 3, 'javierg45', 'vwx234', '67812345'),
    ('Sofía Rodríguez', 26, 4, 'sofiar26', 'yz567', '54321678'),
    ('Martín Sánchez', 31, 5, 'martins31', 'abc890', '32187654');

-- Insertar en la tabla Rol
INSERT INTO Rol (nombre)
VALUES ("Administrador");

INSERT INTO Rol (nombre)
VALUES ("Agente de ventas");

INSERT INTO Rol (nombre)
VALUES ("Tecnico de mantenimiento");


-- Insertar en la tabla Aerolinea
INSERT INTO Aerolinea  (nombre) VALUES 
("Ninguno"); 


INSERT INTO Aerolinea  (nombre) VALUES 
("Copa Airlines");

INSERT INTO Aerolinea  (nombre) VALUES 
("Avianca");

INSERT INTO Aerolinea  (nombre) VALUES 
("Aeromexico");

INSERT INTO Aerolinea  (nombre) VALUES 
("Azul");

INSERT INTO Aerolinea  (nombre) VALUES 
("Aerolineas Argentina");     

INSERT INTO Aerolinea  (nombre) VALUES 
("LATAM Airlines");



-- Insertar datos en la tabla Empleado
INSERT INTO Empleado (name, fechaIngreso, Ciudad_id,  Aerolinia_id, TripulacionRol_id, TipoDocumento_id, usuario, contraseña)
VALUES ("Carlos Jhoan Aguilar Galvis", "2020-01-01", 5, 1, 1, 1, "admin123", "240BE518FABD2724DDB6F04EEB1DA5967448D7E831C08C8FA822809F74C720A9");


-- Insertar datos en la tabla Estado
INSERT INTO Estado(nombre) VALUES
('Activo'), ('En reparacion');


-- Insertar datos en la tabla Fabricante
INSERT INTO Fabricante(nombre) VALUES
('Bombardier'), ('ACJ'), ('Airbus'), ('Beechcraft'), ('Boeing');


-- Insertar datos en la tabla ModeloAvion
INSERT INTO ModeloAvion(nombre, Fabricante_id)
VALUES ('CHALLENGER 350', 1), ('AIRBUS 320', 3);





-- ----------------------------------------------------------------------------- PROCEDURES ---------------------------------------------------------------------

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


-- Procedure para Crear Cliente

DELIMITER $$

DROP PROCEDURE IF EXISTS crearCliente $$

CREATE PROCEDURE crearCliente(
    IN p_nombre VARCHAR(100),
    IN p_edad INT,
    IN p_tipoDocumento INT,
    IN p_numeroDocumento VARCHAR(50),
    IN p_usuario VARCHAR(50),
    IN p_contraseña VARCHAR(50)
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


