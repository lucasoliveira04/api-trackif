package org.trackifapi.modal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.trackifapi.modal.entity.EnderecoModal;
import org.trackifapi.modal.entity.UsuarioFilho;
import org.trackifapi.modal.entity.UsuarioMain;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link org.trackifapi.modal.entity.UsuarioFilho}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class UsuarioFilhoDto implements Serializable {
    private UUID id;
    private String role;
    private UsuarioMainDto usuarioMain;
    private List<EnderecoDto> enderecos;

    public static UsuarioFilhoDto fromEntity(UsuarioFilho filho){
        UsuarioFilhoDto dto = new UsuarioFilhoDto();
        dto.setId(filho.getId());
        dto.setRole(filho.getRole());
        dto.setUsuarioMain(UsuarioMainDto.fromEntity(filho.getUsuarioMain()));
        dto.setEnderecos(filho.getUsuarioMain().getEnderecos().stream().map(EnderecoDto::fromEntity).toList());
        return dto;
    }
}