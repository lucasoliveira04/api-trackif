package org.trackifapi.modal.dto;

import org.trackifapi.modal.entity.UserChild;

public record UserChildDto(
        Integer id,
        String token,
        UserDataDto userData
) {
    public static UserChildDto toDTO(UserChild userChild) {
        return new UserChildDto(
                userChild.getId(),
                userChild.getToken(),
                UserDataDto.toDTO(userChild.getUserData())
        );
    }
}
