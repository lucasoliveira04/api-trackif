package org.trackifapi.modal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.trackifapi.enums.StatusEnum;
import org.trackifapi.modal.entity.UserData;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDataDto implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private String telephone;
    private String cpf;
    private String rg;
    private String role;
    private StatusEnum status;
    private LocalDateTime createdAt;

    public static UserDataDto fromEntity(UserData userData){
        return UserDataDto.builder()
                .id(userData.getId())
                .name(userData.getName())
                .email(userData.getEmail())
                .telephone(userData.getTelephone())
                .cpf(userData.getCpf())
                .rg(userData.getRg())
                .role(userData.getRole())
                .status(userData.getStatus())
                .createdAt(userData.getCreatedAt())
                .build();
    }

}