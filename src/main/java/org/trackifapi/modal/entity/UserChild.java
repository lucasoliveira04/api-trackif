package org.trackifapi.modal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_child")
@Getter @Setter
public class UserChild {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_data_id", referencedColumnName = "id")
    private UserData userData;
}
