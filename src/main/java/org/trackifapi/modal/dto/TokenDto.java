package org.trackifapi.modal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.trackifapi.modal.entity.token.TokenModal;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class TokenDto implements Serializable {
    private Integer id;
    private String token;

    public static TokenDto fromEntity(TokenModal token) {
        TokenDto tokenDto = new TokenDto();
        tokenDto.setId(token.getId());
        tokenDto.setToken(token.getToken());
        return tokenDto;
    }
}
