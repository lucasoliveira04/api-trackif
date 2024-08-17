package org.trackifapi.controller.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trackifapi.modal.dto.TokenModalChildDto;
import org.trackifapi.modal.dto.UserChildDto;
import org.trackifapi.modal.dto.UserDataDto;
import org.trackifapi.services.User.ListAllUsers;

import java.util.List;

@RestController
@RequestMapping("/api/list/users")
public class ViewUsers {

    private final ListAllUsers listAllUsers;

    public ViewUsers(ListAllUsers listAllUsers) {
        this.listAllUsers = listAllUsers;
    }

    @GetMapping("/user")
    public List<UserDataDto> getAllUserData(){
        return listAllUsers.getListAllUsers();
    }

    @GetMapping("/user-child")
    public List<UserChildDto> getAllUserChildData(){
        return listAllUsers.getListAllUserChildren();
    }

    @GetMapping("/token-child")
    public List<TokenModalChildDto> getAllUserChildTokenData(){
        return listAllUsers.getListAllTokenModalChilds();
    }
}
