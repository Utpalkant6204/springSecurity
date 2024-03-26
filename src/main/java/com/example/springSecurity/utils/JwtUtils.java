package com.example.springSecurity.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import java.util.Optional;

@Slf4j
public class JwtUtils {

    private static final SecretKey secretKey = Jwts.SIG.HS256.key().build();

    public JwtUtils() {
    }

    public static boolean validate(String jwtToken) {
        return parseToken(jwtToken) != null;
    }

    private static Optional<Claims> parseToken(String jwtToken) {
        var jwtParser = Jwts.parser()
                .verifyWith(secretKey)
                .build();

        try {
            return Optional.of(jwtParser.parseSignedClaims(jwtToken)
                    .getPayload());
        } catch (JwtException e) {
            System.out.println("error : " + e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    public static Optional<String> getUserNameFromToken(String jwtToken) {
        var ClaimsOptional = parseToken(jwtToken);

        if(ClaimsOptional.isPresent()){
            return Optional.of(ClaimsOptional.get().getSubject());
        }

        return Optional.empty();
    }
}
