--drop table Rutas
CREATE TABLE Rutas(
idEstacion INT,
estacion VARCHAR(50) NOT NULL,
linea INT NOT NULL,
pInteres VARCHAR(500),
tipoEstacion INT NOT NULL,
status INT NOT NULL
);

SELECT * FROM Rutas
--Tipo de estacion = 0 No cruce, 1 = si cruza
--Estatus = 0 no disponible, 1 = disponible

--LINEA 1
INSERT INTO Rutas VALUES(0,'Mirador',1,'Mirador',0,1);
INSERT INTO Rutas VALUES(1,'Huentitan',1,'',0,1);
INSERT INTO Rutas VALUES(2,'Zoologico',1,'Zoologico, Selva Magica, Planetario Severo Diaz, Galindo',0,1);
INSERT INTO Rutas VALUES(3,'Independencia Norte',1,'',0,1);
INSERT INTO Rutas VALUES(4,'San Patricio',1,'',0,1);
INSERT INTO Rutas VALUES(5,'Igualdad',1,'',0,1);
INSERT INTO Rutas VALUES(6,'Monumental',1,'Estadio Jalisco, Plaza de Toros, Nuevo Progreso',0,1);
INSERT INTO Rutas VALUES(7,'Monte Olivette',1,'',0,1);
INSERT INTO Rutas VALUES(8,'Circunvalacion',1,'',0,1);
INSERT INTO Rutas VALUES(9,'Fac. Medicina',1,'Facultad de Medicina',1,1);
INSERT INTO Rutas VALUES(10,'Juan Alvarez',1,'',0,1);
INSERT INTO Rutas VALUES(11,'Alameda',1,'',0,1);
INSERT INTO Rutas VALUES(12,'San Juan de Dios',1,'Mercado de San Juan de Dios, Teatro Degollado, Catedral Metropolitana, Museo Regional, Plaza de la Liberacion, Hospicio Cabañas, Plaza de los Hombres Ilustres',1,1);
INSERT INTO Rutas VALUES(13,'Bicentenario',1,'',0,1);
INSERT INTO Rutas VALUES(14,'La Paz',1,'',0,1);
INSERT INTO Rutas VALUES(15,'Niños Heroes',1,'',0,1);
INSERT INTO Rutas VALUES(16,'Agua Azul',1,'Parque Agua Azul, Teatro IMSS',0,1);
INSERT INTO Rutas VALUES(17,'Cipres',1,'',0,1);
INSERT INTO Rutas VALUES(18,'Heroe de Nacozari',1,'',0,1);
INSERT INTO Rutas VALUES(19,'Lazaro Cardenas',1,'',0,1);
INSERT INTO Rutas VALUES(20,'El Dean',1,'',1,1);
INSERT INTO Rutas VALUES(21,'Zona Industrial',1,'',0,1);
INSERT INTO Rutas VALUES(22,'Lopez de Legazpi',1,'',0,1);
INSERT INTO Rutas VALUES(23,'Clemente Orozco',1,'',0,1);
INSERT INTO Rutas VALUES(24,'Artes Plasticas',1,'',0,1);
INSERT INTO Rutas VALUES(25,'Escultura',1,'',0,1);
INSERT INTO Rutas VALUES(26,'Fray Angelico',1,'',0,1);

--LINEA 2
INSERT INTO Rutas VALUES(0,'Central Sur',2,'Central de Autobuses de Zapopan',0,1)
INSERT INTO Rutas VALUES(1,'Concentro',2,'',0,1)
INSERT INTO Rutas VALUES(2,'Jardines de la Paz',2,'',0,1)
INSERT INTO Rutas VALUES(3,'Panamericana',2,'Universidad Panamericana',0,1)
INSERT INTO Rutas VALUES(4,'Juan Palomar',2,'',0,1)
INSERT INTO Rutas VALUES(5,'Seminario',2,'',1,1)
INSERT INTO Rutas VALUES(6,'Camara de Comercio',2,'Camara de Comercio',0,1)
INSERT INTO Rutas VALUES(7,'Minerva',2,'Fuente Minerva',0,1)
INSERT INTO Rutas VALUES(8,'Centro Magno',2,'Plaza Comercial Centro Magno',0,1)
INSERT INTO Rutas VALUES(9,'Americas',2,'',1,1)
INSERT INTO Rutas VALUES(10,'Chapultepec',2,'Zona Rosa, Via Recreativa',0,1)
INSERT INTO Rutas VALUES(11,'Paraninfo',2,'Paraninfo UdeG, Rectoria UdeG',0,1)
INSERT INTO Rutas VALUES(12,'Juarez',2,'Parque Revolucion',1,1)
INSERT INTO Rutas VALUES(13,'Plaza Universidad',2,'Zona Comercial Peatonal',0,1)
INSERT INTO Rutas VALUES(14,'San Juan de Dios',2,'Mercado de San Juan de Dios, Teatro Degollado, Catedral Metropolitana, Museo Regional, Plaza de la Liberacion, Hospicio Cabañas, Plaza de los Hombres Ilustres',1,1)
INSERT INTO Rutas VALUES(15,'Belisario Dominguez',2,'',0,1)
INSERT INTO Rutas VALUES(16,'Oblatos 2',2,'',0,1)
INSERT INTO Rutas VALUES(17,'Cristobal de Oñate',2,'',0,1)
INSERT INTO Rutas VALUES(18,'San Andres',2,'',0,1)
INSERT INTO Rutas VALUES(19,'San Jacinto',2,'',0,1)
INSERT INTO Rutas VALUES(20,'La Aurora',2,'',0,1)
INSERT INTO Rutas VALUES(21,'Tetlan',2,'',0,1)

