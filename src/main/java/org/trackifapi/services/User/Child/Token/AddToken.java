package org.trackifapi.services.User.Child.Token;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.trackifapi.modal.dto.TokenModalChildDto;
import org.trackifapi.modal.entity.TokenModalChild;
import org.trackifapi.modal.entity.UserChild;
import org.trackifapi.modal.repository.TokenModalChildRepository;
import org.trackifapi.modal.repository.UserChildRepository;
import org.trackifapi.services.GenerateToken.GenerateTokenServices;

import java.time.LocalDateTime;

@Service
public class AddToken {

    private final TokenModalChildRepository tokenModalChildRepository;
    private final UserChildRepository userChildRepository;
    private final RestTemplate restTemplate;

    public AddToken(TokenModalChildRepository tokenModalChildRepository, GenerateTokenServices generateTokenServices, UserChildRepository userChildRepository, RestTemplate restTemplate) {
        this.tokenModalChildRepository = tokenModalChildRepository;
        this.userChildRepository = userChildRepository;
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> addToken(TokenModalChildDto tokenModalChildDto, double lat, double lng) {
        try {
            TokenModalChild tokenModalChild = getTokenModalChild(tokenModalChildDto, lat, lng);
            tokenModalChildRepository.save(tokenModalChild);
            return ResponseEntity.ok().body("Token gerado com sucesso: " + tokenModalChildDto.getToken());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private TokenModalChild getTokenModalChild(TokenModalChildDto tokenModalChildDto, double lat, double lng) {
        TokenModalChild tokenModalChild = new TokenModalChild();

        tokenModalChild.setToken(getTokenAddress(lat, lng));
        tokenModalChild.setCreatedAt(LocalDateTime.now());

        UserChild userChild = userChildRepository.findById(tokenModalChildDto.getId())
                .orElseThrow(() -> new RuntimeException("User does not exist"));

        tokenModalChild.setUserChild(userChild);

        return tokenModalChild;

    }

    // rota que retorna token jwt
    private String getTokenAddress(double lat, double lng) {
        String url = "http://localhost:8080/token/generateToken?lat=" + lat + "&lng=" + lng;
        try {
            String token = restTemplate.getForObject(url, String.class);
            if (token == null || token.isEmpty()) {
                throw new RuntimeException("Token não encontrado na resposta.");
            }
            return token;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter token: " + e.getMessage(), e);
        }
    }



}
