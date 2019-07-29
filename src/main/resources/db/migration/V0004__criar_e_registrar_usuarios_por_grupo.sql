CREATE TABLE tb_usuarios_por_grupo (
	codigo_grupo BIGINT(20) NOT NULL,
	codigo_usuario BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_grupo, codigo_usuario),
	FOREIGN KEY (codigo_grupo) REFERENCES tb_grupos_de_usuarios(codigo),
	FOREIGN KEY (codigo_usuario) REFERENCES tb_usuarios(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- carlosmedeiroslima@gmail.com Seria administrador
INSERT INTO tb_usuarios_por_grupo (codigo_grupo, codigo_usuario) values (1, 1);

-- lucienealves@gmail.com Serviria a outras funções
INSERT INTO tb_usuarios_por_grupo (codigo_grupo, codigo_usuario) values (2, 2);
INSERT INTO tb_usuarios_por_grupo (codigo_grupo, codigo_usuario) values (3, 2);