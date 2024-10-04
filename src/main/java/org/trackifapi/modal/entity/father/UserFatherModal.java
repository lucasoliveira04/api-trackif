package org.trackifapi.modal.entity.father;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.trackifapi.Enum.RoleEnum;
import org.trackifapi.modal.interfaces.IUserWithRoles;
import org.trackifapi.modal.interfaces.IUser;

import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "UserFatherModalEntity")
@Getter
@Setter
public class UserFatherModal implements IUser, IUserWithRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String rg;
    private String cpf;
    private int age;
    private String email;
    private String phone;
    private Date dateBirth;
    private String gender;
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;

    public UserFatherModal(String name, String rg, String cpf, int age, String email, String phone, Date dateBirth, String gender, RoleEnum roleEnum, LocalDateTime createdAt) {
        this.name = name;
        this.rg = rg;
        this.cpf = cpf;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.dateBirth = dateBirth;
        this.gender = gender;
        this.roleEnum = roleEnum;
        this.createdAt = createdAt;
    }

    public UserFatherModal() {
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getRg() {
        return this.rg;
    }

    @Override
    public String getCpf() {
        return this.cpf;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPhone() {
        return this.phone;
    }

    @Override
    public Date getDateBirth() {
        return this.dateBirth;
    }

    @Override
    public String getGender() {
        return this.gender;
    }

    @Override
    public LocalDateTime createdAt() {
        return this.createdAt;
    }

    @Override
    public RoleEnum getRolesEnum() {
        return this.roleEnum;
    }
}
