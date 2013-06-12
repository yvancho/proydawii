--<ScriptOptions statementTerminator=";"/>

CREATE TABLE detallepedido (
	id INT NOT NULL,
	cantidad INT NOT NULL,
	preciounitario DECIMAL(10 , 2),
	producto VARCHAR(255),
	pedido_id INT,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE tipocliente (
	id INT NOT NULL,
	descripcion VARCHAR(255),
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE productotienda (
	id INT NOT NULL,
	descripcion VARCHAR(50) NOT NULL,
	foto LONGBLOB,
	masFotos VARCHAR(255),
	observaciones VARCHAR(255),
	precio DECIMAL UNSIGNED(10 , 2),
	categoriaproducto_id INT,
	tienda_id INT,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE estadoregistropedido (
	id INT NOT NULL,
	descripcion VARCHAR(20) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE categoriaproducto (
	id INT NOT NULL,
	descripcion VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE distrito (
	id INT NOT NULL,
	descripcion VARCHAR(255),
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE repartidor (
	id INT NOT NULL,
	apellido VARCHAR(255) NOT NULL,
	dni VARCHAR(8) NOT NULL,
	email VARCHAR(255),
	nombre VARCHAR(255) NOT NULL,
	telefono VARCHAR(255),
	foto LONGBLOB,
	tienda_id INT,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE pedido (
	id INT NOT NULL,
	fechahoraentrada DATETIME,
	fechahorasalida DATETIME,
	observaciones VARCHAR(255),
	estadoregistropedido_id INT,
	tienda_id INT,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE tienda (
	id INT NOT NULL,
	calle VARCHAR(50) NOT NULL,
	descripcion VARCHAR(50) NOT NULL,
	telefono VARCHAR(50) NOT NULL,
	distrito_id INT,
	empresa_id INT,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE images (
	ID VARCHAR(255) NOT NULL,
	GALLERY VARCHAR(255),
	IMAGE LONGBLOB,
	PRIMARY KEY (ID)
) ENGINE=InnoDB;

CREATE TABLE cliente (
	id INT NOT NULL,
	apellido VARCHAR(255) NOT NULL,
	calle VARCHAR(255),
	lote VARCHAR(255),
	numero VARCHAR(255),
	urbanizacion VARCHAR(255),
	dni VARCHAR(8) NOT NULL,
	email VARCHAR(50) NOT NULL,
	foto LONGBLOB,
	nombre VARCHAR(50) NOT NULL,
	telefono VARCHAR(15) NOT NULL,
	distrito_id INT,
	tipocliente_id INT,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE empresa (
	id INT NOT NULL,
	comentarios VARCHAR(255),
	direccion VARCHAR(255),
	email VARCHAR(255),
	foto LONGBLOB,
	nombre VARCHAR(50) NOT NULL,
	nombrecomercial VARCHAR(50) NOT NULL,
	ruc VARCHAR(11) NOT NULL,
	telefono VARCHAR(255),
	weburl VARCHAR(255),
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE UNIQUE INDEX nombre ON empresa (nombre ASC);

CREATE INDEX FK954E4AFBFBDAEA28 ON tienda (empresa_id ASC);

CREATE UNIQUE INDEX descripcion ON estadoregistropedido (descripcion ASC);

CREATE INDEX FK954E4AFBF815B6C ON tienda (distrito_id ASC);

CREATE INDEX FK14D1745BB6599C68 ON productotienda (categoriaproducto_id ASC);

CREATE UNIQUE INDEX email ON cliente (email ASC);

CREATE UNIQUE INDEX dni ON repartidor (dni ASC);

CREATE UNIQUE INDEX email_UNIQUE ON repartidor (email ASC);

CREATE INDEX FK8E4203658BCA0AAC ON pedido (estadoregistropedido_id ASC);

CREATE UNIQUE INDEX ruc ON empresa (ruc ASC);

CREATE UNIQUE INDEX dni ON cliente (dni ASC);

CREATE INDEX FK8E420365694BB50C ON pedido (tienda_id ASC);

CREATE INDEX FK14D1745B694BB50C ON productotienda (tienda_id ASC);

CREATE UNIQUE INDEX descripcion ON productotienda (descripcion ASC);

CREATE UNIQUE INDEX email_UNIQUE ON empresa (email ASC);

CREATE UNIQUE INDEX nombrecomercial ON empresa (nombrecomercial ASC);

CREATE INDEX FK5627A04694BB50C ON repartidor (tienda_id ASC);

CREATE INDEX FK96841DDAF815B6C ON cliente (distrito_id ASC);

CREATE UNIQUE INDEX descripcion ON categoriaproducto (descripcion ASC);

CREATE INDEX FK6EE90F5C3440E4CC ON detallepedido (pedido_id ASC);

CREATE INDEX FK96841DDAF0E33E08 ON cliente (tipocliente_id ASC);

CREATE UNIQUE INDEX descripcion ON tienda (descripcion ASC);

