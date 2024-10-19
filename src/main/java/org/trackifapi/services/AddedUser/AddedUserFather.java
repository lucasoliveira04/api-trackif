package org.trackifapi.services.AddedUser;

import org.springframework.stereotype.Service;
import org.trackifapi.mapper.UserMapper;
import org.trackifapi.modal.Repository.AddressModalRepository;
import org.trackifapi.modal.Repository.UserFatherModalRepository;
import org.trackifapi.modal.dto.UserDto;
import org.trackifapi.modal.entity.addres.AddressModal;
import org.trackifapi.modal.entity.father.UserFatherModal;
import org.trackifapi.services.interfaces.IUserService;

@Service
public class AddedUserFather implements IUserService {

    private final UserFatherModalRepository userFatherModalRepository;
    private final UserMapper userMapper;
    private final AddressModalRepository addressModalRepository;

    public AddedUserFather(UserFatherModalRepository userFatherModalRepository, UserMapper userMapper, AddressModalRepository addressModalRepository) {
        this.userFatherModalRepository = userFatherModalRepository;
        this.userMapper = userMapper;
        this.addressModalRepository = addressModalRepository;
    }

    @Override
    public void addUser(UserDto user) {
        try{
            userMapper.applyRegex(user);
            UserFatherModal userFatherModal = new UserFatherModal();
            UserMapper.mapDtoToUser(user, userFatherModal);
            AddressModal addressModal = UserMapper.mapAddressDtoToAddressModal(user.getAddressDto());
            userFatherModalRepository.save(userFatherModal);
            addressModalRepository.save(addressModal);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
