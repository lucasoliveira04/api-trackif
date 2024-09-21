package org.trackifapi;

import org.junit.jupiter.api.Test;
import org.trackifapi.modal.dto.UsuarioMainDto;
import org.trackifapi.modal.entity.EnderecoModal;
import org.trackifapi.modal.entity.UsuarioMain;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioMainDtoTest {

    @Test
    public void testFromEntity(){
        EnderecoModal endereco = new EnderecoModal();
        endereco.setId(UUID.randomUUID());
        endereco.setCep("12345678");
        endereco.setEndereco("Rua Teste");
        endereco.setNumero("123");

        UsuarioMain usuario = new UsuarioMain();
        usuario.setId(UUID.randomUUID());
        usuario.setName("Teste");
        usuario.setEmail("teste@example.com");
        usuario.setTelefone("123456789");
        usuario.setRg("12345678");
        usuario.setCpf("123.456.789-00");
        usuario.setData_nascimento(new Date());
        usuario.setCreated_at(LocalDateTime.now());
        usuario.setEnderecos(Collections.singletonList(endereco));

        UsuarioMainDto usuarioMainDto = UsuarioMainDto.fromEntity(usuario);

        assertEquals(usuario.getId(), usuarioMainDto.getId());
        assertEquals(usuario.getName(), usuarioMainDto.getName());
        assertEquals(usuario.getEmail(), usuarioMainDto.getEmail());
        assertEquals(usuario.getTelefone(), usuarioMainDto.getTelefone());
        assertEquals(usuario.getRg(), usuarioMainDto.getRg());
        assertEquals(usuario.getCpf(), usuarioMainDto.getCpf());
        assertEquals(usuario.getData_nascimento(), usuarioMainDto.getData_nascimento());
        assertEquals(usuario.getCreated_at(), usuarioMainDto.getCreated_at());
        assertEquals(usuario.getId(), usuarioMainDto.getId());
        assertEquals(usuario.getName(), usuarioMainDto.getName());
        assertEquals(usuario.getEmail(), usuarioMainDto.getEmail());
        assertEquals(usuario.getTelefone(), usuarioMainDto.getTelefone());
        assertEquals(usuario.getRg(), usuarioMainDto.getRg());
        assertEquals(usuario.getCpf(), usuarioMainDto.getCpf());
        assertEquals(usuario.getData_nascimento(), usuarioMainDto.getData_nascimento());
        assertEquals(usuario.getCreated_at(), usuarioMainDto.getCreated_at());
        assertEquals(1, usuarioMainDto.getEnderecos().size());
        assertEquals(endereco.getCep(), usuarioMainDto.getEnderecos().get(0).getCep());
        assertEquals(endereco.getEndereco(), usuarioMainDto.getEnderecos().get(0).getEndereco());
        assertEquals(endereco.getNumero(), usuarioMainDto.getEnderecos().get(0).getNumero());
    }
}
