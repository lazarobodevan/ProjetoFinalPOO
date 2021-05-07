-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ProjetoFinalPOO
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ProjetoFinalPOO
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ProjetoFinalPOO` DEFAULT CHARACTER SET utf8 ;
USE `ProjetoFinalPOO` ;

-- -----------------------------------------------------
-- Table `ProjetoFinalPOO`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjetoFinalPOO`.`Cliente` (
  `idCliente` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` CHAR(11) NOT NULL,
  `dtNasc` CHAR(10) NOT NULL,
  `telefone` CHAR(13) NULL,
  PRIMARY KEY (`idCliente`, `cpf`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjetoFinalPOO`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjetoFinalPOO`.`Produto` (
  `idProduto` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `preco` DOUBLE NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  `qtdEstoque` INT NOT NULL,
  PRIMARY KEY (`idProduto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjetoFinalPOO`.`Venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjetoFinalPOO`.`Venda` (
  `idVenda` INT NOT NULL,
  `precoTotal` DOUBLE NOT NULL,
  `data` DATE NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  `Cliente_cpf` CHAR(11) NOT NULL,
  PRIMARY KEY (`idVenda`),
  INDEX `fk_Venda_Cliente1_idx` (`Cliente_idCliente` ASC, `Cliente_cpf` ASC) VISIBLE,
  CONSTRAINT `fk_Venda_Cliente1`
    FOREIGN KEY (`Cliente_idCliente` , `Cliente_cpf`)
    REFERENCES `ProjetoFinalPOO`.`Cliente` (`idCliente` , `cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjetoFinalPOO`.`Produto_has_Venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjetoFinalPOO`.`Produto_has_Venda` (
  `Produto_idProduto` INT NOT NULL,
  `Venda_idVenda` INT NOT NULL,
  PRIMARY KEY (`Produto_idProduto`, `Venda_idVenda`),
  INDEX `fk_Produto_has_Venda_Venda1_idx` (`Venda_idVenda` ASC) VISIBLE,
  INDEX `fk_Produto_has_Venda_Produto_idx` (`Produto_idProduto` ASC) VISIBLE,
  CONSTRAINT `fk_Produto_has_Venda_Produto`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES `ProjetoFinalPOO`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_has_Venda_Venda1`
    FOREIGN KEY (`Venda_idVenda`)
    REFERENCES `ProjetoFinalPOO`.`Venda` (`idVenda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
