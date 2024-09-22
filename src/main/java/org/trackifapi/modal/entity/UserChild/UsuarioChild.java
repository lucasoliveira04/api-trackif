package org.trackifapi.modal.entity.UserChild;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.trackifapi.modal.entity.Usuario;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario_child")
@Getter @Setter
public class UsuarioChild extends Usuario {

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @OneToOne(mappedBy = "usuarioChild", cascade = CascadeType.ALL)
    private Token token;

}
