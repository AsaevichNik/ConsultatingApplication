SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


CREATE SCHEMA IF NOT EXISTS `mydatabase` DEFAULT CHARACTER SET utf8 ;
USE `mydatabase` ;

CREATE TABLE IF NOT EXISTS `mydatabase`.`user` (
`id` INT(255) AUTO_INCREMENT NOT NULL,
`full_name` VARCHAR(56) NOT NULL,
`birthday` INT(150) NOT NULL,
`email` VARCHAR(45) NOT NULL,
`password` VARCHAR(45) NOT NULL,
`role` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `mydatabase`.`tag` (
`id` INT AUTO_INCREMENT NOT NULL,
`tag` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `mydatabase`.`mentor` (
`experience` VARCHAR(256) NULL,
`mentor_id` INT AUTO_INCREMENT NOT NULL,
`user_id` INT(255) NULL,
`how_can_i_help` VARCHAR(45) NULL,
`skills` VARCHAR(45) NOT NULL,
`tag_id` INT NOT NULL,
PRIMARY KEY (`mentor_id`),
INDEX `fk_mentor_user1_idx` (`user_id` ASC) VISIBLE,
INDEX `fk_mentor_tag1_idx` (`tag_id` ASC) VISIBLE,
CONSTRAINT `fk_mentor_user1`
FOREIGN KEY (`user_id`)
REFERENCES `mydatabase`.`user` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_mentor_tag1`
FOREIGN KEY (`tag_id`)
REFERENCES `mydatabase`.`tag` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydatabase`.`catalog_professions` (
`id` INT AUTO_INCREMENT NOT NULL,
`name` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `mydatabase`.`mentor_has_catalog_professions` (
`mentor_mentor_id` INT NOT NULL,
`catalog_professions_id` INT NOT NULL,
PRIMARY KEY (`mentor_mentor_id`, `catalog_professions_id`),
INDEX `fk_mentor_has_catalog_professions_catalog_professions1_idx` (`catalog_professions_id` ASC) VISIBLE,
INDEX `fk_mentor_has_catalog_professions_mentor1_idx` (`mentor_mentor_id` ASC) VISIBLE,
CONSTRAINT `fk_mentor_has_catalog_professions_mentor1`
FOREIGN KEY (`mentor_mentor_id`)
REFERENCES `mydatabase`.`mentor` (`mentor_id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_mentor_has_catalog_professions_catalog_professions1`
FOREIGN KEY (`catalog_professions_id`)
REFERENCES `mydatabase`.`catalog_professions` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;