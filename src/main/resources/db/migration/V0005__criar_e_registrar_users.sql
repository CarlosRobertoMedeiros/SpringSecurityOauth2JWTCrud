CREATE TABLE tb_users (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_users (nome) values ('Messi');
INSERT INTO tb_users (nome) values ('Neymar');
INSERT INTO tb_users (nome) values ('Cristiano Ronaldo');

