package org.trackifapi.modal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.trackifapi.modal.entity.UsuarioMain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * DTO for {@link org.trackifapi.modal.entity.UsuarioMain}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class UsuarioMainDto implements Serializable {
    private UUID id;
    private String name;
    private String email;
    private String telefone;
    private String rg;
    private String cpf;
    private Date data_nascimento;
    private LocalDateTime created_at;
    private List<EnderecoDto> enderecos;

    public static UsuarioMainDto fromEntity(UsuarioMain usuario) {
        UsuarioMainDto dto = new UsuarioMainDto();
        dto.setId(usuario.getId());
        dto.setName(usuario.getName());
        dto.setEmail(usuario.getEmail());
        dto.setTelefone(usuario.getTelefone());
        dto.setRg(usuario.getRg());
        dto.setCpf(usuario.getCpf());
        dto.setData_nascimento(usuario.getData_nascimento());
        dto.setCreated_at(usuario.getCreated_at());
        dto.setEnderecos(usuario.getEnderecos().stream().map(EnderecoDto::fromEntity).collect(Collectors.toList()));
        return dto;
    }

}