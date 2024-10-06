package org.trackifapi.services.AddedUser;

import org.springframework.stereotype.Service;
import org.trackifapi.mapper.UserMapper;
import org.trackifapi.modal.Repository.UserFatherModalRepository;
import org.trackifapi.modal.dto.UserDto;
import org.trackifapi.modal.entity.father.UserFatherModal;
import org.trackifapi.services.interfaces.IUserService;

@Service
public class AddedUserFather implements IUserService {

    private final UserFatherModalRepository userFatherModalRepository;
    private final UserMapper userMapper;

    public AddedUserFather(UserFatherModalRepository userFatherModalRepository, UserMapper userMapper) {
        this.userFatherModalRepository = userFatherModalRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void addUser(UserDto user) {
        UserFatherModal userFatherModal = new UserFatherModal();
        UserMapper.mapDtoToUser(user, userFatherModal);
        userFatherModalRepository.save(userFatherModal);
    }
}
