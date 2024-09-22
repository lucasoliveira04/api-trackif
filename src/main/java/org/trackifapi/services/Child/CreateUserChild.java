package org.trackifapi.services.Child;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.trackifapi.modal.dto.UsuarioChildDto;
import org.trackifapi.modal.entity.Child.UsuarioChild;
import org.trackifapi.modal.repository.UsuarioChildRepository;

@Service
public class CreateUserChild {
    private final UsuarioChildRepository usuarioChildRepository;

    public CreateUserChild(UsuarioChildRepository usuarioChildRepository) {
        this.usuarioChildRepository = usuarioChildRepository;
    }

    public ResponseEntity<UsuarioChild> createUsuarioChild(UsuarioChildDto dto) {
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
        try {
            usuarioChildRepository.save(usuarioChild);
            return new ResponseEntity<>(usuarioChild, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
