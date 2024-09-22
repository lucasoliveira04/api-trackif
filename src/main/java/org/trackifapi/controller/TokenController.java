package org.trackifapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trackifapi.modal.entity.dto.TokenDto;
import org.trackifapi.modal.entity.Child.TokenChild;
import org.trackifapi.services.Token.TokenServicesImpl;

@RestController
@RequestMapping("/api/token")
public class TokenController {
    private final TokenServicesImpl tokenServicesImpl;

    public TokenController(TokenServicesImpl tokenServicesImpl) {
        this.tokenServicesImpl = tokenServicesImpl;
    }

    @PostMapping("/add")
    public ResponseEntity<TokenChild> addToken(@RequestBody TokenDto tokenDto) {
        TokenChild tokenChild = tokenServicesImpl.addToken(tokenDto, tokenDto.getUserId());
        return ResponseEntity.ok(tokenChild);
    }
}
