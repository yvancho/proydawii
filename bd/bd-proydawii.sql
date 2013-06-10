--<ScriptOptions statementTerminator=";"/>

CREATE TABLE tipocliente (
	id INT NOT NULL,
	descripcion VARCHAR(50),
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE distrito (
	id INT NOT NULL,
	descripcion VARCHAR(50),
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE usuario (
	id INT NOT NULL,
	apellido VARCHAR(50) NOT NULL,
	calle VARCHAR(50) NOT NULL,
	dni VARCHAR(8) NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	distrito_id INT NOT NULL,
	DTYPE VARCHAR(31) NOT NULL,
	tienda_id INT NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE tienda (
	id INT NOT NULL,
	descripcion VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE images (
	ID VARCHAR(255) NOT NULL,
	GALLERY VARCHAR(255),
	IMAGE TINYBLOB,
	PRIMARY KEY (ID)
) ENGINE=InnoDB;

CREATE TABLE estadoregistropedido (
	id INT NOT NULL,
	descripcion VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE UNIQUE INDEX descripcion ON distrito (descripcion ASC);

CREATE UNIQUE INDEX dni ON usuario (dni ASC);

CREATE INDEX FK5B4D8B0EF815B6C ON usuario (distrito_id ASC);

CREATE INDEX FK5B4D8B0E694BB50C ON usuario (tienda_id ASC);

CREATE UNIQUE INDEX descripcion ON estadoregistropedido (descripcion ASC);

CREATE UNIQUE INDEX descripcion ON tienda (descripcion ASC);

