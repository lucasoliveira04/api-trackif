package org.trackifapi.modal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.trackifapi.modal.entity.UserChild.Token;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TokenDto implements Serializable {
    private Integer id;
    private String token;
    private LocalDateTime dataCriacao;
    private UsuarioChildDto usuarioChild;
    private Integer usuarioChildId;
    private String nome;

    public static TokenDto fromEntity(Token token) {
        return TokenDto.builder()
                .id(token.getId())
                .token(token.getToken())
                .dataCriacao(token.getDataCriacao())
                .usuarioChildId(token.getUsuarioChild() != null ? token.getUsuarioChild().getId() : null)
                .nome(token.getUsuarioChild() != null ? token.getUsuarioChild().getNome() : null)
                .build();
    }


}
