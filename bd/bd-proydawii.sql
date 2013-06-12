SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE  TABLE IF NOT EXISTS `proydawii`.`categoriaproducto` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`cliente` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `apellido` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `calle` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `dni` VARCHAR(8) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `email` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `nombre` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `telefono` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `tipocliente_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `dni` (`dni` ASC) ,
  INDEX `fk_cliente_tipocliente1_idx` (`tipocliente_id` ASC) ,
  CONSTRAINT `fk_cliente_tipocliente1`
    FOREIGN KEY (`tipocliente_id` )
    REFERENCES `proydawii`.`tipocliente` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`distrito` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `direccion_iddireccion` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `descripcion` (`descripcion` ASC) ,
  INDEX `fk_distrito_direccion1_idx` (`direccion_iddireccion` ASC) ,
  CONSTRAINT `fk_distrito_direccion1`
    FOREIGN KEY (`direccion_iddireccion` )
    REFERENCES `proydawii`.`direccion` (`iddireccion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`empresa` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `nombrecomercial` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `ruc` VARCHAR(11) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `Direccion` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `telefono` VARCHAR(15) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `email` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `photo` LONGBLOB NULL DEFAULT NULL ,
  `weburl` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `comentarios` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `nombre` (`nombre` ASC) ,
  UNIQUE INDEX `nombrecomercial` (`nombrecomercial` ASC) ,
  UNIQUE INDEX `ruc` (`ruc` ASC) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`estadoregistropedido` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
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

CREATE  TABLE IF NOT EXISTS `proydawii`.`productotienda` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `precio` DECIMAL(19,2) NOT NULL ,
  `tienda_id` INT(11) NOT NULL ,
  `foto` LONGBLOB NULL DEFAULT NULL ,
  `masFotos` VARCHAR(32) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `observaciones` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `categoriaproducto_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `FK14D1745B694BB50C` (`tienda_id` ASC) ,
  INDEX `fk_productotienda_categoriaproducto1_idx` (`categoriaproducto_id` ASC) ,
  CONSTRAINT `FK14D1745B694BB50C`
    FOREIGN KEY (`tienda_id` )
    REFERENCES `proydawii`.`tienda` (`id` ),
  CONSTRAINT `fk_productotienda_categoriaproducto1`
    FOREIGN KEY (`categoriaproducto_id` )
    REFERENCES `proydawii`.`categoriaproducto` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`repartidor` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `apellido` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `dni` VARCHAR(8) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `email` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `nombre` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `telefono` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL DEFAULT NULL ,
  `tienda_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `dni` (`dni` ASC) ,
  INDEX `FK5627A04694BB50C` (`tienda_id` ASC) ,
  CONSTRAINT `FK5627A04694BB50C`
    FOREIGN KEY (`tienda_id` )
    REFERENCES `proydawii`.`tienda` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`tienda` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `calle` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `telefono` VARCHAR(255) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  `distrito_id` INT(11) NOT NULL ,
  `empresa_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `descripcion` (`descripcion` ASC) ,
  INDEX `FK954E4AFBF815B6C` (`distrito_id` ASC) ,
  INDEX `FK954E4AFBFBDAEA28` (`empresa_id` ASC) ,
  CONSTRAINT `FK954E4AFBFBDAEA28`
    FOREIGN KEY (`empresa_id` )
    REFERENCES `proydawii`.`empresa` (`id` ),
  CONSTRAINT `FK954E4AFBF815B6C`
    FOREIGN KEY (`distrito_id` )
    REFERENCES `proydawii`.`distrito` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`tipocliente` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(50) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `descripcion_UNIQUE` (`descripcion` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`direccion` (
  `iddireccion` INT(11) NOT NULL ,
  `calle` VARCHAR(50) NOT NULL ,
  `numero` VARCHAR(20) NULL DEFAULT NULL ,
  `urbanizacion` VARCHAR(50) NULL DEFAULT NULL ,
  `lote` VARCHAR(20) NULL DEFAULT NULL ,
  `cliente_id` INT(11) NOT NULL ,
  PRIMARY KEY (`iddireccion`) ,
  INDEX `fk_direccion_cliente1_idx` (`cliente_id` ASC) ,
  CONSTRAINT `fk_direccion_cliente1`
    FOREIGN KEY (`cliente_id` )
    REFERENCES `proydawii`.`cliente` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`Pedido` (
  `idpedido` INT(11) NOT NULL ,
  `tienda_id` INT(11) NOT NULL ,
  `fechahoraentrada` DATETIME NOT NULL DEFAULT 'now()' ,
  `fechahorasalida` DATETIME NULL DEFAULT NULL ,
  `estadoregistropedido_id` INT(11) NOT NULL ,
  `observaciones` VARCHAR(225) NULL DEFAULT NULL ,
  PRIMARY KEY (`idpedido`) ,
  INDEX `fk_Pedido_tienda1_idx` (`tienda_id` ASC) ,
  INDEX `fk_Pedido_estadoregistropedido1_idx` (`estadoregistropedido_id` ASC) ,
  CONSTRAINT `fk_Pedido_tienda1`
    FOREIGN KEY (`tienda_id` )
    REFERENCES `proydawii`.`tienda` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_estadoregistropedido1`
    FOREIGN KEY (`estadoregistropedido_id` )
    REFERENCES `proydawii`.`estadoregistropedido` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE  TABLE IF NOT EXISTS `proydawii`.`DetallePedido` (
  `iddetallepedido` INT(11) NOT NULL ,
  `Pedido_idpedido` INT(11) NOT NULL ,
  `cantidad` INT(10) UNSIGNED NOT NULL ,
  `producto` VARCHAR(100) NOT NULL ,
  `preciounitario` DECIMAL(10,2) UNSIGNED NOT NULL DEFAULT 0.00 ,
  PRIMARY KEY (`iddetallepedido`) ,
  INDEX `fk_DetallePedido_Pedido1_idx` (`Pedido_idpedido` ASC) ,
  CONSTRAINT `fk_DetallePedido_Pedido1`
    FOREIGN KEY (`Pedido_idpedido` )
    REFERENCES `proydawii`.`Pedido` (`idpedido` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
