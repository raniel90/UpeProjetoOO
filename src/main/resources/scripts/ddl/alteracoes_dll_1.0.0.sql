CREATE TABLE `hemocentro` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR(255) NOT NULL COLLATE 'latin1_general_ci',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `nome` (`nome`)
)
COLLATE='latin1_general_ci'
ENGINE=MyISAM;