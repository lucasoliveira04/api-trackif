package org.trackifapi.services.UserDefault;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.trackifapi.Enums.RolesEnum;
import org.trackifapi.Enums.StatusEnum;
import org.trackifapi.modal.dto.UserDefaultDto;
import org.trackifapi.modal.entity.UserDefault.UserDefault;
import org.trackifapi.modal.repository.UserDefaultRepository;
import org.trackifapi.modal.repository.UsuarioChildRepository;
import org.trackifapi.util.ApiAddressCep;
import org.trackifapi.util.CheckUserRole;
import org.trackifapi.util.UserExisting;

import java.util.Map;

@Service
public class CreateUserDefault {

    private final UsuarioChildRepository usuarioChildRepository;
    private final UserDefaultRepository userDefaultRepository;
    private final ApiAddressCep apiAddressCep;
    private final CheckUserRole checkUserRole;
    private final UserExisting userExisting;

    public CreateUserDefault(UsuarioChildRepository usuarioChildRepository, UserDefaultRepository userDefaultRepository, ApiAddressCep apiAddressCep, CheckUserRole checkUserRole, UserExisting userExisting) {
        this.usuarioChildRepository = usuarioChildRepository;
        this.userDefaultRepository = userDefaultRepository;
        this.apiAddressCep = apiAddressCep;
        this.checkUserRole = checkUserRole;
        this.userExisting = userExisting;
    }

    public ResponseEntity<?> createDefaultUser(UserDefaultDto dto) {
        try {
            checkUserRole.checkToUser();
            RolesEnum roles = checkUserRole.getRole();

            if (userExisting.userExists(dto.getCpf(), dto.getRg(), dto.getTelefone(), dto.getEmail())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já cadastrado");
            }

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

            UserDefault userDefault = new UserDefault(
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
                    roles,
                    dto.getStatus()
            );

            userDefaultRepository.save(userDefault);

            UserDefault savedUser = userDefaultRepository.findById(userDefault.getId()).orElse(null);


            if (savedUser.getStatus() == null){
                savedUser.setStatus(StatusEnum.ATIVADO);
                userDefaultRepository.save(savedUser);
            }

            return new ResponseEntity<>(userDefault, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar usuário: " + e.getMessage());
        }
    }

    private boolean userExists(String cpf, String rg, String telefone, String email) {
        return userDefaultRepository.findByCpf(cpf).isPresent() || usuarioChildRepository.findByCpf(cpf).isPresent() ||
                userDefaultRepository.findByRg(rg).isPresent() || usuarioChildRepository.findByRg(rg).isPresent() ||
                userDefaultRepository.findByTelefone(telefone).isPresent() || usuarioChildRepository.findByTelefone(telefone).isPresent() ||
                userDefaultRepository.findByEmail(email).isPresent() || usuarioChildRepository.findByEmail(email).isPresent();
    }
}