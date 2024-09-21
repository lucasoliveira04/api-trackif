package org.trackifapi.modal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Getter @Setter
public class EnderecoModal {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name = "cep", length = 12)
    private String cep;

    @Column(name = "endereco", length = 50)
    private String endereco;

    @Column(name = "numero", length = 5)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioMain usuario;
}
