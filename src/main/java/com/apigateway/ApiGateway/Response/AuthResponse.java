package com.apigateway.ApiGateway.Response;

import java.util.Collection;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthResponse {
	
	
	private String userId;
	private String accessToken;
	private String refreshtoken;
	private long expireAt;
	private Collection<String> authorities;

}
