package org.trackifapi.mapper;

import org.springframework.stereotype.Component;
import org.trackifapi.modal.dto.UserDto;
import org.trackifapi.modal.interfaces.IUser;

/**
 * Mapper que mapeia um DTO para um usuário.
 */
@Component
public class UserMapper {
    /**
     * Mapeia um DTO de usuário para uma entidade de usuário.
     *
     * @param <T>     O tipo de usuário que implementa a interface {@link IUser}
     * @param userDto O DTO do usuário a ser mapeado
     * @param entity  A entidade de usuário a ser preenchida com os dados do DTO
     */
    public static <T extends IUser> T mapDtoToUser(UserDto userDto, T entity){
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
}
