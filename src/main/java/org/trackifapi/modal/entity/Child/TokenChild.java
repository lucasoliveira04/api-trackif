package org.trackifapi.modal.entity.Child;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class TokenChild {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "token")
    private String token;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_criacao", insertable = false, updatable = false)
    private LocalDateTime dataExpiration;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuarioChild usuario;

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now();
    }
}
