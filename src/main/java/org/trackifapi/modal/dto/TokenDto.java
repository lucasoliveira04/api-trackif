package org.trackifapi.modal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.trackifapi.modal.entity.Child.TokenChild;

import java.time.LocalDateTime;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenDto {
    private Integer id;
    private String token;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataExpiration;
    private UsuarioChildDto usuarioChildDto;
    private Integer userId;

    public static TokenDto fromEntity(TokenChild tokenChild) {
        TokenDto tokenDto = new TokenDto();
        tokenDto.setId(tokenChild.getId());
        tokenDto.setToken(tokenChild.getToken());
        tokenDto.setDataCriacao(tokenChild.getDataCriacao());
        tokenDto.setDataExpiration(tokenChild.getDataExpiration());
        tokenDto.setUsuarioChildDto(UsuarioChildDto.fromEntity(tokenChild.getUsuario()));
        return tokenDto;
    }
}