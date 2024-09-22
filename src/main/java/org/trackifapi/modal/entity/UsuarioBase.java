package org.trackifapi.modal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.trackifapi.regex.RegexValidation;

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

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String PHONE_REGEX = "\\d{10,11}";
    private static final String CPF_REGEX = "\\d{11}";
    private static final String RG_REGEX = "\\d{9}";

    public UsuarioBase(String nome, String email, String telefone, String cpf, String rg, String rua, String bairro, String cidade, String estado, String cep) {
        super(rua, bairro, cidade, estado, cep);
        this.nome = nome;

        RegexValidation.validate(email, EMAIL_REGEX, "Email inválido");
        this.email = email;

        RegexValidation.validate(telefone, PHONE_REGEX, "Telefone inválido");
        this.telefone = telefone;

        RegexValidation.validate(cpf, CPF_REGEX, "CPF inválido");
        this.cpf = cpf;

        RegexValidation.validate(rg, RG_REGEX, "RG inválido");
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
