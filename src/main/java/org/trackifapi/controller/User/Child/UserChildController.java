package org.trackifapi.controller.User.Child;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trackifapi.modal.dto.TokenModalChildDto;
import org.trackifapi.modal.dto.UserChildDto;
import org.trackifapi.services.User.Child.AdduserChild;
import org.trackifapi.services.User.Child.Token.AddToken;

@RestController
@RequestMapping("/api/user-child")
public class UserChildController {
    private final AdduserChild adduserChild;
    private final AddToken addToken;

    public UserChildController(AdduserChild adduserChild, AddToken addToken) {
        this.adduserChild = adduserChild;
        this.addToken = addToken;
    }

    // adicionando token do user child
    @PostMapping("/add-token")
    public ResponseEntity<?> addTokenUserChild(
            @RequestBody TokenModalChildDto tokenModalChildDto,
            @RequestParam double lat,
            @RequestParam double lng)
    {
        return addToken.addToken(tokenModalChildDto, lat, lng);
    }


    // Adicionando user child
    @PostMapping("/add/user-child")
    public ResponseEntity<?> addUserChild(@RequestBody UserChildDto userChildDto){
        return adduserChild.addUserChild(userChildDto);
    }

    /*
    * Vai verificar se o endereço ainda é o mesmo, caso o endereço mude, essa rota irá fazer a atualização dele
    * */
    @GetMapping("/update/address/")
    public ResponseEntity<?> updateAddress(){
        return ResponseEntity.ok().body("Endereço atualizado");
    }
}
