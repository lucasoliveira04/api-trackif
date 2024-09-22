package org.trackifapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trackifapi.modal.dto.UsuarioChildDto;
import org.trackifapi.modal.entity.Child.UsuarioChild;
import org.trackifapi.services.Child.CreateUserChild;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final CreateUserChild createUserChild;

    public UsuarioController(CreateUserChild createUserChild) {
        this.createUserChild = createUserChild;
    }

    @PostMapping("/child/add")
    public ResponseEntity<UsuarioChild> createUsuarioChild(@RequestBody UsuarioChildDto dto) {
        return createUserChild.createUsuarioChild(dto);
    }
}
