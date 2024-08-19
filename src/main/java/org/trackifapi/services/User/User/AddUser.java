package org.trackifapi.services.User.User;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.trackifapi.enums.StatusEnum;
import org.trackifapi.modal.dto.UserDataDto;
import org.trackifapi.modal.entity.UserData;
import org.trackifapi.modal.repository.UserRepository;
import org.trackifapi.services.pattern.ExistingField.ExistingFieldUser;
import org.trackifapi.services.pattern.ExistingField.RegexFieldUser;

import java.time.LocalDateTime;

@Service
public class AddUser {

    private final UserRepository userRepository;
    private final ExistingFieldUser existingFieldUser;
    private final RegexFieldUser regexFieldUser;

    public AddUser(UserRepository userRepository, ExistingFieldUser existingFieldUser, RegexFieldUser regexFieldUser) {
        this.userRepository = userRepository;
        this.existingFieldUser = existingFieldUser;
        this.regexFieldUser = regexFieldUser;
    }

    public ResponseEntity<String> addUser(UserDataDto userDataDto) {
        try {
            toCheckField(userDataDto);

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

    private void toCheckField(UserDataDto userDataDto) {
        if (!regexFieldUser.isValidCpf(userDataDto.getCpf())){
            throw new RuntimeException("CPF inválido. Deve conter 11 digitos");
        }

        if (!regexFieldUser.isValidRg(userDataDto.getRg())){
            throw new RuntimeException("RG inválido. Deve conter 9 digitos");
        }


        // Verificando se os valores já existem antes de serem inseridos
        existingFieldUser.toCheckColumnExists(userDataDto.getCpf());
        existingFieldUser.toCheckColumnExists(userDataDto.getRg());
        existingFieldUser.toCheckColumnExists(userDataDto.getEmail());

    }
}
