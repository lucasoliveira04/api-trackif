package org.trackifapi;

import org.junit.jupiter.api.Test;
import org.trackifapi.modal.dto.UsuarioFilhoDto;
import org.trackifapi.modal.entity.EnderecoModal;
import org.trackifapi.modal.entity.UsuarioFilho;
import org.trackifapi.modal.entity.UsuarioMain;

import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioFilhoDtoTest {
    @Test
    public void testFromEntity(){
        EnderecoModal endereco = new EnderecoModal();
        endereco.setId(UUID.randomUUID());
        endereco.setCep("12345678");
        endereco.setEndereco("Rua Teste");
        endereco.setNumero("123");

        UsuarioMain usuarioMain = new UsuarioMain();
        usuarioMain.setId(UUID.randomUUID());
        usuarioMain.setName("Teste Main");
        usuarioMain.setEmail("main@example.com");
        usuarioMain.setCpf("12345678901");
        usuarioMain.setRg("123456789");
        usuarioMain.setTelefone("123456789");
        usuarioMain.setEnderecos(Collections.singletonList(endereco));

        UsuarioFilho filho = new UsuarioFilho();
        filho.setId(UUID.randomUUID());
        filho.setRole("Filho Teste");
        filho.setUsuarioMain(usuarioMain);

        UsuarioFilhoDto dto = UsuarioFilhoDto.fromEntity(filho);

        assertEquals(filho.getId(), dto.getId());
        assertEquals(filho.getRole(), dto.getRole());
        assertEquals(usuarioMain.getId(), dto.getUsuarioMain().getId());
        assertEquals(usuarioMain.getName(), dto.getUsuarioMain().getName());
        assertEquals(usuarioMain.getEmail(), dto.getUsuarioMain().getEmail());
        assertEquals(usuarioMain.getCpf(), dto.getUsuarioMain().getCpf());
        assertEquals(usuarioMain.getRg(), dto.getUsuarioMain().getRg());
        assertEquals(usuarioMain.getTelefone(), dto.getUsuarioMain().getTelefone());
        assertEquals(1, dto.getEnderecos().size());
        assertEquals(endereco.getCep(), dto.getEnderecos().get(0).getCep());
        assertEquals(endereco.getEndereco(), dto.getEnderecos().get(0).getEndereco());
        assertEquals(endereco.getNumero(), dto.getEnderecos().get(0).getNumero());
    }
}
