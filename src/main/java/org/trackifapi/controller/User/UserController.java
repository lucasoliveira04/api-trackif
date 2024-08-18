package org.trackifapi.controller.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trackifapi.modal.dto.UserDataDto;
import org.trackifapi.services.User.User.AddUser;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final AddUser addUser;

    public UserController(AddUser addUser) {
        this.addUser = addUser;
    }

    @PostMapping("/add/user")
    public ResponseEntity<?> adduser(@RequestBody UserDataDto userDataDto){
        return addUser.addUser(userDataDto);
    }
}
