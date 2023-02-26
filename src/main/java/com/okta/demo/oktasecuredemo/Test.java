package com.okta.demo.oktasecuredemo;

import com.okta.jwt.AccessTokenVerifier;
import com.okta.jwt.Jwt;
import com.okta.jwt.JwtVerificationException;
import com.okta.jwt.JwtVerifiers;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;

public class Test {
    public static void main(String[] args) throws JwtVerificationException {

        String jwtString = "eyJraWQiOiJyRU9sa21RNEZkeWVHVXpKel93emdWY0l6aUt6NkxjUmlFeWpRdS1aTXE0IiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULjRWUHoyREpaY3FiMXZmQnVfcVdIOWR1TEFEeER6RXFReHNNWXpENVpjOVEiLCJpc3MiOiJodHRwczovL3RyaWFsLTIyNDg5OTEub2t0YS5jb20vb2F1dGgyL2RlZmF1bHQiLCJhdWQiOiJhcGk6Ly9kZWZhdWx0IiwiaWF0IjoxNjc2OTQyNjIyLCJleHAiOjE2NzY5NDMyMjIsImNpZCI6IjBvYTQ3eGs4cWxRQUFzSzRENjk3Iiwic2NwIjpbIm9wZXJhdG9ycyJdLCJzdWIiOiIwb2E0N3hrOHFsUUFBc0s0RDY5NyJ9.xESQd2hd7lmuZtMRvg8rB8_W4onCtS3tAYjCbZ8ZoGHjJBPjLK5DxqYJTc2cWExIWEaHWqW8inh-fYF8PMnfzzFM_lUZWXBNeleXIoOwGLqSiabUHVk0udMArx_m0exWE4MionLq30cXvQsOo5o0Y3Z_z0DFAP1MYarxEVpjTtDIX6geeZxAbrcxuiV1kI6maSCUcxDJMohr9HHes5K-Z1H4A-dy1tsKyItjCQqqNLHWmU7E0gbUDCz5Rh6dty8L5pdKvoF2zIRBUBtuLI82uOk4QXhJWyg9GGlgg1GrLLc2y4kOFli5s5io1dZAFQIciNelrgXwntJoUAxfQxpsGw";

        AccessTokenVerifier jwtVerifier = JwtVerifiers.accessTokenVerifierBuilder()
                .setIssuer("https://trial-2248991.okta.com/oauth2/default")
                .setAudience("api://default")                   // defaults to 'api://default'
                .setConnectionTimeout(Duration.ofSeconds(1))    // defaults to 1s
                .build();
        Jwt jwt = jwtVerifier.decode(jwtString);
        System.out.println(jwt.getClaims().get("aClaimKey"));
        System.out.println(new String(Base64.getDecoder().decode("eyJraWQiOiJyRU9sa21RNEZkeWVHVXpKel93emdWY0l6aUt6NkxjUmlFeWpRdS1aTXE0IiwiYWxnIjoiUlMyNTYifQ".getBytes())));

    }
}
