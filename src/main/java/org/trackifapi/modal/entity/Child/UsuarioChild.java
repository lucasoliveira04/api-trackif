package org.trackifapi.modal.entity.Child;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.trackifapi.modal.entity.UsuarioBase;

@Entity @Getter @Setter
public class UsuarioChild extends UsuarioBase {

    public UsuarioChild() {
        super();
    }

    public UsuarioChild(String nome, String email, String telefone, String cpf, String rg, String rua, String bairro, String cidade, String estado, String cep) {
        super(nome, email, telefone, cpf, rg, rua, bairro, cidade, estado, cep);
    }
}
