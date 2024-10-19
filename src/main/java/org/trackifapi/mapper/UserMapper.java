package org.trackifapi.mapper;

import org.springframework.stereotype.Component;
import org.trackifapi.modal.dto.AddressDto;
import org.trackifapi.modal.dto.UserDto;
import org.trackifapi.modal.entity.addres.AddressModal;
import org.trackifapi.modal.interfaces.IUser;
import org.trackifapi.regex.ApplyRegex;
import org.trackifapi.regex.HashMapRegex;

/**
 * Mapper que mapeia um DTO para um usuário.
 */
@Component
public class UserMapper {
    private final HashMapRegex hashMapRegex;
    private final ApplyRegex regex;

    public UserMapper(HashMapRegex hashMapRegex, ApplyRegex regex) {
        this.hashMapRegex = hashMapRegex;
        this.regex = regex;
    }

    /**
     * Mapeia um DTO de usuário para uma entidade de usuário.
     *
     * @param <T>     O tipo de usuário que implementa a interface {@link IUser}
     * @param userDto O DTO do usuário a ser mapeado
     * @param entity  A entidade de usuário a ser preenchida com os dados do DTO
     */
    public static <T extends IUser> T mapDtoToUser(UserDto userDto, T entity) {
        entity.setName(userDto.getName());
        entity.setEmail(userDto.getEmail());
        entity.setPhone(userDto.getPhone());
        entity.setRg(userDto.getRg());
        entity.setCpf(userDto.getCpf());
        entity.setAge(userDto.getAge());
        entity.setDateBirth(userDto.getDateBirth());
        entity.setGender(userDto.getGender());
        return entity;
    }

    public static AddressModal mapAddressDtoToAddressModal(AddressDto addressDto) {
        AddressModal addressModal = new AddressModal();
        addressModal.setCity(addressDto.getCity());
        addressModal.setCountry(addressDto.getCountry());
        addressModal.setStreet(addressDto.getStreet());
        addressModal.setCep(addressDto.getCep());
        addressModal.setNumber(addressDto.getNumber());
        addressModal.setNeighborhood(addressDto.getNeighborhood());
        addressModal.setState(addressDto.getState());
        return addressModal;
    }

    public void applyRegex(UserDto userDto) {
        regex.applyRegex(userDto);
    }

}

