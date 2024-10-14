-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema pzm
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pzm
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pzm` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `pzm` ;

-- -----------------------------------------------------
-- Table `pzm`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pzm`.`book` (
  `num` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NOT NULL,
  `price` INT NOT NULL,
  `author` VARCHAR(50) NULL DEFAULT NULL,
  `page` INT NOT NULL,
  PRIMARY KEY (`num`),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 26
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pzm`.`bookimage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pzm`.`bookimage` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `book_num` INT NOT NULL,
  `type` INT NOT NULL DEFAULT '1',
  `path` VARCHAR(150) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  INDEX `fk_bookimage_book_idx` (`book_num` ASC) VISIBLE,
  CONSTRAINT `fk_bookimage_book`
    FOREIGN KEY (`book_num`)
    REFERENCES `pzm`.`book` (`num`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pzm`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pzm`.`customer` (
  `customer_id` VARCHAR(50) NOT NULL,
  `customer_name` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `age` INT NULL DEFAULT NULL,
  `rating` VARCHAR(20) NOT NULL,
  `occupation` VARCHAR(20) NULL DEFAULT NULL,
  `reserves` INT NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pzm`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pzm`.`cart` (
  `cart_number` INT NOT NULL AUTO_INCREMENT,
  `customer_id` VARCHAR(50) NOT NULL,
  `book_num` INT NOT NULL,
  `quantity` INT NOT NULL,
  `cart_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cart_number`),
  INDEX `fk_cart_customer1_idx` (`customer_id` ASC) VISIBLE,
  INDEX `fk_cart_book1_idx` (`book_num` ASC) VISIBLE,
  CONSTRAINT `fk_cart_book1`
    FOREIGN KEY (`book_num`)
    REFERENCES `pzm`.`book` (`num`),
  CONSTRAINT `fk_cart_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `pzm`.`customer` (`customer_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pzm`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pzm`.`review` (
  `review_id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` VARCHAR(50) NOT NULL,
  `book_num` INT NOT NULL,
  `rating` DECIMAL(2,1) NOT NULL,
  `content` TEXT NOT NULL,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`review_id`),
  INDEX `fk_review_customer1_idx` (`customer_id` ASC) VISIBLE,
  INDEX `fk_review_book1_idx` (`book_num` ASC) VISIBLE,
  CONSTRAINT `fk_review_book1`
    FOREIGN KEY (`book_num`)
    REFERENCES `pzm`.`book` (`num`),
  CONSTRAINT `fk_review_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `pzm`.`customer` (`customer_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
