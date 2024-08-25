package org.trackifapi.controller.Token;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.trackifapi.services.GenerateToken.GenerateTokenServices;

import java.util.Map;

@RestController
@RequestMapping("/token")
public class TokenController {
    private final GenerateTokenServices generateTokenServices;

    public TokenController(GenerateTokenServices generateTokenServices) {
        this.generateTokenServices = generateTokenServices;
    }
    
    // rota para gerar o token relacionado com o usuario filho
    @GetMapping("/generateToken")
    public String generateToken(@RequestParam double lat, @RequestParam double lng) {
        String addresss = generateTokenServices.getAddress(lat, lng);
        return generateTokenServices.createToken(addresss);
    }

    // decodifica o token
    @GetMapping("/decodeToken")
    public Map<String, Object> decodeToken(@RequestParam String token) {
        return generateTokenServices.decodeToken(token);
    }
}
