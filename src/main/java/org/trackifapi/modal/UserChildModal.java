package org.trackifapi.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
public class UserChildModal extends User{

    @Column(name = "token")
    private String token;
}
