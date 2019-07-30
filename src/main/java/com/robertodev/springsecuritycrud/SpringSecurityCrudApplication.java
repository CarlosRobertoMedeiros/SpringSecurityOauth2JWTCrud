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
		//Refazer a aula
			//6.7. Movendo o refresh token para o cookie
		
			
		//Realizando a Autenticação básica
		//Curso
		// 6.1. Implementando autenticação Oauth2 Com JWTAccessToken Bearer
		/*RegraBásica
		
			Criar as Classes 
				- AuthorizationServer
				- Resource Server
				- OAuthSecurityConfig
				
			Para o AuthorizationServer Implementar os métodos 
				- configure(ClientDetailsServiceConfigurer clients)
				- configure(AuthorizationServerEndpointsConfigurer endpoints)
					Aqui informa em memória, usuário e senha
					Acresscenta um conversor para jwt
					IMplementa o conversor
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

			O REFRESH_TOKEN é atualizado sempre com intervalo de 1 dia
			enquanto o ACCESS_TOKEN de 1 minuto por exemplo
			Isso quer dizer que cada vez que eu pedir um novo access token vai ser gerado um novo 
			Refresh Token, garantindo assim que ele sempre tem brecha de 1 dia
			
			 Para garantir que ninguém tem acesso ao refresh tokem ele deve ser colocado em um 
			 cookie seguro ... Assim as chamadas Javascript não vão interferir nele.
			 
			
			*/
	}
}


