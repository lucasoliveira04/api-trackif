package org.trackifapi.services.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;
import org.trackifapi.Enum.RoleEnum;
import org.trackifapi.modal.dto.UserDto;
import org.trackifapi.modal.entity.child.UserChildModal;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Stream;

@Component
public class TokenCrudImpl implements IToken {

    private final String SECRET_KEY = "secret_key";

    @Override
    public String createToken(RoleEnum role, Object user) {
        if (role.equals(RoleEnum.USER_CHILD) && user instanceof UserChildModal) {
            UserChildModal childUser = (UserChildModal) user;

            Map<String, Object> claims = new HashMap<>();
            claims.put("name", childUser.getName());
            claims.put("role", childUser.getRoleEnum().toString());

            if (childUser.getAddress() != null) {
                claims.put("neighborhood", childUser.getAddress().getNeighborhood());
                claims.put("cep", childUser.getAddress().getCep());

            }

            for (Map.Entry<String, Object> entry : claims.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            String generatedToken = Jwts.builder()
                    .setClaims(claims)
                    .setSubject(childUser.getName())
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();

            System.out.println("Token gerado: " + generatedToken);
            return generatedToken;
        }
        throw new IllegalArgumentException("Invalid user type or role");
    }

    @Override
    public List<String> decodeToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();

            for (Map.Entry<String, Object> entry : claims.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            return Stream.of(
                            claims.get("name"),
                            claims.get("role"),
                            claims.get("neighborhood"),
                            claims.get("cep")
                    )
                    .filter(Objects::nonNull)
                    .map(Object::toString)
                    .toList();
        } catch (Exception e) {
            System.err.println("Erro ao decodificar o token: " + e.getMessage());
            return Collections.emptyList();
        }
    }



    @Override
    public void verificAddressToken(String token) {

    }

    @Override
    public void deleteToken() {

    }

    @Override
    public void updateToken() {
    }
}
