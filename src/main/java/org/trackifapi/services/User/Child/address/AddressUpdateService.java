package org.trackifapi.services.User.Child.address;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.trackifapi.modal.entity.TokenModalChild;
import org.trackifapi.modal.repository.TokenModalChildRepository;

import java.util.Map;
import java.util.Optional;

@Service
public class AddressUpdateService {

    private final RestTemplate restTemplate;
    private final TokenModalChildRepository tokenModalChildRepository;

    public AddressUpdateService(RestTemplate restTemplate, TokenModalChildRepository tokenModalChildRepository) {
        this.restTemplate = restTemplate;
        this.tokenModalChildRepository = tokenModalChildRepository;
    }

    /**
     * Verifica e atualiza o endereço associado ao token de um usuário filho.
     *
     * Este método realiza as seguintes operações:
     * 1. Recupera o `TokenModalChild` do repositório usando o `id` fornecido.
     * 2. Se o token for encontrado, decodifica o endereço usando o token.
     * 3. Compara o endereço obtido com o endereço atual armazenado no banco de dados.
     * 4. Se o endereço obtido for diferente do atual, atualiza o endereço no banco de dados.
     * 5. Retorna uma resposta indicando o sucesso ou a falha na atualização do endereço.
     *
     * @param id O identificador do `TokenModalChild` que deve ser verificado e atualizado.
     */
    public ResponseEntity<String> verifyAndUpdateAddress(Integer id) {
        try {
            Optional<TokenModalChild> optionalTokenEntity = tokenModalChildRepository.findById(id);

            if (optionalTokenEntity.isPresent()) {
                // Obtém o token do TokenModalChild encontrado
                TokenModalChild tokenModalChild = optionalTokenEntity.get();
                // Obtém o novo endereço associado ao token
                String newAddress = getAddress(tokenModalChild.getToken());

                if (newAddress != null && !newAddress.equals(tokenModalChild.getAddress())) {
                    // Atualiza o endereço no banco de dados se for diferente do atual
                    tokenModalChild.setAddress(newAddress);
                    tokenModalChildRepository.save(tokenModalChild);
                    // Retorna uma resposta de sucesso com o novo endereço
                    return ResponseEntity.ok("Endereço atualizado para: " + newAddress);
                } else if (newAddress != null) {
                    // Retorna uma resposta indicando que o endereço permanece o mesmo
                    return ResponseEntity.ok("Endereço permanece o mesmo");
                } else {
                    // Retorna uma resposta de erro se não for possível obter o novo endereço
                    return ResponseEntity.badRequest().body("Não foi possível obter o novo endereço.");
                }
            } else {
                // Retorna uma resposta de erro se o token não for encontrado no banco de dados
                return ResponseEntity.badRequest().body("Token não encontrado no banco de dados.");
            }
        } catch (Exception e) {
            // Retorna uma resposta de erro em caso de exceção
            return ResponseEntity.badRequest().body("Erro ao verificar e atualizar o endereço: " + e.getMessage());
        }
    }

    // extraindo token do usuario
    private String getAddress(String token) {
        String url = "http://localhost:8080/token/decodeToken?token=" + token;
        try {
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            if (response != null) {
                return (String) response.get("address");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
