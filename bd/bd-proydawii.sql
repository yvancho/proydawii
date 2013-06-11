--<ScriptOptions statementTerminator=";"/>

CREATE TABLE cliente (
	id INT NOT NULL,
	tipo_id INT,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE tienda (
	id INT NOT NULL,
	descripcion VARCHAR(50) NOT NULL,
	calle VARCHAR(50),
	distrito_id INT,
	telefono VARCHAR(255),
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE distrito (
	id INT NOT NULL,
	descripcion VARCHAR(50),
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE usuario (
	DTYPE VARCHAR(31) NOT NULL,
	id INT NOT NULL,
	apellido VARCHAR(50) NOT NULL,
	calle VARCHAR(50) NOT NULL,
	dni VARCHAR(8) NOT NULL,
	email VARCHAR(255),
	nombre VARCHAR(50) NOT NULL,
	distrito_id INT NOT NULL,
	tienda_id INT,
	tipo_id INT,
	telefono VARCHAR(255),
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE estadoregistropedido (
	id INT NOT NULL,
	descripcion VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE tipocliente (
	id INT NOT NULL,
	descripcion VARCHAR(50),
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE images (
	ID VARCHAR(255) NOT NULL,
	GALLERY VARCHAR(255),
	IMAGE TINYBLOB,
	PRIMARY KEY (ID)
) ENGINE=InnoDB;

CREATE TABLE empresa (
	id INT NOT NULL,
	comentarios VARCHAR(255),
	calle VARCHAR(50),
	email VARCHAR(255),
	nombre VARCHAR(50) NOT NULL,
	nombrecomercial VARCHAR(50) NOT NULL,
	photo LONGBLOB,
	ruc VARCHAR(11) NOT NULL,
	telefono VARCHAR(255),
	weburl VARCHAR(255),
	distrito_id INT,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE repartidor (
	id INT NOT NULL,
	tienda_id INT,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE UNIQUE INDEX descripcion ON tienda (descripcion ASC);

CREATE INDEX FK5627A04694BB50C ON repartidor (tienda_id ASC);

CREATE UNIQUE INDEX dni ON usuario (dni ASC);

CREATE INDEX FK5B4D8B0E694BB50C ON usuario (tienda_id ASC);

CREATE INDEX FK954E4AFBF815B6C ON tienda (distrito_id ASC);

CREATE UNIQUE INDEX email_UNIQUE ON usuario (email ASC);

CREATE UNIQUE INDEX descripcion ON distrito (descripcion ASC);

CREATE INDEX FK5B4D8B0E47E4CC5A ON usuario (tipo_id ASC);

CREATE UNIQUE INDEX nombre ON empresa (nombre ASC);

CREATE INDEX FK5B4D8B0EF815B6C ON usuario (distrito_id ASC);

CREATE INDEX FK26DD869F815B6C ON empresa (distrito_id ASC);

CREATE UNIQUE INDEX ruc ON empresa (ruc ASC);

CREATE UNIQUE INDEX nombrecomercial ON empresa (nombrecomercial ASC);

CREATE INDEX FK96841DDA47E4CC5A ON cliente (tipo_id ASC);

CREATE UNIQUE INDEX descripcion ON estadoregistropedido (descripcion ASC);