--LINEA 3
INSERT INTO Rutas VALUES(0,'Periferico Norte',3,'Fiestas de Octubre',0,1)
INSERT INTO Rutas VALUES(1,'Dermatologico',3,'Centro Dermatologico',0,1)
INSERT INTO Rutas VALUES(2,'Atemajac',3,'',0,1)
INSERT INTO Rutas VALUES(3,'Division del Norte',3,'',1,1)
INSERT INTO Rutas VALUES(4,'Avila Camacho',3,'',0,1)
INSERT INTO Rutas VALUES(5,'Mezquitan',3,'',1,1)
INSERT INTO Rutas VALUES(6,'Refugio',3,'Templo del Refugio',0,1)
INSERT INTO Rutas VALUES(7,'Juarez',3,'Parque Revolucion',1,1)
INSERT INTO Rutas VALUES(8,'Mexicaltzingo',3,'',0,1)
INSERT INTO Rutas VALUES(9,'Washington',3,'',0,1)
INSERT INTO Rutas VALUES(10,'Santa Filomena',3,'',0,1)
INSERT INTO Rutas VALUES(11,'Unidad Deportiva',3,'Unidad Deportiva Adolfo Lopez Mateos',1,1)
INSERT INTO Rutas VALUES(12,'Urdaneta',3,'',0,1)
INSERT INTO Rutas VALUES(13,'18 de Marzo',3,'',0,1)
INSERT INTO Rutas VALUES(14,'Isla Raza',3,'',0,1)
INSERT INTO Rutas VALUES(15,'Patria Sur',3,'',0,1)
INSERT INTO Rutas VALUES(16,'España',3,'',0,1)
INSERT INTO Rutas VALUES(17,'Tesoro',3,'El Cerro del Tesoro',0,1)
INSERT INTO Rutas VALUES(18,'Periferico Sur',3,'Centro Comercial Plaza Sur',0,1)

--LINEA 4
INSERT INTO Rutas VALUES(0,'Basilica',4,'Basilica de Zapopan',0,1)
INSERT INTO Rutas VALUES(1,'Sanatorio',4,'Sanatorio San Juan de Dios',0,1)
INSERT INTO Rutas VALUES(2,'Colegio Victoria',4,'',0,1)
INSERT INTO Rutas VALUES(3,'Plaza Patria',4,'Centro Comercial Plaza Patria',1,1)
INSERT INTO Rutas VALUES(4,'Country Club',4,'Club de Golf Country Club',0,1)
INSERT INTO Rutas VALUES(5,'Colon',4,'Monumento a Cristobal Colon',1,1)
INSERT INTO Rutas VALUES(6,'Lienzo Charro',4,'Lienzo Charro Hermanos Zemeño',0,1)
INSERT INTO Rutas VALUES(7,'Mezquitan',4,'',1,1)
INSERT INTO Rutas VALUES(8,'Panteon de Belen',4,'Panteon de Belen',0,1)
INSERT INTO Rutas VALUES(9,'Procuraduria',4,'',0,1)
INSERT INTO Rutas VALUES(10,'Fac. de Medicina',4,'Facultad de Medicina',1,1)
INSERT INTO Rutas VALUES(11,'Obrero',4,'',0,1)
INSERT INTO Rutas VALUES(12,'Talpita',4,'Mercado de Artesanías',0,1)
INSERT INTO Rutas VALUES(13,'El Jaraz',4,'',0,1)
INSERT INTO Rutas VALUES(14,'Plutarco Elias Calles',4,'',0,1)
INSERT INTO Rutas VALUES(15,'Haciendas',4,'',0,1)
INSERT INTO Rutas VALUES(16,'Oblatos 1',4,'',0,1)
INSERT INTO Rutas VALUES(17,'Bethel',4,'',0,1)

