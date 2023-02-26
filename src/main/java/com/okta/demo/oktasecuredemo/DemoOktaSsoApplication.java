package com.okta.demo.oktasecuredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@SpringBootApplication
//@EnableOAuth2Sso
@RestController
//@EnableConfigurationProperties(AppProperties.class)
public class DemoOktaSsoApplication {

	@GetMapping("/")
	public String greetUser(Principal principal){
		return "Hello "+principal.getName()+" from application 2";
	}
	@GetMapping("/operators/hello")

	public String greetUser1(@AuthenticationPrincipal OAuth2User oAuth2User,
							 @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient auth2AuthorizedClient){
		return "Hello from application 2";
	}
	@GetMapping("/operators1/hello")
	public String greetUser2(){
		return "Hello from application 2";
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoOktaSsoApplication.class, args);
	}

	@GetMapping("/operators/getToken")
	public String getToken(@AuthenticationPrincipal OAuth2User oAuth2User,
							 @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient auth2AuthorizedClient){
		return auth2AuthorizedClient.getAccessToken().getTokenValue();
	}

	@GetMapping("/operators/hello1")
	public String greetUser3(){
		return "Hello from application 2";
	}
}