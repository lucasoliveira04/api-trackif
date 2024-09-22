package org.trackifapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trackifapi.modal.Services.AddUserChild;
import org.trackifapi.modal.dto.UsuarioChildDto;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final AddUserChild addUserChild;

    public UsuarioController(AddUserChild addUserChild) {
        this.addUserChild = addUserChild;
    }

    @PostMapping("/add/user-child")
    public ResponseEntity<UsuarioChildDto> createUserChild(@RequestBody UsuarioChildDto dto){
        return addUserChild.add(dto);
    }
}
