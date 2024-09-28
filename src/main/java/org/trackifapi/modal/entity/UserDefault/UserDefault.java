package org.trackifapi.modal.entity.UserDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.trackifapi.Enums.RolesEnum;
import org.trackifapi.Enums.StatusEnum;
import org.trackifapi.modal.entity.UsuarioBase;

@Entity
@Getter @Setter
public class UserDefault extends UsuarioBase {

        @Enumerated(EnumType.STRING)
        @Column(name = "roles")
        private RolesEnum roles;

        public UserDefault() {
            super();
        }

        public UserDefault(String nome, String email, String telefone, String cpf, String rg,
                           String rua, String estado, String cidade, String bairro, String cep, RolesEnum roles, StatusEnum status) {
            super(nome, email, telefone, cpf, rg, rua, bairro, cidade, estado, cep, status);

            this.roles = roles;
        }
}
