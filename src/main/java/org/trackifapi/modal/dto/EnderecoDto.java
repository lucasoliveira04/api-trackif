package org.trackifapi.modal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.trackifapi.modal.entity.EnderecoModal;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link org.trackifapi.modal.entity.EnderecoModal}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter

public class EnderecoDto implements Serializable {
    private UUID id;
    private String cep;
    private String endereco;
    private String numero;

    public static EnderecoDto fromEntity(EnderecoModal endereco) {
        EnderecoDto dto = new EnderecoDto();
        dto.setId(endereco.getId());
        dto.setCep(endereco.getCep());
        dto.setEndereco(endereco.getEndereco());
        dto.setNumero(endereco.getNumero());
        return dto;
    }
}