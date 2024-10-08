package org.trackifapi.services.AddedUser;

import org.springframework.stereotype.Service;
import org.trackifapi.Enum.RoleEnum;
import org.trackifapi.mapper.UserMapper;
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
    private final GenerateToken generateToken;
    private final UserMapper userMapper;

    public AddUserChild(UserChildModalRepository userChildModalRepository, TokenModalRepository tokenModalRepository, GenerateToken generateToken, org.trackifapi.mapper.UserMapper userMapper) {
        this.userChildModalRepository = userChildModalRepository;
        this.tokenModalRepository = tokenModalRepository;
        this.generateToken = generateToken;
        this.userMapper = userMapper;
    }

    public void addUser(UserDto user) {
        try{
            UserChildModal userChildModal = new UserChildModal();

            userMapper.applyRegex(user);

            UserMapper.mapDtoToUser(user, userChildModal);

            userChildModal.setRoleEnum(RoleEnum.USER_CHILD);

            TokenModal tokenModal = new TokenModal();
            String generatedToken = generateToken.generateToken(userChildModal.getRoleEnum(), userChildModal);

            tokenModal.setToken(generatedToken);
            tokenModal.setUserChild(userChildModal);
            userChildModal.setToken(tokenModal);

            userChildModalRepository.save(userChildModal);
            tokenModalRepository.save(tokenModal);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
