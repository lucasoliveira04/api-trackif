package org.trackifapi.modal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "token_child")
@Getter @Setter
public class TokenModalChild {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "token", length = 512)
    private String token;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "address")
    private String address;

    @Column(name = "addressBefore")
    private String addressBefore;

    @OneToOne
    @JoinColumn(name = "user_child_id", referencedColumnName = "id")
    private UserChild userChild;
}
