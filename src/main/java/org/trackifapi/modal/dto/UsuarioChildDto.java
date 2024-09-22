package org.trackifapi.modal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.trackifapi.modal.entity.UserChild.UsuarioChild;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioChildDto implements Serializable {
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private TokenDto token;
    private LocalDateTime created_at;


    public static UsuarioChildDto fromEntity(UsuarioChild usuarioChild) {
        if (usuarioChild == null) {
            return null;
        }
        UsuarioChildDto dto = new UsuarioChildDto();
        dto.setId(usuarioChild.getId());
        dto.setNome(usuarioChild.getNome());
        dto.setEmail(usuarioChild.getEmail());
        dto.setTelefone(usuarioChild.getTelefone());
        dto.setCpf(usuarioChild.getCpf());
        dto.setRg(usuarioChild.getRg());
        dto.setDataNascimento(usuarioChild.getDataNascimento());
        dto.setCreated_at(LocalDateTime.now());
        return dto;
    }

}
