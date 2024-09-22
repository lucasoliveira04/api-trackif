package org.trackifapi.modal.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.trackifapi.modal.entity.Child.UsuarioChild;

import java.time.LocalDateTime;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioChildDto {
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String rg;
    private LocalDateTime createdAt;
    private String rua;
    private EnderecoDto endereco;

    public static UsuarioChildDto fromEntity(UsuarioChild entity) {
        UsuarioChildDto dto = new UsuarioChildDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setTelefone(entity.getTelefone());
        dto.setCpf(entity.getCpf());
        dto.setRg(entity.getRg());
        dto.setRua(entity.getRua());
        dto.setCreatedAt(entity.getCreatedAt());

        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setEstado(entity.getEstado());
        enderecoDto.setCidade(entity.getCidade());
        enderecoDto.setBairro(entity.getBairro());
        enderecoDto.setCep(entity.getCep());
        enderecoDto.setRua(entity.getRua());
        dto.setEndereco(enderecoDto);

        return dto;
    }
}
