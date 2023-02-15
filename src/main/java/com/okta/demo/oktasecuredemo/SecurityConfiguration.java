package com.okta.demo.oktasecuredemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthenticationMethod;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
//@Configuration
public class SecurityConfiguration {

  private final AppProperties appProperties;

  public SecurityConfiguration(AppProperties appProperties) {
    this.appProperties = appProperties;
  }

  @Bean
  SecurityFilterChain oauth2SecurityFilterChain(HttpSecurity http) throws Exception {
//    http.authorizeRequests((requests) -> requests
//                    .antMatchers("/operators/**")
//                            .hasRole("Operators")
//            .antMatchers("/operators/**")
//            .authenticated()
//    ).oauth2ResourceServer(oauth2 -> oauth2.jwt());

    http
            .authorizeRequests()
            .antMatchers("/operators/**").hasAuthority("Operators") // <- LOOK AT ME!
            .anyRequest().authenticated()
            .and().oauth2Login()
            .and()
            .oauth2ResourceServer(oauth2 -> oauth2.jwt());


    // enables OAuth redirect login
  //  http.oauth2Login();
            //.clientRegistrationRepository(clientRegistrationRepository());
//
//    // enables OAuth Client configuration
//    http.oauth2Client();

    // enables REST API support for JWT bearer tokens
  //  http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

    return http.build();
  }

//  @Bean
//  public ClientRegistrationRepository clientRegistrationRepository() {
//    return new InMemoryClientRegistrationRepository(this.googleClientRegistration());
//  }
//
//  private ClientRegistration googleClientRegistration() {
//    return ClientRegistration.withRegistrationId("okta")
//            .clientId(appProperties.getClientId())
//            .clientSecret(appProperties.getClientSecret())
//            .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//            .scope("profile","email","openid")
//            .issuerUri(appProperties.getIssuer())
//            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//            .tokenUri("https://trial-2248991.okta.com/oauth2/default/v1/token")
//            .redirectUri(appProperties.getRedirectUri())
//            .authorizationUri("https://trial-2248991.okta.com/oauth2/default/v1/authorize")
//            .jwkSetUri("https://trial-2248991.okta.com/oauth2/default/v1/keys")
//            .clientName("https://trial-2248991.okta.com/oauth2/default")
//            .userInfoUri("https://trial-2248991.okta.com/oauth2/default/v1/userinfo")
//            .userInfoAuthenticationMethod(AuthenticationMethod.HEADER)
//            .userNameAttributeName("sub")
//            .build();
//  }
  }