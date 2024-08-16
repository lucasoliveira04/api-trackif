package org.trackifapi.controller.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trackifapi.modal.dto.UserChildDto;
import org.trackifapi.modal.dto.UserDataDto;
import org.trackifapi.services.User.AddUser;
import org.trackifapi.services.User.AddUserChild;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    private final AddUser addUser;
    private final AddUserChild userChild;

    public UserController(AddUser addUser, AddUserChild userChild) {
        this.addUser = addUser;
        this.userChild = userChild;
    }

    // Adicionando Usuario
    @PostMapping("/add-user")
    public ResponseEntity<String> addUser(@RequestBody UserDataDto userDataDto,
                                     @RequestBody(required = false)UserChildDto userChildDto) {
        String result = addUser.addUser(userDataDto, userChildDto);
        return ResponseEntity.ok(result);
    }

    // Adicionando Usuario filho
    @PostMapping("/add-user-child")
    public ResponseEntity<String> addUserChild(@RequestBody UserChildDto userChildDto) {
        String result = userChild.addUserChild(userChildDto);
        return ResponseEntity.ok(result);
    }
}
