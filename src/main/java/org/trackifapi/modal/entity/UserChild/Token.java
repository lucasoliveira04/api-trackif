package org.trackifapi.modal.entity.UserChild;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "token")
@Getter @Setter
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "token")
    private String token;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @OneToOne
    @JoinColumn(name = "usuario_child_id")
    private UsuarioChild usuarioChild;

}
