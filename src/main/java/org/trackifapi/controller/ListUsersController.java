package org.trackifapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trackifapi.dto.UserChildDto;
import org.trackifapi.dto.UserDto;
import org.trackifapi.services.ListUsersServices;

import java.util.List;

@RestController
@RequestMapping("/list/")
public class ListUsersController {
    private final ListUsersServices listUsersServices;

    public ListUsersController(ListUsersServices listUsersServices) {
        this.listUsersServices = listUsersServices;
    }

    @GetMapping("/user-main")
    private ResponseEntity<?> getAllUser() {
        List<UserDto> users = listUsersServices.getAllDataUser();

        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Tabela de usuários principal está vazia.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/user-child")
    private ResponseEntity<?> getAllUserChild() {
        List<UserChildDto> users = listUsersServices.getAllDataUserChild();

        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Tabela de usuários filhos está vazia.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
