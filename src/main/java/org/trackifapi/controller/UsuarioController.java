package org.trackifapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trackifapi.modal.dto.UsuarioChildDto;
import org.trackifapi.services.Child.CreateUserChild;
import org.trackifapi.services.Child.ListUserChild;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final CreateUserChild createUserChild;
    private final ListUserChild listUserChild;

    public UsuarioController(CreateUserChild createUserChild, ListUserChild listUserChild) {
        this.createUserChild = createUserChild;
        this.listUserChild = listUserChild;
    }

    @GetMapping("/child")
    public ResponseEntity<List<UsuarioChildDto>> getUsuarioChild() {
        List<UsuarioChildDto> user = listUserChild.listUserChild();
        return ResponseEntity.ok(user);
    }

    @PostMapping("/child/add")
    public ResponseEntity<?> createUsuarioChild(@RequestBody UsuarioChildDto dto) {
        return createUserChild.createUsuarioChild(dto);
    }
}
