package org.trackifapi.services.AddedUser;

import org.springframework.stereotype.Service;
import org.trackifapi.Enum.RoleEnum;
import org.trackifapi.modal.Repository.TokenModalRepository;
import org.trackifapi.modal.Repository.UserChildModalRepository;
import org.trackifapi.modal.dto.UserDto;
import org.trackifapi.modal.entity.child.UserChildModal;
import org.trackifapi.modal.entity.token.TokenModal;
import org.trackifapi.services.interfaces.IUserService;
import org.trackifapi.services.token.GenerateToken;

@Service
public class AddUserChild implements IUserService {
    private final UserChildModalRepository userChildModalRepository;
    private final TokenModalRepository tokenModalRepository;

    public AddUserChild(UserChildModalRepository userChildModalRepository, TokenModalRepository tokenModalRepository) {
        this.userChildModalRepository = userChildModalRepository;
        this.tokenModalRepository = tokenModalRepository;
    }


    public void addUser(UserDto user) {
        UserChildModal userChildModal = new UserChildModal();
        TokenModal token = new TokenModal();
        GenerateToken generateToken = new GenerateToken();

        userChildModal.setName(user.getName());
        userChildModal.setEmail(user.getEmail());
        userChildModal.setPhone(user.getPhone());
        userChildModal.setRg(user.getRg());
        userChildModal.setCpf(user.getCpf());
        userChildModal.setAge(user.getAge());
        userChildModal.setDateBirth(user.getDateBirth());
        userChildModal.setGender(user.getGender());
        userChildModal.setRoleEnum(RoleEnum.USER_CHILD);

        String generatedToken = generateToken.generateToken(userChildModal.getRoleEnum(), userChildModal);
        token.setToken(generatedToken);
        token.setUserChild(userChildModal);

        userChildModal.setToken(token);



        userChildModalRepository.save(userChildModal);
        tokenModalRepository.save(token);
    }
}
