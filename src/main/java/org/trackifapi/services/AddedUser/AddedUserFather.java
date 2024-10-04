package org.trackifapi.services.AddedUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trackifapi.Enum.RoleEnum;
import org.trackifapi.modal.Repository.UserFatherModalRepository;
import org.trackifapi.modal.dto.UserDto;
import org.trackifapi.modal.entity.father.UserFatherModal;
import org.trackifapi.services.interfaces.IUserService;

@Service
public class AddedUserFather implements IUserService {

    @Autowired
    private UserFatherModalRepository userFatherModalRepository;

    @Override
    public void addUser(UserDto user) {
        UserFatherModal userFatherModal = new UserFatherModal();
        userFatherModal.setName(user.getName());
        userFatherModal.setEmail(user.getEmail());
        userFatherModal.setPhone(user.getPhone());
        userFatherModal.setRg(user.getRg());
        userFatherModal.setCpf(user.getCpf());
        userFatherModal.setAge(user.getAge());
        userFatherModal.setDateBirth(user.getDateBirth());
        userFatherModal.setGender(user.getGender());
        userFatherModal.setRoleEnum(RoleEnum.USER_FATHER);
        userFatherModalRepository.save(userFatherModal);
    }
}
