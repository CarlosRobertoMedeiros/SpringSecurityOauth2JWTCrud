package com.robertodev.springsecuritycrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@SpringBootApplication
public class SpringSecurityCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityCrudApplication.class, args);
		//Realizando a Autenticação básica
		//Curso
		// 6.1. Implementando autenticação Oauth2 Com Bearer
		/*RegraBásica
		
			Criar as Classes 
				- AuthorizationServer
				- Resource Server
				- OAuthSecurityConfig
				
			Para o AuthorizationServer Implementar os métodos 
				- configure(ClientDetailsServiceConfigurer clients)
				- configure(AuthorizationServerEndpointsConfigurer endpoints)
					Aqui informa em memória, usuário e senha
				- configure(HttpSecurity http)
					Aqui informa as configurações Stateless
					Quais apis são permitidas e para quem
			
			Para o ResourceServerConfig
				configure(AuthenticationManagerBuilder auth) 
				configure(HttpSecurity http) 
				
			Para o Postman
				Criar uma requisição localhost:8080/oauth/token(POST)
				Informar no Body
					client      = angular
					username    = admin 
					password    = {noop}admin
					grant_type  = password
				Informar no Authorization
					Type Basic Auth 
						username angular
						password @angular0
					Preview Request
			
				Ao chamar a função, informar bearer AccessToken Result
			*/
	}
}


