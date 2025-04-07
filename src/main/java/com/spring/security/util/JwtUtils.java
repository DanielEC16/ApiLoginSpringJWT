package com.spring.security.util;

import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.stream.Collectors;


@Component
public class JwtUtils {

    @Value("${security.jwt.key.private}")
    private String privateKey;
    @Value("${security.jwt.user.generator}")
    private String userGenerator;

    public String createToken(Authentication authentication){
        Algorithm algorithm = Algorithm.HMAC256(this.privateKey);
        String username = authentication.getPrincipal().toString();
        String authorities = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(";"));
        String jwtToken = JWT.create()

        return null;
    }

}
