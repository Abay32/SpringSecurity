package com.api.spring.security.service;

import com.api.spring.security.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private String secretKey = null;


    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts
                .builder()
                .claims()
                .add(claims)
                .subject(user.getUsername())
                .issuer("DCB")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60*10*1000))
                .and()
                .signWith(generateKey())
                .compact();
    }

    public String getSecretKey(){
        secretKey = "DjJvjxrfi/fZ/j981BzSVKvnPP7SsrPTBbbP8s6kMwE=";

        return secretKey;
    }

    public SecretKey generateKey(){

        byte[] decode = Decoders.BASE64.decode(getSecretKey());

        return Keys.hmacShaKeyFor(decode);

    }
}
