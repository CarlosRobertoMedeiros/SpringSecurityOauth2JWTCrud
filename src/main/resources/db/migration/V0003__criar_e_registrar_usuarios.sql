CREATE TABLE tb_usuarios (
	codigo BIGINT(20) PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_usuarios (codigo, nome, email, senha) values (1, 'Carlos Roberto', 'carlosmedeiroslima@gmail.com', 'carlos');
INSERT INTO tb_usuarios (codigo, nome, email, senha) values (2, 'Luciene Alves', 'lucienealves@gmail.com', 'luciene');

