package com.apigateway.ApiGateway.AuthController;

import com.apigateway.ApiGateway.Response.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class authController {
	
	
	
	
	@GetMapping("/login")
	public ResponseEntity<AuthResponse> getauth(@RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,@AuthenticationPrincipal OidcUser user,Model model){
		
		AuthResponse authresponse = new AuthResponse();
		
		authresponse.setUserId(user.getEmail());
		authresponse.setAccessToken(client.getAccessToken().getTokenValue());
		authresponse.setRefreshtoken(client.getRefreshToken().getTokenValue());
		authresponse.setExpireAt(client.getAccessToken().getExpiresAt().getEpochSecond());

List<String> authoritieslist=user.getAuthorities().stream().map(GrantedAuthority -> {return GrantedAuthority.getAuthority();} ).collect(Collectors.toList());
		
authresponse.setAuthorities(authoritieslist);
return new ResponseEntity<>(authresponse,HttpStatus.OK);
	}

}
