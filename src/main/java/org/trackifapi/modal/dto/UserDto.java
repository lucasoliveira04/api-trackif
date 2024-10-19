package org.trackifapi.modal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.trackifapi.Enum.RoleEnum;
import org.trackifapi.modal.entity.addres.AddressModal;
import org.trackifapi.modal.entity.child.UserChildModal;
import org.trackifapi.modal.entity.father.UserFatherModal;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * DTO for {@link UserFatherModal}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class UserDto implements Serializable {
    private Integer id;
    private String name;
    private String rg;
    private String cpf;
    private int age;
    private String email;
    private String phone;
    private Date dateBirth;
    private String gender;
    private RoleEnum roleEnum;
    private LocalDateTime createdAt;

    private TokenDto token;
    private AddressDto addressDto;

    /**
     * fromEntity para usuario pai
     * */
    public static UserDto fromEntityFather(UserFatherModal userFatherModal) {
        UserDto userDto = new UserDto();
        userDto.setId(userFatherModal.getId());
        userDto.setName(userFatherModal.getName());
        userDto.setRg(userFatherModal.getRg());
        userDto.setCpf(userFatherModal.getCpf());
        userDto.setAge(userFatherModal.getAge());
        userDto.setEmail(userFatherModal.getEmail());
        userDto.setPhone(userFatherModal.getPhone());
        userDto.setDateBirth(userFatherModal.getDateBirth());
        userDto.setGender(userFatherModal.getGender());
        userDto.setRoleEnum(userFatherModal.getRoleEnum());
        userDto.setCreatedAt(userFatherModal.getCreatedAt());

        if (userFatherModal.getAddress() != null){
            userDto.setAddressDto(AddressDto.fromEntity(userFatherModal.getAddress()));
        }

        return userDto;
    }


    /**
    * fromEntity para usuario filho
    * */
    public static UserDto fromEntity(UserChildModal userChildModal) {
        UserDto userDto = new UserDto();
        userDto.setId(userChildModal.getId());
        userDto.setName(userChildModal.getName());
        userDto.setRg(userChildModal.getRg());
        userDto.setCpf(userChildModal.getCpf());
        userDto.setAge(userChildModal.getAge());
        userDto.setEmail(userChildModal.getEmail());
        userDto.setPhone(userChildModal.getPhone());
        userDto.setDateBirth(userChildModal.getDateBirth());
        userDto.setGender(userChildModal.getGender());
        userDto.setRoleEnum(userChildModal.getRoleEnum());
        userDto.setCreatedAt(userChildModal.getCreatedAt());

        if (userChildModal.getToken() != null) {
            userDto.setToken(TokenDto.fromEntity(userChildModal.getToken()));
        }

        if (userChildModal.getAddress() != null){
            userDto.setAddressDto(AddressDto.fromEntity(userChildModal.getAddress()));
        }

        return userDto;
    }
}