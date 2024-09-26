package org.trackifapi.modal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EnderecoDto {
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public static EnderecoDto fromEntity(EnderecoDto entity) {
        EnderecoDto dto = new EnderecoDto();
        dto.setRua(entity.getRua());
        dto.setBairro(entity.getBairro());
        dto.setCidade(entity.getCidade());
        dto.setEstado(entity.getEstado());
        dto.setCep(entity.getCep());
        return dto;
    }
}
