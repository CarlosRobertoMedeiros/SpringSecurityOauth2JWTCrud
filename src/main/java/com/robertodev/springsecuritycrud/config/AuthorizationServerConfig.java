package com.robertodev.springsecuritycrud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author roberto
 * @version 1.0
 *
 */

/* (non-Javadoc)
 * @see org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer)
 * Autorizo o Servidor a receber os dados do ResourceServerConfig referentes a acesso
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager autenticationManager;
	
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		//Dado em Memória poderia ser no banco de dados
		final Integer MINUTOS = 1;
		final Integer SEGUNDO = 60;
		
		
		
		
		clients.inMemory()
				.withClient("angular")
				.secret("@angular0")
				.scopes("read","write")
				.authorizedGrantTypes("password","refresh_token") //GrantType = passwordFlow 
																  //O RefreshToken é usado para garantir segurança
				.accessTokenValiditySeconds(SEGUNDO * MINUTOS)
				.refreshTokenValiditySeconds(3600 * 24);
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore())
		.accessTokenConverter(accessTokenConverter())
		.reuseRefreshTokens(false) 
		.authenticationManager(autenticationManager);
	}
	
	@Bean
	protected JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey("adminserver");
		return accessTokenConverter;
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}
	
}
