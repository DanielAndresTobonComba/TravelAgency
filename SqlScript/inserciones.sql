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
INSERT INTO `mydb`.`Aeropuerto` (`nombre`, `Ciudad_id`) VALUES
-- Aeropuertos en ciudades de Estados Unidos
('Aeropuerto Internacional John F. Kennedy', 1),
('Aeropuerto Internacional de Los Ángeles', 2),
-- Aeropuertos en ciudades de México
('Aeropuerto Internacional de la Ciudad de México', 3),
('Aeropuerto Internacional de Guadalajara', 4),
-- Aeropuertos en ciudades de Argentina
('Aeropuerto Internacional Ministro Pistarini', 5),
('Aeropuerto Internacional Ingeniero Ambrosio L.V. Taravella', 6),
-- Aeropuertos en ciudades de España
('Aeropuerto Adolfo Suárez Madrid-Barajas', 7),
('Aeropuerto de Barcelona-El Prat', 8),
-- Aeropuertos en ciudades de Japón
('Aeropuerto Internacional de Narita', 9),
('Aeropuerto Internacional de Kansai', 10);


-- Insertar datos en la tabla `PuertaEmbargue`
INSERT INTO `mydb`.`PuertaEmbargue` (`numeroPuerta`, `Aeropuerto_id`) VALUES
-- Puertas de embarque en Aeropuertos de Estados Unidos
('A1', 1),
('A2', 1),
('B1', 2),
('B2', 2),
-- Puertas de embarque en Aeropuertos de México
('C1', 3),
('C2', 3),
('D1', 4),
('D2', 4),
-- Puertas de embarque en Aeropuertos de Argentina
('E1', 5),
('E2', 5),
('F1', 6),
('F2', 6),
-- Puertas de embarque en Aeropuertos de España
('G1', 7),
('G2', 7),
('H1', 8),
('H2', 8),
-- Puertas de embarque en Aeropuertos de Japón
('I1', 9),
('I2', 9),
('J1', 10),
('J2', 10);
