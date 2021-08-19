DROP TABLE IF EXISTS articulos;
DROP TABLE IF EXISTS fabricantes;

CREATE TABLE fabricantes (
  CODIGO int auto_increment,
  NOMBRE varchar(255) NOT NULL,
  PRIMARY KEY (CODIGO)
);

CREATE TABLE articulos (
  CODIGO int auto_increment,
  NOMBRE varchar(255) NOT NULL,
  PRECIO decimal(10,0) NOT NULL,
  FABRICANTE int NOT NULL,
  PRIMARY KEY (CODIGO),
  FOREIGN KEY (FABRICANTE) REFERENCES fabricantes (CODIGO)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

INSERT INTO fabricantes (NOMBRE) VALUES 
('Sony'),
('Creative Labs'),
('Hewlett-Packard'),
('Iomega'),
('Fujitsu'),
('Winchester');

INSERT INTO articulos (NOMBRE, PRECIO, FABRICANTE) VALUES 
('Hard drive',240,5),
('Memory',120,6),
('ZIP drive',150,4),
('Floppy disk',5,6),
('Monitor',240,1),
('DVD drive',180,2),
('CD drive',90,2),
('Printer',270,3),
('Toner cartridge',66,3),
('DVD burner',180,2);
