package org.trackifapi.modal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
public class UsuarioMain {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "telefone", length = 50)
    private String telefone;

    @Column(name = "rg", length = 14)
    private String rg;

    @Column(name = "cpf", length = 14)
    private String cpf;

    @Column(name = "data_nascimento")
    private Date data_nascimento;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @PrePersist
    protected void OnCreate() {
        created_at = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnderecoModal> enderecos;

    @OneToOne(mappedBy = "usuarioMain", cascade = CascadeType.ALL, orphanRemoval = true)
    private UsuarioFilho usuarioFilho;
}
