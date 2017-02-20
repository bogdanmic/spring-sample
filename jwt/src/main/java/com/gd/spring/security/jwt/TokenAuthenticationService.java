package com.gd.spring.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class TokenAuthenticationService {

    private long EXPIRATIONTIME = 1000 * 60 * 60 * 24 * 10; // 10 days
    private String secret = "ThisIsASecret";
    private String tokenPrefix = "Bearer";
    private String headerString = "Authorization";

    /**
     * Updated a bit after this articles:
     * http://technicalrex.com/2015/02/20/stateless-authentication-with-spring-security-and-jwt
     * http://technicalrex.com/spring-security-jwt-followup
     * @param response
     * @param username
     */
    public void addAuthentication(HttpServletResponse response, String username) {
        Date now = new Date();
        Date expiration = new Date(System.currentTimeMillis() + EXPIRATIONTIME);

        // We generate a token now.
        String JWT = Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512, getEncodedSecret())
                .compact();
        response.addHeader(headerString, JWT);
    }

    private String getEncodedSecret() {
        return Base64.getEncoder().encodeToString(secret.getBytes());
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(headerString);
        if (token != null) {
            // parse the token.
            String username = Jwts.parser()
                    .setSigningKey(getEncodedSecret())
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            if (username != null) // we managed to retrieve a user
            {
                return new AuthenticatedUser(username);
            }
        }
        return null;
    }
}
