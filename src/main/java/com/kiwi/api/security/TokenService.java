package com.kiwi.api.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.kiwi.api.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TokenService {

    private static final Logger logger = LoggerFactory.getLogger(TokenService.class);

    @Value("${kiwi.security.secret}")
    private String apiSecret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("kiwi forum")
                    .withSubject(user.getLogin())
                    .withClaim("id", user.getId())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);
        } catch (JWTVerificationException exception) {
            logger.error("Failed to generate token: {}", exception.getMessage());
            throw new RuntimeException("Failed to generate token", exception);
        }
    }

    public String getSubject(String token) {
        if (token == null) {
            throw new IllegalArgumentException("Token cannot be null");
        }

        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            DecodedJWT verifier = JWT.require(algorithm)
                    .withIssuer("kiwi forum")
                    .build()
                    .verify(token);

            logger.info("Token verification successful for subject: {}", verifier.getSubject());
            return verifier.getSubject();
        } catch (JWTVerificationException exception) {
            logger.error("Token verification failed: {}", exception.getMessage());
            throw new RuntimeException("Token verification failed", exception);
        }
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }

}
