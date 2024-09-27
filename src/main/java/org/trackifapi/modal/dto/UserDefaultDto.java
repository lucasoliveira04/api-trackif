package org.trackifapi.modal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.trackifapi.Enums.RolesEnum;
import org.trackifapi.modal.entity.UserDefault.UserDefault;

import java.time.LocalDateTime;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDefaultDto {
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String rg;
    private LocalDateTime createdAt;
    private EnderecoDto endereco;
    private RolesEnum roles;

    public static UserDefaultDto fromEntity(UserDefault entity) {
        if (entity.getNome() == null || entity.getEmail() == null ||
                entity.getCpf() == null || entity.getRg() == null ||
                entity.getCep() == null) {
            return null;
        }


        UserDefaultDto dto = new UserDefaultDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setTelefone(entity.getTelefone());
        dto.setCpf(entity.getCpf());
        dto.setRg(entity.getRg());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setRoles(entity.getRoles());

        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setCep(entity.getCep());
        enderecoDto.setCidade(entity.getCidade());
        enderecoDto.setEstado(entity.getEstado());
        enderecoDto.setRua(entity.getRua());
        enderecoDto.setBairro(entity.getBairro());
        dto.setEndereco(enderecoDto);

        return dto;
    }
}
