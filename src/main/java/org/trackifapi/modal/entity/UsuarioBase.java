package org.trackifapi.modal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass @Getter @Setter
public abstract class UsuarioBase extends EnderecoBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "rg")
    private String rg;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public UsuarioBase(String nome, String email, String telefone, String cpf, String rg, String rua, String bairro, String cidade, String estado, String cep) {
        super(rua, bairro, cidade, estado, cep);
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rg = rg;
    }

    public UsuarioBase() {
        super();
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
