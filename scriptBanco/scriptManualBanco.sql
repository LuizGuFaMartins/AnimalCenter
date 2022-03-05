CREATE SCHEMA IF NOT EXISTS `AnimalCenter` DEFAULT CHARACTER SET utf8 ;
USE `AnimalCenter` ;

CREATE TABLE IF NOT EXISTS Administrador (
  id_adm INT NOT NULL AUTO_INCREMENT,
  nome_adm VARCHAR(45) NOT NULL,
  cpf_adm VARCHAR(45) NOT NULL,
  senha_adm VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_adm) 
);

INSERT INTO administrador (nome_adm, cpf_adm, senha_adm) VALUES ("Bartolomeu", "123.123.123-23", "asdf");
INSERT INTO administrador (nome_adm, cpf_adm, senha_adm) VALUES ("Creusa", "123.123.789-23", "asdf");

CREATE TABLE IF NOT EXISTS Funcionario (
  id_fun INT NOT NULL AUTO_INCREMENT,
  nome_fun VARCHAR(45) NOT NULL,
  cpf_func VARCHAR(45) NOT NULL,
  cargo_fun VARCHAR(45) NOT NULL,
  senha_fun VARCHAR(45) NOT NULL,
  Administrador_id_adm INT NOT NULL,
  PRIMARY KEY (id_fun),
  FOREIGN KEY (Administrador_id_adm) REFERENCES Administrador (id_adm)
);

INSERT INTO funcionario (nome_fun, cpf_func, cargo_fun, senha_fun, Administrador_id_adm) VALUES ("Luiz", "123.123.789-23", "Atendente", "123456789", 1);
INSERT INTO funcionario (nome_fun, cpf_func, cargo_fun, senha_fun, Administrador_id_adm) VALUES ("Cristiane", "123.177.789-23", "Atendente", "123456789", 2);
INSERT INTO funcionario (nome_fun, cpf_func, cargo_fun, senha_fun, Administrador_id_adm) VALUES ("Gabriel", "123.893.789-23", "Veterinario", "123456789", 1);
INSERT INTO funcionario (nome_fun, cpf_func, cargo_fun, senha_fun, Administrador_id_adm) VALUES ("Silvia", "333.123.789-23", "Veterinario", "123456789", 2);
INSERT INTO funcionario (nome_fun, cpf_func, cargo_fun, senha_fun, Administrador_id_adm) VALUES ("Hebert", "333.443.789-23", "Tosador", "123456789", 2);

CREATE TABLE IF NOT EXISTS Cliente (
  id_cli INT NOT NULL AUTO_INCREMENT,
  cpf_cli VARCHAR(20) NOT NULL,
  nome_cli VARCHAR(45) NOT NULL,
  tel_cli VARCHAR(45) NOT NULL,
  cep_cli VARCHAR(45) NOT NULL,
  estado_cli VARCHAR(45) NOT NULL,
  cidade_cli VARCHAR(45) NOT NULL,
  logradouro_cli VARCHAR(45) NOT NULL,
  bairro VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_cli)
);

INSERT INTO Cliente (cpf_cli, nome_cli, tel_cli, cep_cli, estado_cli, cidade_cli, logradouro_cli, bairro) VALUES ("333.123.789-23", "Jeremias", "(43) 99999-8888", "78945-444", "PR", "Curitiba", "Corguinho", "Fim da rua");
INSERT INTO Cliente (cpf_cli, nome_cli, tel_cli, cep_cli, estado_cli, cidade_cli, logradouro_cli, bairro) VALUES ("333.123.789-21", "Florildas", "(50) 97777-8888", "78945-444", "PR", "Curitiba", "Corguinho", "Fim da rua");

CREATE TABLE IF NOT EXISTS Animal (
  id_ani INT NOT NULL AUTO_INCREMENT,
  nome_ani VARCHAR(45) NOT NULL,
  raca_ani VARCHAR(45) NOT NULL,
  porte_ani VARCHAR(45) NOT NULL,
  dataNasc_ani VARCHAR(45) NULL,
  idade_ani INT NULL,
  Cliente_id_cli INT NOT NULL,
  PRIMARY KEY (id_ani),
  FOREIGN KEY (Cliente_id_cli) REFERENCES Cliente (id_cli)
);

INSERT INTO Animal (nome_ani, raca_ani, porte_ani, dataNasc_ani, idade_ani, Cliente_id_cli) VALUES ("Cachorro", "Vira-lata", "Grande", "02/02/2002", 19, 1);
INSERT INTO Animal (nome_ani, raca_ani, porte_ani, dataNasc_ani, idade_ani, Cliente_id_cli) VALUES ("Gato", "Vira-lata", "Pequeno", "02/02/2002", 19, 2);

CREATE TABLE IF NOT EXISTS Agendamento (
  id_age INT NOT NULL AUTO_INCREMENT,
  Animal_id_ani INT NOT NULL,
  servico_age VARCHAR(45) NOT NULL,
  data_age VARCHAR(45) NOT NULL,  
  Funcionario_id_fun INT NOT NULL,
  PRIMARY KEY (id_age),
  FOREIGN KEY (Funcionario_id_fun) REFERENCES Funcionario (id_fun),
  FOREIGN KEY (Animal_id_ani) REFERENCES Animal (id_ani)
)
