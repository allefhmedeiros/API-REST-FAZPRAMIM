CREATE TABLE `tbl_cliente` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(300) NOT NULL,
  `email` VARCHAR(300) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `data_cadastro` DATETIME NOT NULL,
  `senha` VARCHAR(300) NOT NULL,
  `status` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);


CREATE TABLE `tbl_endereco` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `logradouro` VARCHAR(300) NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(45) NOT NULL,
  `status` TINYINT NOT NULL,
  `tbl_cliente_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tbl_endereco_tbl_cliente_idx` (`tbl_cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_tbl_endereco_tbl_cliente`
    FOREIGN KEY (`tbl_cliente_id`)
    REFERENCES `tbl_cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `tbl_prestador` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(300) NOT NULL,
  `documento` VARCHAR(300) NOT NULL,
  `status` TINYINT NOT NULL,
  `email` VARCHAR(300) NOT NULL,
  `senha` VARCHAR(300) NOT NULL,
  `apresentacao` VARCHAR(3000) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);


CREATE TABLE `tbl_tipo_servico` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE);


CREATE TABLE `tbl_catalogo` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `data_cadastro` DATETIME NOT NULL,
  `tbl_prestador_id` BIGINT NOT NULL,
  `tbl_tipo_servico_id` BIGINT NOT NULL,
  `valor_hora` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tbl_catalogo_tbl_prestador1_idx` (`tbl_prestador_id` ASC) VISIBLE,
  INDEX `fk_tbl_catalogo_tbl_tipo_servico1_idx` (`tbl_tipo_servico_id` ASC) VISIBLE,
  CONSTRAINT `fk_tbl_catalogo_tbl_prestador1`
    FOREIGN KEY (`tbl_prestador_id`)
    REFERENCES `tbl_prestador` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_catalogo_tbl_tipo_servico1`
    FOREIGN KEY (`tbl_tipo_servico_id`)
    REFERENCES `tbl_tipo_servico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `tbl_status` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE);


CREATE table `tbl_ordem_servico` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `data_cadastro` DATETIME NOT NULL,
  `data_agendamento` DATETIME NOT NULL,
  `tbl_status_id` BIGINT NOT NULL,
  `tbl_cliente_id` BIGINT NOT NULL,
  `tbl_endereco_id` BIGINT NOT NULL,
  `valor_total` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tbl_ordem_servico_tbl_status1_idx` (`tbl_status_id` ASC) VISIBLE,
  INDEX `fk_tbl_ordem_servico_tbl_cliente1_idx` (`tbl_cliente_id` ASC) VISIBLE,
  INDEX `fk_tbl_ordem_servico_tbl_endereco1_idx` (`tbl_endereco_id` ASC) VISIBLE,
  CONSTRAINT `fk_tbl_ordem_servico_tbl_status1`
    FOREIGN KEY (`tbl_status_id`)
    REFERENCES `tbl_status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_ordem_servico_tbl_cliente1`
    FOREIGN KEY (`tbl_cliente_id`)
    REFERENCES `tbl_cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_ordem_servico_tbl_endereco1`
    FOREIGN KEY (`tbl_endereco_id`)
    REFERENCES `tbl_endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `tbl_detalhe_servico` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `tbl_ordem_servico_id` BIGINT NOT NULL,
  `tbl_catalogo_id` BIGINT NOT NULL,
  `qtd_horas` INT NOT NULL,
  `sub_total` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tbl_detalhe_servico_tbl_ordem_servico1_idx` (`tbl_ordem_servico_id` ASC) VISIBLE,
  INDEX `fk_tbl_detalhe_servico_tbl_catalogo1_idx` (`tbl_catalogo_id` ASC) VISIBLE,
  CONSTRAINT `fk_tbl_detalhe_servico_tbl_ordem_servico1`
    FOREIGN KEY (`tbl_ordem_servico_id`)
    REFERENCES `tbl_ordem_servico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_detalhe_servico_tbl_catalogo1`
    FOREIGN KEY (`tbl_catalogo_id`)
    REFERENCES `tbl_catalogo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `tbl_nps` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nota` INT NOT NULL,
  `data` DATETIME NOT NULL,
  `comentario` VARCHAR(1000) NULL,
  `tbl_ordem_servico_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tbl_nps_tbl_ordem_servico1_idx` (`tbl_ordem_servico_id` ASC) VISIBLE,
  CONSTRAINT `fk_tbl_nps_tbl_ordem_servico1`
    FOREIGN KEY (`tbl_ordem_servico_id`)
    REFERENCES `tbl_ordem_servico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
