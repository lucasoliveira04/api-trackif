package org.trackifapi.services.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import org.trackifapi.Enum.RoleEnum;
import org.trackifapi.modal.Repository.UserChildModalRepository;
import org.trackifapi.modal.entity.child.UserChildModal;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GenerateTokenImpl implements IToken{

    private final String SECRET_KEY = "secret_key";

    public String createToken(RoleEnum role, Object user) {

        if (role.equals(RoleEnum.USER_CHILD) && user instanceof UserChildModal) {
            UserChildModal childUser = (UserChildModal) user;

            Map<String, Object> claims = new HashMap<>();
            claims.put("name", childUser.getName());
            claims.put("role", childUser.getRoleEnum());

            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(childUser.getName())
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();

        }

        throw new IllegalArgumentException("Invalid user type or role");
    }

    @Override
    public List<String> decodeToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();


        List<String> tokenDecodedValues = List.of(
                (String) claims.get("name"),
                (String) claims.get("role")
        );

        return tokenDecodedValues;
    }

    @Override
    public void deleteToken() {

    }

    @Override
    public void updateToken() {

    }
}
