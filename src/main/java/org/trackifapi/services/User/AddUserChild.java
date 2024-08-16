package org.trackifapi.services.User;

import org.springframework.stereotype.Service;
import org.trackifapi.modal.dto.UserChildDto;
import org.trackifapi.modal.entity.UserChild;
import org.trackifapi.modal.entity.UserData;
import org.trackifapi.modal.repository.UserChildRepository;
import org.trackifapi.modal.repository.UserRepository;

@Service
public class AddUserChild {
    private final UserChildRepository userChildRepository;
    private final UserRepository userRepository;

    public AddUserChild(UserChildRepository userChildRepository, UserRepository userRepository) {
        this.userChildRepository = userChildRepository;
        this.userRepository = userRepository;
    }

    public String addUserChild(UserChildDto userChildDto) {
        UserData userData = userRepository.findById(userChildDto.userData().id()).orElse(null);
        if (userData == null) {
            return "user not found";
        }

        UserChild userChild = new UserChild();
        userChild.setToken(userChildDto.token());
        userChild.setUserData(userData);
        userChildRepository.save(userChild);

        return "UserChild adicionado com sucesso!";
    }
}
