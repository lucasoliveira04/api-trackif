package org.trackifapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import org.trackifapi.modal.UserChildModal;

import java.io.Serializable;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserChildDto implements Serializable {
    Integer id;
    String name;
    String email;
    String cpf;
    String rg;
    String telefone;
    String token;

    public static UserChildDto fromEntityUserChildDto(UserChildModal userChildModal){
        return UserChildDto.builder()
                .id(userChildModal.getId())
                .name(userChildModal.getName())
                .cpf(userChildModal.getCpf())
                .rg(userChildModal.getRg())
                .email(userChildModal.getEmail())
                .telefone(userChildModal.getTelefone())
                .token(userChildModal.getToken())
                .build();
    }
}