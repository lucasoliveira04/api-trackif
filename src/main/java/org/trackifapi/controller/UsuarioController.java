package org.trackifapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trackifapi.modal.dto.UserDefaultDto;
import org.trackifapi.modal.dto.UsuarioChildDto;
import org.trackifapi.services.Child.CreateUserChild;
import org.trackifapi.services.Child.ListUserChild;
import org.trackifapi.services.User.ListUserDefault;
import org.trackifapi.services.UserDefault.CreateUserDefault;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final CreateUserChild createUserChild;
    private final CreateUserDefault createUserDefault;
    private final ListUserChild listUserChild;
    private final ListUserDefault listUserDefault;

    public UsuarioController(CreateUserChild createUserChild, CreateUserDefault createUserDefault, ListUserChild listUserChild, ListUserDefault listUserDefault) {
        this.createUserChild = createUserChild;
        this.createUserDefault = createUserDefault;
        this.listUserChild = listUserChild;
        this.listUserDefault = listUserDefault;
    }

    @GetMapping("/default")
    public ResponseEntity<List<UserDefaultDto>> getUsuarioDefault() {
        List<UserDefaultDto> user = listUserDefault.listUserDefault();
        return ResponseEntity.ok(user);
    }

    @PostMapping("/default/add")
    public ResponseEntity<?> createDefaultUser(@RequestBody UserDefaultDto dto) {
        return createUserDefault.createDefaultUser(dto);
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
