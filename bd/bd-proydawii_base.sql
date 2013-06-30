SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE  TABLE IF NOT EXISTS `proydawii`.`categoriaproducto` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `descripcion` (`descripcion` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`cliente` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `apellido` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `direccioncompleta` VARCHAR(100) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `dni` VARCHAR(8) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `email` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `foto` LONGBLOB NULL DEFAULT NULL ,
  `nombre` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `telefono` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `tipocliente_id` INT(11) NULL DEFAULT NULL ,
  `distrito_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `dni` (`dni` ASC) ,
  UNIQUE INDEX `email` (`email` ASC) ,
  INDEX `FK96841DDAF0E33E08` (`tipocliente_id` ASC) ,
  INDEX `fk_cliente_distrito1_idx` (`distrito_id` ASC) ,
  CONSTRAINT `FK96841DDAF0E33E08`
    FOREIGN KEY (`tipocliente_id` )
    REFERENCES `proydawii`.`tipocliente` (`id` ),
  CONSTRAINT `fk_cliente_distrito1`
    FOREIGN KEY (`distrito_id` )
    REFERENCES `proydawii`.`distrito` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`detallepedido` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `cantidad` INT(11) NOT NULL ,
  `preciounitario` DECIMAL(19,2) NOT NULL ,
  `pedido_id` INT(11) NULL DEFAULT NULL ,
  `producto_id` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `FK6EE90F5C6B926FC7` (`producto_id` ASC) ,
  INDEX `FK6EE90F5C3440E4CC` (`pedido_id` ASC) ,
  CONSTRAINT `FK6EE90F5C3440E4CC`
    FOREIGN KEY (`pedido_id` )
    REFERENCES `proydawii`.`pedido` (`id` ),
  CONSTRAINT `FK6EE90F5C6B926FC7`
    FOREIGN KEY (`producto_id` )
    REFERENCES `proydawii`.`productotienda` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`empresa` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `comentarios` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `direccioncompleta` VARCHAR(100) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `email` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `foto` LONGBLOB NULL DEFAULT NULL ,
  `nombre` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `nombrecomercial` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `ruc` VARCHAR(11) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `telefono` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `weburl` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `distrito_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `nombre` (`nombre` ASC) ,
  UNIQUE INDEX `nombrecomercial` (`nombrecomercial` ASC) ,
  UNIQUE INDEX `ruc` (`ruc` ASC) ,
  INDEX `fk_empresa_distrito1_idx` (`distrito_id` ASC) ,
  CONSTRAINT `fk_empresa_distrito1`
    FOREIGN KEY (`distrito_id` )
    REFERENCES `proydawii`.`distrito` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`estadoregistropedido` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(20) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `descripcion` (`descripcion` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`images` (
  `ID` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `GALLERY` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `IMAGE` LONGBLOB NULL DEFAULT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`pedido` (
  `id` INT(11) NOT NULL ,
  `deleted` BIT(1) NOT NULL ,
  `fechahoraentrada` DATETIME NULL DEFAULT NULL ,
  `fechahorasalida` DATETIME NULL DEFAULT NULL ,
  `monto` DECIMAL(19,2) NULL DEFAULT NULL ,
  `observaciones` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `porcentajeigv` DECIMAL(2,0) NULL DEFAULT NULL ,
  `cliente_id` INT(11) NOT NULL ,
  `estadoregistropedido_id` INT(11) NULL DEFAULT NULL ,
  `tienda_id` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `FK8E4203659BAC2888` (`cliente_id` ASC) ,
  INDEX `FK8E420365694BB50C` (`tienda_id` ASC) ,
  INDEX `FK8E4203658BCA0AAC` (`estadoregistropedido_id` ASC) ,
  CONSTRAINT `FK8E420365694BB50C`
    FOREIGN KEY (`tienda_id` )
    REFERENCES `proydawii`.`tienda` (`id` ),
  CONSTRAINT `FK8E4203658BCA0AAC`
    FOREIGN KEY (`estadoregistropedido_id` )
    REFERENCES `proydawii`.`estadoregistropedido` (`id` ),
  CONSTRAINT `FK8E4203659BAC2888`
    FOREIGN KEY (`cliente_id` )
    REFERENCES `proydawii`.`cliente` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`productotienda` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `foto` LONGBLOB NULL DEFAULT NULL ,
  `masFotos` VARCHAR(32) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `observaciones` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `precio` DECIMAL(19,2) NOT NULL ,
  `tienda_id` INT(11) NULL DEFAULT NULL ,
  `productoempresa_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `descripcion` (`descripcion` ASC) ,
  INDEX `FK14D1745B694BB50C` (`tienda_id` ASC) ,
  INDEX `fk_productotienda_productoempresa1_idx` (`productoempresa_id` ASC) ,
  CONSTRAINT `FK14D1745B694BB50C`
    FOREIGN KEY (`tienda_id` )
    REFERENCES `proydawii`.`tienda` (`id` ),
  CONSTRAINT `fk_productotienda_productoempresa1`
    FOREIGN KEY (`productoempresa_id` )
    REFERENCES `proydawii`.`productoempresa` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`repartidor` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `dni` VARCHAR(8) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `nombre` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `apellido` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `direccioncompleta` VARCHAR(100) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `email` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `foto` TINYBLOB NULL DEFAULT NULL ,
  `telefono` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `tienda_id` INT(11) NULL DEFAULT NULL ,
  `distrito_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `dni` (`dni` ASC) ,
  INDEX `FK5627A04694BB50C` (`tienda_id` ASC) ,
  INDEX `fk_repartidor_distrito1_idx` (`distrito_id` ASC) ,
  CONSTRAINT `FK5627A04694BB50C`
    FOREIGN KEY (`tienda_id` )
    REFERENCES `proydawii`.`tienda` (`id` ),
  CONSTRAINT `fk_repartidor_distrito1`
    FOREIGN KEY (`distrito_id` )
    REFERENCES `proydawii`.`distrito` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`tienda` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `direccioncompleta` VARCHAR(100) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `descripcion` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `telefono` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `empresa_id` INT(11) NULL DEFAULT NULL ,
  `distrito_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `descripcion` (`descripcion` ASC) ,
  INDEX `FK954E4AFBFBDAEA28` (`empresa_id` ASC) ,
  INDEX `fk_tienda_distrito1_idx` (`distrito_id` ASC) ,
  CONSTRAINT `FK954E4AFBFBDAEA28`
    FOREIGN KEY (`empresa_id` )
    REFERENCES `proydawii`.`empresa` (`id` ),
  CONSTRAINT `fk_tienda_distrito1`
    FOREIGN KEY (`distrito_id` )
    REFERENCES `proydawii`.`distrito` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`tipocliente` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `descripcion_UNIQUE` (`descripcion` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`productoempresa` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `foto` LONGBLOB NULL DEFAULT NULL ,
  `masFotos` VARCHAR(32) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `precio` DECIMAL(19,2) NOT NULL ,
  `observaciones` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `categoriaproducto_id` INT(11) NOT NULL ,
  `empresa_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `descripcion` (`descripcion` ASC) ,
  INDEX `fk_productoempresa_categoriaproducto1_idx` (`categoriaproducto_id` ASC) ,
  INDEX `fk_productoempresa_empresa1_idx` (`empresa_id` ASC) ,
  CONSTRAINT `fk_productoempresa_categoriaproducto1`
    FOREIGN KEY (`categoriaproducto_id` )
    REFERENCES `proydawii`.`categoriaproducto` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_productoempresa_empresa1`
    FOREIGN KEY (`empresa_id` )
    REFERENCES `proydawii`.`empresa` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`departamento` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(70) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`provincia` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(70) NOT NULL ,
  `departamento_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_provincia_departamento1_idx` (`departamento_id` ASC) ,
  CONSTRAINT `fk_provincia_departamento1`
    FOREIGN KEY (`departamento_id` )
    REFERENCES `proydawii`.`departamento` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`distrito` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(70) NOT NULL ,
  `provincia_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_distrito_provincia1_idx` (`provincia_id` ASC) ,
  CONSTRAINT `fk_distrito_provincia1`
    FOREIGN KEY (`provincia_id` )
    REFERENCES `proydawii`.`provincia` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
