package org.trackifapi.modal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.trackifapi.Enums.RolesEnum;
import org.trackifapi.Enums.StatusEnum;
import org.trackifapi.regex.RegexValidation;

import java.time.LocalDateTime;

import static org.trackifapi.util.Regex.EMAIL_REGEX;
import static org.trackifapi.util.Regex.PHONE_REGEX;
import static org.trackifapi.util.Regex.CPF_REGEX;
import static org.trackifapi.util.Regex.RG_REGEX;

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

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    public UsuarioBase() {
        super();
    }

    public UsuarioBase(String nome, String email, String telefone, String cpf, String rg,
                       String rua, String bairro, String cidade, String estado, String cep, StatusEnum status) {
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


    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
