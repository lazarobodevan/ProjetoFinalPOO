-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema projetofinalpoo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema projetofinalpoo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `projetofinalpoo` DEFAULT CHARACTER SET utf8 ;
USE `projetofinalpoo` ;

-- -----------------------------------------------------
-- Table `projetofinalpoo`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetofinalpoo`.`Cliente` (
  `idCliente` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` CHAR(14) NOT NULL,
  `dtNasc` DATE NOT NULL,
  `telefone` CHAR(14) NOT NULL,
  `sexo` CHAR NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetofinalpoo`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetofinalpoo`.`Produto` (
  `idProduto` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `preco` DOUBLE NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  `qtdEstoque` INT NOT NULL,
  PRIMARY KEY (`idProduto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetofinalpoo`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetofinalpoo`.`Funcionario` (
  `idFuncionario` INT NOT NULL,
  `matricula` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` CHAR(14) NOT NULL,
  `telefone` CHAR(14) NOT NULL,
  `dtNasc` DATE NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `salario` DOUBLE NOT NULL,
  `dtContratado` DATE NOT NULL,
  `situacao` VARCHAR(45) NOT NULL,
  `cargo` VARCHAR(45) NOT NULL,
  `sexo` CHAR NOT NULL,
  `foto` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  UNIQUE INDEX `matricula_UNIQUE` (`matricula` ASC) VISIBLE,
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetofinalpoo`.`Venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetofinalpoo`.`Venda` (
  `idVenda` INT NOT NULL,
  `precoTotal` DOUBLE NOT NULL,
  `data` DATE NOT NULL,
  `idCliente` INT NOT NULL,
  `idFuncionario` INT NOT NULL,
  PRIMARY KEY (`idVenda`),
  INDEX `fk_Venda_Cliente1_idx` (`idCliente` ASC) VISIBLE,
  INDEX `fk_Venda_Funcionario1_idx` (`idFuncionario` ASC) VISIBLE,
  CONSTRAINT `fk_Venda_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `projetofinalpoo`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_Funcionario1`
    FOREIGN KEY (`idFuncionario`)
    REFERENCES `projetofinalpoo`.`Funcionario` (`idFuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetofinalpoo`.`Produto_has_Venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetofinalpoo`.`Produto_has_Venda` (
  `idProduto` INT NOT NULL,
  `idVenda` INT NOT NULL,
  `preco_na_compra` DOUBLE NOT NULL,
  `qtd_produto` INT NOT NULL,
  PRIMARY KEY (`idProduto`, `idVenda`),
  INDEX `fk_Produto_has_Venda_Venda1_idx` (`idVenda` ASC) VISIBLE,
  INDEX `fk_Produto_has_Venda_Produto_idx` (`idProduto` ASC) VISIBLE,
  CONSTRAINT `fk_Produto_has_Venda_Produto`
    FOREIGN KEY (`idProduto`)
    REFERENCES `projetofinalpoo`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_has_Venda_Venda1`
    FOREIGN KEY (`idVenda`)
    REFERENCES `projetofinalpoo`.`Venda` (`idVenda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetofinalpoo`.`AcessoSistema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetofinalpoo`.`AcessoSistema` (
  `idAcessoSistema` INT NOT NULL,
  `dtAcesso` DATETIME NOT NULL,
  `hrAcesso` TIME NOT NULL,
  `hrSaida` TIME NOT NULL,
  `idFuncionario` INT NOT NULL,
  PRIMARY KEY (`idAcessoSistema`),
  INDEX `fk_AcessoSistema_Funcionario1_idx` (`idFuncionario` ASC) VISIBLE,
  CONSTRAINT `fk_AcessoSistema_Funcionario1`
    FOREIGN KEY (`idFuncionario`)
    REFERENCES `projetofinalpoo`.`Funcionario` (`idFuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
