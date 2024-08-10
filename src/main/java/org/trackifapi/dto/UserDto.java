package org.trackifapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.trackifapi.modal.User;

import java.io.Serializable;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto implements Serializable {
    Integer id;
    String name;
    String email;
    String cpf;
    String rg;
    String telefone;

    public static UserDto fromUser(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .cpf(user.getCpf())
                .rg(user.getRg())
                .email(user.getEmail())
                .telefone(user.getTelefone())
                .build();
    }
}