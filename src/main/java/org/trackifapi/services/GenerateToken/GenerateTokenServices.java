package org.trackifapi.services.GenerateToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class GenerateTokenServices {
    private final RestTemplate restTemplate;
    private final String secretKey = "secret-key";

    public GenerateTokenServices(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getAddress(double lat, double lng) {
        String url = "http://localhost:8080/get-address?lat=" + lat + "&lng=" + lng;
        return restTemplate.getForObject(url, String.class);
    }

    public Map<String, Object> extractClaimsFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();

            Map<String, Object> extractedClaims = new HashMap<>();
            extractedClaims.put("address", claims.get("address"));
            extractedClaims.put("timestamp", claims.get("timestamp"));
            extractedClaims.put("subject", claims.getSubject());

            return extractedClaims;
        } catch (SignatureException e) {
            System.out.println("Invalid token signature.");
            return new HashMap<>();
        }
    }

    public Map<String, Object> decodeToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();

            Map<String, Object> tokenInfo = new HashMap<>();
            tokenInfo.put("subject", claims.getSubject());
            tokenInfo.put("address", claims.get("address"));
            tokenInfo.put("timestamp", claims.get("timestamp"));

            return tokenInfo;
        } catch (SignatureException e) {
            throw new RuntimeException("Invalid token");
        }
    }

    public String createToken(String address) {
        Map<String, Object> claims = new HashMap<>();

        claims.put("address", address);
        claims.put("timestamp", new Date());

        // Gera um token JWT válido
        return Jwts.builder()
                .setClaims(claims)
                .setSubject("Token Subject")
                .setIssuedAt(new Date())
                .setExpiration(null) // Define como null para que o token não expire
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
