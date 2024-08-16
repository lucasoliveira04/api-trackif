package org.trackifapi.modal.dto;

import org.trackifapi.enums.StatusEnum;
import org.trackifapi.modal.entity.UserData;

import java.time.LocalDateTime;

public record UserDataDto(
        Integer id,
        String name,
        String email,
        String cpf,
        String rg,
        String role,
        StatusEnum status,
        LocalDateTime createdAt
) {
    public static UserDataDto toDTO(UserData userData) {
        return new UserDataDto(
                userData.getId(),
                userData.getName(),
                userData.getEmail(),
                userData.getCpf(),
                userData.getRg(),
                userData.getRole(),
                userData.getStatus(),
                userData.getCreatedAt()
        );
    }
}
