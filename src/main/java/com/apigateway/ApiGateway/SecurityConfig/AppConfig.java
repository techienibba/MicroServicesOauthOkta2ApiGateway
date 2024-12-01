package com.apigateway.ApiGateway.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class AppConfig {

	@Bean
	public SecurityWebFilterChain securitywebfilterchain(ServerHttpSecurity serverhttpsecurity)
	{
		serverhttpsecurity.authorizeExchange().anyExchange().authenticated().and().oauth2Client().and().oauth2ResourceServer().jwt();
		
		return serverhttpsecurity.build();
		
		
		
		
		
		
	}
	
	
}
