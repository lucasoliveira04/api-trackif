package org.trackifapi.services.Child;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.trackifapi.Enums.RolesEnum;
import org.trackifapi.Exceptions.RegexValidationException;
import org.trackifapi.modal.dto.UsuarioChildDto;
import org.trackifapi.modal.entity.Child.UsuarioChild;
import org.trackifapi.modal.repository.UsuarioChildRepository;
import org.trackifapi.util.ApiAddressCep;
import org.trackifapi.util.CheckUserRole;

import java.util.Map;

@Service
public class CreateUserChild {

    private final UsuarioChildRepository usuarioChildRepository;
    private final CheckUserRole checkUserRole;
    private final ApiAddressCep apiAddressCep;

    public CreateUserChild(UsuarioChildRepository usuarioChildRepository, CheckUserRole checkUserRole, ApiAddressCep apiAddressCep) {
        this.usuarioChildRepository = usuarioChildRepository;
        this.checkUserRole = checkUserRole;
        this.apiAddressCep = apiAddressCep;
    }

    public ResponseEntity<?> createUsuarioChild(UsuarioChildDto dto) {
        try{
            checkUserRole.checkToUser();
            RolesEnum roles = checkUserRole.getRole();

            String cep = dto.getEndereco().getCep();
            if (cep == null || cep.trim().isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CEP não pode ser vazio");
            }

            Map<String, String> enderecoMap = null;

            if (dto.getEndereco().getRua() == null || dto.getEndereco().getEstado() == null ||
                    dto.getEndereco().getCidade() == null || dto.getEndereco().getBairro() == null) {

                String cepInfo = apiAddressCep.getAddressByCep(dto.getEndereco().getCep());
                ObjectMapper mapper = new ObjectMapper();
                enderecoMap = mapper.readValue(cepInfo, Map.class);

                if (enderecoMap.containsKey("erro")){
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CEP inválido");
                }

            }

            UsuarioChild usuarioChild = new UsuarioChild(
                    dto.getNome(),
                    dto.getEmail(),
                    dto.getTelefone(),
                    dto.getCpf(),
                    dto.getRg(),
                    dto.getEndereco().getRua() != null ? dto.getEndereco().getRua() : enderecoMap.getOrDefault("logradouro", ""),
                    dto.getEndereco().getEstado() != null ? dto.getEndereco().getEstado() : enderecoMap.getOrDefault("uf", ""),
                    dto.getEndereco().getCidade() != null ? dto.getEndereco().getCidade() : enderecoMap.getOrDefault("localidade", ""),
                    dto.getEndereco().getBairro() != null ? dto.getEndereco().getBairro() : enderecoMap.getOrDefault("bairro", ""),
                    dto.getEndereco().getCep(),
                    roles
            );

            usuarioChildRepository.save(usuarioChild);

            return new ResponseEntity<>(usuarioChild, HttpStatus.CREATED);
        } catch (RegexValidationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro de validação: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar usuário: " + e.getMessage());
        }

    }
}
