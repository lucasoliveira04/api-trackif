package org.trackifapi.controller.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trackifapi.modal.dto.UserChildDto;
import org.trackifapi.modal.dto.UserDataDto;
import org.trackifapi.services.User.Child.AdduserChild;
import org.trackifapi.services.User.User.AddUser;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final AddUser addUser;
    private final AdduserChild adduserChild;

    public UserController(AddUser addUser, AdduserChild adduserChild) {
        this.addUser = addUser;
        this.adduserChild = adduserChild;
    }

    @PostMapping("/add/user")
    public ResponseEntity<?> adduser(@RequestBody UserDataDto userDataDto){
        return addUser.addUser(userDataDto);
    }

    @PostMapping("/add/user-child")
    public ResponseEntity<?> addUserChild(@RequestBody UserChildDto userChildDto){
        return adduserChild.addUserChild(userChildDto);
    }
}
