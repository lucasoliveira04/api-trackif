package org.trackifapi.services.User.Child;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.trackifapi.modal.dto.UserChildDto;
import org.trackifapi.modal.dto.UserDataDto;
import org.trackifapi.modal.entity.UserChild;
import org.trackifapi.modal.entity.UserData;
import org.trackifapi.modal.repository.UserChildRepository;
import org.trackifapi.modal.repository.UserRepository;

import java.time.LocalDateTime;

@Service
public class AdduserChild {

    private final UserChildRepository userChildRepository;
    private final UserRepository userRepository;

    public AdduserChild(UserChildRepository userChildRepository,
                        UserRepository userRepository) {
        this.userChildRepository = userChildRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> addUserChild(UserChildDto userChildDto) {
        try{
            UserChild userChild = getUserChild(userChildDto);
            userChildRepository.save(userChild);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    private UserChild getUserChild(UserChildDto userChildDto) {
        UserChild userChild = new UserChild();

        UserData userData;
        if (userChildDto.getId() != null) {
            userData = userRepository.findById(userChildDto.getId())
                    .orElseThrow(() -> new RuntimeException("UserData não encontrado"));
        } else {
            userData = convertDtoToUserData(userChildDto.getUserData());
        }
        userData.setRole("user_child");

        userChild.setUserData(userData);

        return userChild;
    }


    private UserData convertDtoToUserData(UserDataDto userDataDto) {
        UserData userData = new UserData();
        userData.setName(userDataDto.getName());
        userData.setEmail(userDataDto.getEmail());
        userData.setCpf(userDataDto.getCpf());
        userData.setRg(userDataDto.getRg());
        userData.setRole("user_child");
        userData.setStatus(userDataDto.getStatus());
        userData.setCreatedAt(LocalDateTime.now());

        return userData;
    }
}
