package org.trackifapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trackifapi.modal.dto.UserDto;
import org.trackifapi.services.AddedUser.AddUserChild;
import org.trackifapi.services.AddedUser.AddedUserFather;
import org.trackifapi.services.ListUser.ListUserServices;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final AddedUserFather addedUserFather;
    private final AddUserChild addUserChild;
    private final ListUserServices listuserServices;

    public UserController(AddedUserFather addedUserFather, AddUserChild addUserChild, ListUserServices listuserServices) {
        this.addedUserFather = addedUserFather;
        this.addUserChild = addUserChild;
        this.listuserServices = listuserServices;
    }

    @PostMapping("/add/father")
    public ResponseEntity<String> addFather(@RequestBody UserDto userDto) {
        try{
            addedUserFather.addUser(userDto);
            return ResponseEntity.ok("Father added successfully");
        } catch (IllegalArgumentException e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding father");
        } 
    }

    @PostMapping("/add/child")
    public ResponseEntity<String> addChild(@RequestBody UserDto userDto) {
        try{
            addUserChild.addUser(userDto);
            return ResponseEntity.ok("Child added successfully");
        } catch (IllegalArgumentException e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding child");
        }


    }

    @GetMapping("/list/fathers")
    public ResponseEntity<List<UserDto>> listFathers() {
        List<UserDto> fathers = listuserServices.listAllFather();
        return ResponseEntity.ok(fathers);
    }

    @GetMapping("/list/child")
    public ResponseEntity<List<UserDto>> listChild() {
        List<UserDto> children = listuserServices.listAllChildren();
        return ResponseEntity.ok(children);
    }
}
