package org.trackifapi.services.User;

import org.springframework.stereotype.Service;
import org.trackifapi.enums.StatusEnum;
import org.trackifapi.modal.dto.UserChildDto;
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

    public String addUser(UserDataDto userDataDto, UserChildDto userChildDto) {
        UserData userData = new UserData();
        userData.setName(userDataDto.name());
        userData.setEmail(userDataDto.email());
        userData.setCpf(userDataDto.cpf());
        userData.setRg(userDataDto.rg());
        userData.setStatus(StatusEnum.ATIVO);
        userData.setCreatedAt(LocalDateTime.now());
        userData.setRole(userDataDto.role());

        userRepository.save(userData);

        return "User adicionado com sucesso";
    }

}
