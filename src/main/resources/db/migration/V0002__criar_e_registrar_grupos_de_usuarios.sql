CREATE TABLE tb_grupos_de_usuarios (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_grupos_de_usuarios (nome) values ('ROLE_ADMINISTRAR'); 		 
INSERT INTO tb_grupos_de_usuarios (nome) values ('ROLE_LISTAR_PRODUTOS');	 
INSERT INTO tb_grupos_de_usuarios (nome) values ('ROLE_CADASTRAR_PRODUTOS');
INSERT INTO tb_grupos_de_usuarios (nome) values ('ROLE_REMOVER_PRODUTOS');
INSERT INTO tb_grupos_de_usuarios (nome) values ('ROLE_ATUALIZAR_PRODUTOS');