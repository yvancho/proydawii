--<ScriptOptions statementTerminator=";"/>

CREATE TABLE estadoregistropedido (
	id INT NOT NULL,
	descripcion VARCHAR(255),
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE tienda (
	id INT NOT NULL,
	calle VARCHAR(255),
	descripcion VARCHAR(255),
	telefono VARCHAR(255),
	distrito_id INT,
	empresa_id INT,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE tipocliente (
	id INT NOT NULL,
	descripcion VARCHAR(255),
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE empresa (
	id INT NOT NULL,
	comentarios VARCHAR(255),
	direccion VARCHAR(255),
	email VARCHAR(255),
	foto TINYBLOB,
	nombre VARCHAR(255),
	nombrecomercial VARCHAR(255),
	ruc VARCHAR(11),
	telefono VARCHAR(255),
	weburl VARCHAR(255),
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE distrito (
	id INT NOT NULL,
	descripcion VARCHAR(255),
	direccion_id INT,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE direccion (
	id INT NOT NULL,
	calle VARCHAR(255),
	lote VARCHAR(255),
	numero VARCHAR(255),
	urbanizacion VARCHAR(255),
	cliente_id INT,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE detallepedido (
	id INT NOT NULL,
	cantidad INT NOT NULL,
	preciounitario DECIMAL(10 , 2),
	producto VARCHAR(255),
	pedido_id INT,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE categoriaproducto (
	id INT NOT NULL,
	descripcion VARCHAR(255),
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

CREATE TABLE cliente (
	id INT NOT NULL,
	apellido VARCHAR(255),
	calle VARCHAR(255),
	dni VARCHAR(255),
	email VARCHAR(255),
	nombre VARCHAR(255),
	telefono VARCHAR(255),
	tipocliente_id INT,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE images (
	ID VARCHAR(255) NOT NULL,
	GALLERY VARCHAR(255),
	IMAGE TINYBLOB,
	PRIMARY KEY (ID)
) ENGINE=InnoDB;

CREATE TABLE repartidor (
	id INT NOT NULL,
	apellido VARCHAR(255),
	dni VARCHAR(8),
	email VARCHAR(255),
	nombre VARCHAR(255),
	telefono VARCHAR(255),
	tienda_id INT,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE productotienda (
	id INT NOT NULL,
	descripcion VARCHAR(255),
	foto TINYBLOB,
	masFotos VARCHAR(255),
	observaciones VARCHAR(255),
	precio DECIMAL(10 , 2),
	categoriaproducto_id INT,
	tienda_id INT,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE INDEX FK954E4AFBFBDAEA28 ON tienda (empresa_id ASC);

CREATE INDEX FK3E0A6D109BAC2888 ON direccion (cliente_id ASC);

CREATE INDEX FK5627A04694BB50C ON repartidor (tienda_id ASC);

CREATE INDEX FK151399B886B34948 ON distrito (direccion_id ASC);

CREATE INDEX FK96841DDAF0E33E08 ON cliente (tipocliente_id ASC);

CREATE UNIQUE INDEX dni ON repartidor (dni ASC);

CREATE INDEX FK954E4AFBF815B6C ON tienda (distrito_id ASC);

CREATE INDEX FK14D1745B694BB50C ON productotienda (tienda_id ASC);

CREATE INDEX FK8E420365694BB50C ON pedido (tienda_id ASC);

CREATE INDEX FK8E4203658BCA0AAC ON pedido (estadoregistropedido_id ASC);

CREATE INDEX FK6EE90F5C3440E4CC ON detallepedido (pedido_id ASC);

CREATE INDEX FK14D1745BB6599C68 ON productotienda (categoriaproducto_id ASC);

ALTER TABLE pedido ADD CONSTRAINT FK8E4203658BCA0AAC FOREIGN KEY (estadoregistropedido_id)
	REFERENCES estadoregistropedido (id);

ALTER TABLE pedido ADD CONSTRAINT FK8E420365694BB50C FOREIGN KEY (tienda_id)
	REFERENCES tienda (id);