--LINEA 5
INSERT INTO Rutas VALUES(0,'San Isidro',5,'Centro Comercial Plaza San Isidro',0,1)
INSERT INTO Rutas VALUES(1,'CUCEA',5,'Centro Universitario de Ciencias Economico Administrativas',0,1)
INSERT INTO Rutas VALUES(2,'Parque',5,'Parque Zapopan',0,1)
INSERT INTO Rutas VALUES(3,'Seatle',5,'',0,1)
INSERT INTO Rutas VALUES(4,'Zoquipan',5,'',1,1)
INSERT INTO Rutas VALUES(5,'Plaza Patria',5,'Centro Comercial Plaza Patria',1,1)
INSERT INTO Rutas VALUES(6,'Colomos',5,'Parque los Colomos, Club Atlas Colomos, Centro de Enseñanza Tecnica Industrial CETI, Lienzo Charro la Tapatia',0,1)
INSERT INTO Rutas VALUES(7,'Plaza Pabellon',5,'Centro Comercial Plaza Pabellon, Centro Comercial Andares',0,1)
INSERT INTO Rutas VALUES(8,'San Javier',5,'',0,1)
INSERT INTO Rutas VALUES(9,'3 de Marzo',5,'Estadio de Futbol 3 de Marzo, Universidad Autonoma de Guadalajara',0,1)
INSERT INTO Rutas VALUES(10,'Jardines Universidad',5,'',0,1)
INSERT INTO Rutas VALUES(11,'Ferrocarril',5,'',0,1)
INSERT INTO Rutas VALUES(12,'Seminario',5,'',1,1)
INSERT INTO Rutas VALUES(13,'La Gran Plaza',5,'Centro Comercial La Gran Plaza',0,1)
INSERT INTO Rutas VALUES(14,'San Ignacio',5,'',0,1)
INSERT INTO Rutas VALUES(15,'Estampida',5,'',0,1)
INSERT INTO Rutas VALUES(16,'Chapalita',5,'',0,1)
INSERT INTO Rutas VALUES(17,'Abastos',5,'Mercado de Abastos',1,1)
INSERT INTO Rutas VALUES(18,'Mandarina',5,'',0,1)
INSERT INTO Rutas VALUES(19,'Ruiseñor',5,'',0,1)
INSERT INTO Rutas VALUES(20,'Unidad Deportiva',5,'Unidad deportiva Adolfo Lopez Mateos',1,1)
INSERT INTO Rutas VALUES(21,'Plaza las Torres',5,'Centro Comercial Plaza las Torres',0,1)
INSERT INTO Rutas VALUES(22,'Cristo Rey',5,'Iglesia Cristo Rey, Estacion del Tren Tequila Express',0,1)
INSERT INTO Rutas VALUES(23,'El Dean',5,'',1,1)
INSERT INTO Rutas VALUES(24,'Nogalera',5,'Zona Industrial La Nogalera',0,1)
INSERT INTO Rutas VALUES(25,'Alamo',5,'',0,1)
INSERT INTO Rutas VALUES(26,'Textiles',5,'',0,1)



--LINEA 6
INSERT INTO Rutas VALUES(0,'Tabachines',6,'',0,1)
INSERT INTO Rutas VALUES(1,'Centro Cultural',6,'Centro Cultural Tabachines',0,1)
INSERT INTO Rutas VALUES(2,'Zoquipan',6,'',1,1)
INSERT INTO Rutas VALUES(3,'Patria',6,'',0,1)
INSERT INTO Rutas VALUES(4,'Division del Norte',6,'',1,1)
INSERT INTO Rutas VALUES(5,'Lomas',6,'',0,1)
INSERT INTO Rutas VALUES(6,'Plan de San Luis',6,'',0,1)
INSERT INTO Rutas VALUES(7,'Colon',6,'Monumento a Cristobal Colon',1,1)
INSERT INTO Rutas VALUES(8,'Jose Maria Vigil',6,'',0,1)
INSERT INTO Rutas VALUES(9,'Zarco',6,'',0,1)
INSERT INTO Rutas VALUES(10,'Avenida Mexico',6,'',0,1)
INSERT INTO Rutas VALUES(11,'Ladron de Guevara',6,'',0,1)
INSERT INTO Rutas VALUES(12,'Americas',6,'',1,1)
INSERT INTO Rutas VALUES(13,'Lafayette',6,'',0,1)
INSERT INTO Rutas VALUES(14,'Monumento',6,'',0,1)
INSERT INTO Rutas VALUES(15,'Santa Eduwiges',6,'',0,1)
INSERT INTO Rutas VALUES(16,'Dia',6,'',0,1)
INSERT INTO Rutas VALUES(17,'Abastos',6,'Mercado de Abastos',1,1)
INSERT INTO Rutas VALUES(18,'Parque de las Estrellas',6,'',0,1)
INSERT INTO Rutas VALUES(19,'Expo',6,'Centro de Exposiciones',0,1)
INSERT INTO Rutas VALUES(20,'Plaza del Sol',6,'Centro Comercial Plaza del Sol',0,1)

SELECT * FROM Rutas where linea = 2
