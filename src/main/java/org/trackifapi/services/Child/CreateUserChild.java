package org.trackifapi.services.Child;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.trackifapi.Enums.RolesEnum;
import org.trackifapi.Exceptions.RegexValidationException;
import org.trackifapi.modal.dto.UsuarioChildDto;
import org.trackifapi.modal.entity.Child.UsuarioChild;
import org.trackifapi.modal.repository.TokenChildRepository;
import org.trackifapi.modal.repository.UsuarioChildRepository;
import org.trackifapi.util.CheckUserRole;

@Service
public class CreateUserChild {

    private final UsuarioChildRepository usuarioChildRepository;
    private final TokenChildRepository tokenChildRepository;
    private final CheckUserRole checkUserRole;

    public CreateUserChild(UsuarioChildRepository usuarioChildRepository, TokenChildRepository tokenChildRepository, CheckUserRole checkUserRole) {
        this.usuarioChildRepository = usuarioChildRepository;
        this.tokenChildRepository = tokenChildRepository;
        this.checkUserRole = checkUserRole;
    }

    public ResponseEntity<?> createUsuarioChild(UsuarioChildDto dto) {
        try{
            checkUserRole.checkToUser();
            RolesEnum roles = checkUserRole.getRole();
            UsuarioChild usuarioChild = new UsuarioChild(
                    dto.getNome(),
                    dto.getEmail(),
                    dto.getTelefone(),
                    dto.getCpf(),
                    dto.getRg(),
                    dto.getEndereco().getRua(),
                    dto.getEndereco().getEstado(),
                    dto.getEndereco().getCidade(),
                    dto.getEndereco().getBairro(),
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
