package org.trackifapi.modal.entity.Child;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.trackifapi.Enums.RolesEnum;
import org.trackifapi.modal.entity.UsuarioBase;

@Entity @Getter @Setter
public class UsuarioChild extends UsuarioBase {

    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    private RolesEnum roles;

    public UsuarioChild() {
        super();
    }

    public UsuarioChild(String nome, String email, String telefone, String cpf, String rg,
                        String rua, String estado, String cidade, String bairro, String cep, RolesEnum roles) {
        super(nome, email, telefone, cpf, rg, rua, bairro, cidade, estado, cep);
        this.roles = roles;
    }

}
