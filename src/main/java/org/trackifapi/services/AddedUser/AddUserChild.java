package org.trackifapi.services.AddedUser;

import org.springframework.stereotype.Service;
import org.trackifapi.Enum.RoleEnum;
import org.trackifapi.mapper.UserMapper;
import org.trackifapi.modal.Repository.AddressModalRepository;
import org.trackifapi.modal.Repository.TokenModalRepository;
import org.trackifapi.modal.Repository.UserChildModalRepository;
import org.trackifapi.modal.dto.UserDto;
import org.trackifapi.modal.entity.addres.AddressModal;
import org.trackifapi.modal.entity.child.UserChildModal;
import org.trackifapi.modal.entity.token.TokenModal;
import org.trackifapi.services.interfaces.IUserService;
import org.trackifapi.services.token.TokenCrudImpl;

@Service
public class AddUserChild implements IUserService {
    private final UserChildModalRepository userChildModalRepository;
    private final TokenModalRepository tokenModalRepository;
    private final TokenCrudImpl generateToken;
    private final UserMapper userMapper;
    private final AddressModalRepository addressModalRepository;

    public AddUserChild(UserChildModalRepository userChildModalRepository, TokenModalRepository tokenModalRepository, TokenCrudImpl generateToken, org.trackifapi.mapper.UserMapper userMapper, AddressModalRepository addressModalRepository) {
        this.userChildModalRepository = userChildModalRepository;
        this.tokenModalRepository = tokenModalRepository;
        this.generateToken = generateToken;
        this.userMapper = userMapper;
        this.addressModalRepository = addressModalRepository;
    }

    public void addUser(UserDto user) {
        try{
            UserChildModal userChildModal = new UserChildModal();

            userMapper.applyRegex(user);

            UserMapper.mapDtoToUser(user, userChildModal);

            userChildModal.setRoleEnum(RoleEnum.USER_CHILD);

            AddressModal addressModal = new AddressModal();
            if (user.getAddressDto() != null){
                addressModal = UserMapper.mapAddressDtoToAddressModal(user.getAddressDto());
                addressModal.setUserChild(userChildModal);
            }

            TokenModal tokenModal = new TokenModal();
            String generatedToken = generateToken.createToken(userChildModal.getRoleEnum(), userChildModal);
            tokenModal.setToken(generatedToken);
            tokenModal.setUserChild(userChildModal);

            userChildModal.setToken(tokenModal);
            userChildModal.setAddress(addressModal);

            userChildModalRepository.save(userChildModal);
            tokenModalRepository.save(tokenModal);
            addressModalRepository.save(addressModal);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
