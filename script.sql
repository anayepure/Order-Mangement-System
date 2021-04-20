-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ordermanagement
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ordermanagement
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ordermanagement` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ordermanagement` ;

-- -----------------------------------------------------
-- Table `ordermanagement`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordermanagement`.`customer` (
  `customer_ID` INT NOT NULL,
  `firstname` VARCHAR(30) NOT NULL,
  `lastname` VARCHAR(30) NOT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `card_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`customer_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ordermanagement`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordermanagement`.`product` (
  `product_ID` INT NOT NULL,
  `product_name` VARCHAR(30) NOT NULL,
  `price` INT NULL DEFAULT NULL,
  `quantity` INT NULL DEFAULT NULL,
  PRIMARY KEY (`product_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ordermanagement`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordermanagement`.`orders` (
  `order_ID` INT NOT NULL,
  `customer_ID` INT NULL DEFAULT NULL,
  `product_ID` INT NOT NULL,
  `quantity` INT NOT NULL,
  `total` INT NULL DEFAULT NULL,
  PRIMARY KEY (`order_ID`),
  INDEX `customer_ID` (`customer_ID` ASC) VISIBLE,
  INDEX `product_ID` (`product_ID` ASC) VISIBLE,
  CONSTRAINT `orders_ibfk_1`
    FOREIGN KEY (`customer_ID`)
    REFERENCES `ordermanagement`.`customer` (`customer_ID`),
  CONSTRAINT `orders_ibfk_2`
    FOREIGN KEY (`product_ID`)
    REFERENCES `ordermanagement`.`product` (`product_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ordermanagement`.`ordersdetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordermanagement`.`ordersdetails` (
  `detail_ID` INT NOT NULL,
  `order_ID` INT NOT NULL,
  `delivery_address` VARCHAR(30) NULL DEFAULT NULL,
  `delivery_date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`detail_ID`),
  INDEX `order_ID` (`order_ID` ASC) VISIBLE,
  CONSTRAINT `ordersdetails_ibfk_1`
    FOREIGN KEY (`order_ID`)
    REFERENCES `ordermanagement`.`orders` (`order_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
