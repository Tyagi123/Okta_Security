package com.okta.demo.oktasecuredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
//@EnableOAuth2Sso
@RestController
public class DemoOktaSsoApplication {

	@GetMapping("/")
	@PreAuthorize("hasAuthority('SCOPE_mod_custom')")
	public String greetUser(Principal principal){
		return "Hello "+principal.getName()+" from application 2";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoOktaSsoApplication.class, args);
	}

}