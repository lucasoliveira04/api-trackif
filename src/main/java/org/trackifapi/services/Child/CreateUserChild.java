package org.trackifapi.services.Child;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.trackifapi.Exceptions.RegexValidationException;
import org.trackifapi.modal.entity.dto.UsuarioChildDto;
import org.trackifapi.modal.entity.Child.UsuarioChild;
import org.trackifapi.modal.repository.UsuarioChildRepository;

@Service
public class CreateUserChild {
    private final UsuarioChildRepository usuarioChildRepository;

    public CreateUserChild(UsuarioChildRepository usuarioChildRepository) {
        this.usuarioChildRepository = usuarioChildRepository;
    }

    public ResponseEntity<?> createUsuarioChild(UsuarioChildDto dto) {
        try{
            UsuarioChild usuarioChild = new UsuarioChild(
                    dto.getNome(),
                    dto.getEmail(),
                    dto.getTelefone(),
                    dto.getCpf(),
                    dto.getRg(),
                    dto.getRua(),
                    dto.getEndereco().getEstado(),
                    dto.getEndereco().getCidade(),
                    dto.getEndereco().getBairro(),
                    dto.getEndereco().getCep()
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
