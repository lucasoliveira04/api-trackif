package org.trackifapi.services.User.User;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.trackifapi.enums.StatusEnum;
import org.trackifapi.modal.dto.UserDataDto;
import org.trackifapi.modal.entity.UserData;
import org.trackifapi.modal.repository.UserRepository;

import java.time.LocalDateTime;

@Service
public class AddUser {

    private final UserRepository userRepository;

    public AddUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> addUser(UserDataDto userDataDto) {
        try {
            UserData userData = getUserData(userDataDto);
            userRepository.save(userData);
            return ResponseEntity.ok().body("Usuario registrado com sucesso!");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private UserData getUserData(UserDataDto userDataDto) {
        UserData userData = new UserData();
        userData.setName(userDataDto.getName());
        userData.setEmail(userDataDto.getEmail());
        userData.setRg(userDataDto.getRg());
        userData.setCpf(userDataDto.getCpf());
        userData.setCreatedAt(LocalDateTime.now());
        userData.setStatus(StatusEnum.ATIVO);
        userData.setRole(userDataDto.getRole());
        userData.setTelephone(userData.getTelephone());
        return userData;
    }
}
