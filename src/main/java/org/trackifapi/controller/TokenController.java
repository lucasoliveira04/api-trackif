package org.trackifapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trackifapi.modal.Repository.UserChildModalRepository;
import org.trackifapi.modal.dto.UserDto;
import org.trackifapi.services.token.TokenCrudImpl;

import java.util.List;

@RestController
@RequestMapping("/api/token")
public class TokenController {

    private final TokenCrudImpl generateToken;
    private final UserChildModalRepository userChildModalRepository;

    public TokenController(TokenCrudImpl generateToken, UserChildModalRepository userChildModalRepository) {
        this.generateToken = generateToken;
        this.userChildModalRepository = userChildModalRepository;
    }

    @GetMapping("/decode")
    public ResponseEntity<?> decodeToken(@RequestBody UserDto idDto) {
        Integer id = idDto.getId();

        return userChildModalRepository.findById(id)
                .map(userChild -> {
                    String userToken = userChild.getToken().getToken();
                    List<String> decodedToken = generateToken.decodeToken(userToken);
                    return ResponseEntity.ok(decodedToken);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
