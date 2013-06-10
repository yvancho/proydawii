--<ScriptOptions statementTerminator=";"/>

CREATE TABLE cliente (
	id INT NOT NULL,
	dni VARCHAR(8) NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	apellido VARCHAR(50) NOT NULL,
	tipo_id INT NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE tipocliente (
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

CREATE INDEX FK96841DDA47E4CC5A ON cliente (tipo_id ASC);

