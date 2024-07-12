DROP DATABASE IF EXISTS TravelAgency;
CREATE DATABASE TravelAgency;

USE TravelAgency;

CREATE TABLE Rol (
  id INT PRIMARY KEY,
  nombre VARCHAR(45)
);

CREATE TABLE Aerolinia (
  id INT PRIMARY KEY,
  nombre VARCHAR(30)
);

CREATE TABLE TipoDocumento (
  id INT PRIMARY KEY,
  nombre VARCHAR(45)
);

CREATE TABLE EmpleadoVueloConexion (
  Empleado_id INT,
  VueloConexion_id VARCHAR(15),
  PRIMARY KEY (Empleado_id, VueloConexion_id),
  FOREIGN KEY (Empleado_id) REFERENCES Empleado(id),
  FOREIGN KEY (VueloConexion_id) REFERENCES VueloConexion(id)
);

CREATE TABLE Empleado (
  id INT PRIMARY KEY,
  nombre VARCHAR(45),
  apellido VARCHAR(45),
  TipoDocumento_id INT,
  numeroDocumento VARCHAR(15),
  Rol_id INT,
  Aerolinia_id INT,
  fechaNacimiento DATE,
  FOREIGN KEY (TipoDocumento_id) REFERENCES TipoDocumento(id),
  FOREIGN KEY (Rol_id) REFERENCES Rol(id),
  FOREIGN KEY (Aerolinia_id) REFERENCES Aerolinia(id)
);

CREATE TABLE VueloConexion (
  id VARCHAR(15) PRIMARY KEY,
  fechaHoraSalida TIMESTAMP,
  fechaHoraLlegada TIMESTAMP,
  AeropuertoSalida VARCHAR(30),
  AeropuertoLlegada VARCHAR(30),
  Aerolinia_id INT,
  PRIMARY KEY (id),
  FOREIGN KEY (Aerolinia_id) REFERENCES Aerolinia(id)
);

CREATE TABLE Pasajero (
  id INT PRIMARY KEY,
  nombre VARCHAR(45),
  apellido VARCHAR(45),
  TipoDocumento_id INT,
  numeroDocumento VARCHAR(15),
  Aerolinia_id INT,
  fechaNacimiento DATE,
  FOREIGN KEY (TipoDocumento_id) REFERENCES TipoDocumento(id),
  FOREIGN KEY (Aerolinia_id) REFERENCES Aerolinia(id)
);

CREATE TABLE Vuelo (
  id INT PRIMARY KEY,
  numeroVuelo INT,
  fechaHoraSalida TIMESTAMP,
  fechaHoraLlegada TIMESTAMP,
  AeropuertoSalida VARCHAR(30),
  AeropuertoLlegada VARCHAR(30),
  Aerolinia_id INT,
  PRIMARY KEY (id),
  FOREIGN KEY (Aerolinia_id) REFERENCES Aerolinia(id)
);

CREATE TABLE Reserva (
  id INT PRIMARY KEY,
  fechaHoraReserva TIMESTAMP,
  Empleado_id INT,
  Pasajero_id INT,
  Vuelo_id INT,
  PRIMARY KEY (id),
  FOREIGN KEY (Empleado_id) REFERENCES Empleado(id),
  FOREIGN KEY (Pasajero_id) REFERENCES Pasajero(id),
  FOREIGN KEY (Vuelo_id) REFERENCES Vuelo(id)
);

CREATE TABLE ModeloAvion (
  id INT PRIMARY KEY,
  nombre VARCHAR(30),
  Fabricante_id INT,
  FOREIGN KEY (Fabricante_id) REFERENCES Fabricante(id)
);

CREATE TABLE Avion (
  id INT PRIMARY KEY,
  placa VARCHAR(30),
  capacidad VARCHAR(45),
  fechaFabricacion VARCHAR(45),
  ModeloAvion_id INT,
  Estado_id INT,
  FOREIGN KEY (ModeloAvion_id) REFERENCES ModeloAvion(id),
  FOREIGN KEY (Estado_id) REFERENCES Estado(id)
);

CREATE TABLE Estado (
  id INT PRIMARY KEY,
  nombre VARCHAR(30)
);

CREATE TABLE Fabricante (
  id INT PRIMARY KEY,
  nombre VARCHAR(40)
);

CREATE TABLE PuertaEmbarque (
  id VARCHAR(5) PRIMARY KEY,
  numeroPuerta VARCHAR(10),
  Aeropuerto_id INT,
  FOREIGN KEY (Aeropuerto_id) REFERENCES Aeropuerto(id)
);

CREATE TABLE Aeropuerto (
  id VARCHAR(5) PRIMARY KEY,
  nombre VARCHAR(50),
  Ciudad_id VARCHAR(5),
  FOREIGN KEY (Ciudad_id) REFERENCES Ciudad(id)
);

CREATE TABLE Ciudad (
  id VARCHAR(5) PRIMARY KEY,
  nombre VARCHAR(45),
  Pais_id INT,
  FOREIGN KEY (Pais_id) REFERENCES Pais(id)
);

CREATE TABLE Pais (
  id VARCHAR(5) PRIMARY KEY,
  nombre VARCHAR(30)
);

CREATE TABLE Tarifa (
  id INT PRIMARY KEY,
  descripcion VARCHAR(20),
  detalles VARCHAR(45),
  precioBase DOUBLE(7,3)
);

CREATE TABLE Viaje (
  id VARCHAR(15) PRIMARY KEY,
  dia DATE,
  precio DOUBLE,
  idAeropuertoOrigen VARCHAR(5),
  idAeropuertoDestino VARCHAR(5),
  impuesto DOUBLE,
  FOREIGN KEY (idAeropuertoOrigen) REFERENCES Aeropuerto(id),
  FOREIGN KEY (idAeropuertoDestino) REFERENCES Aeropuerto(id)
);

CREATE TABLEReservacion (
  id INT PRIMARY KEY,
  fecha DATE,
  Viaje_id VARCHAR(15),
  Tarifa_id INT,
  Cliente_id VARCHAR(20),
  MetodoPago_id INT,
  estadoPago TINYINT,
  FOREIGN KEY (Viaje_id) REFERENCES Viaje(id),
  FOREIGN KEY (Tarifa_id) REFERENCES Tarifa(id),
  FOREIGN KEY (Cliente_id) REFERENCES Cliente(id),
  FOREIGN KEY (MetodoPago_id) REFERENCES MetodoPago(id)
);

CREATE TABLE MetodoPago (
  id INT PRIMARY KEY,
  nombre VARCHAR(45)
);

CREATE TABLE Cliente (
  id VARCHAR(20) PRIMARY KEY,
  nombre VARCHAR(30),
  edad INT,
  TipoDocumento_id INT,
  FOREIGN KEY (TipoDocumento_id) REFERENCES TipoDocumento(id)
);

CREATE TABLE Revision (
  id INT PRIMARY KEY,
  fecha DATE,
  Avion_id INT,
  descripcion TEXT(200),
  FOREIGN KEY (Avion_id) REFERENCES Avion(id)
);

CREATE TABLE RevisionEmpleado (
  Revision_id INT,
  Empleado_id INT,
  PRIMARY KEY (Revision_id, Empleado_id),
  FOREIGN KEY (Revision_id) REFERENCES Revision(id),
  FOREIGN KEY (Empleado_id) REFERENCES Empleado(id)
);