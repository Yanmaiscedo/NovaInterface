CREATE DATABASE cadastro;

USE cadastro;

CREATE TABLE `cadastro`.`cadastro_pessoa` (
  `id`       INT          NOT NULL AUTO_INCREMENT COMMENT '',
  `nome`     VARCHAR(100) NOT NULL                COMMENT '',
  `endereco` VARCHAR(100) NOT NULL                COMMENT '',
  `email`    VARCHAR(100)     NULL                COMMENT '',
  `telefone` VARCHAR(17)      NULL                COMMENT '',
  PRIMARY KEY (`id`)                              COMMENT '');

select * from cadastro_pessoa;
SELECT * FROM cadastro_pessoa WHERE id > 1;

CREATE TABLE `cadastro`.`uf` (
  `id`       INT          NOT NULL AUTO_INCREMENT COMMENT '',
  `nome`     VARCHAR(100) NOT NULL                COMMENT '',
  `sigla` VARCHAR(2)   NOT NULL                COMMENT '',
  PRIMARY KEY (`id`)                              COMMENT '');
  
select * from uf;
