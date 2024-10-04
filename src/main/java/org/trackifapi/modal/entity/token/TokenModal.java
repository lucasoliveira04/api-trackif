package org.trackifapi.modal.entity.token;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.trackifapi.modal.entity.child.UserChildModal;

@Entity
@Getter @Setter
public class TokenModal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String token;

    @OneToOne
    @JoinColumn(name = "userChild_id", unique = true)
    private UserChildModal userChild;
}
