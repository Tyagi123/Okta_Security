package com.okta.demo.oktasecuredemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "okta.oauth2")
@ConfigurationPropertiesScan
public class AppProperties {
    private String issuer = "https://trial-2248991.okta.com/oauth2/default";
    private String clientId= "0oa47xk8qlQAAsK4D697";

    private String  clientSecret= "FDypRkMqr36cchazYgi5hkverorX3A9zBAfUZ_iS";

    private String redirectUri="{baseUrl}/authorization-code/callback";

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }
}