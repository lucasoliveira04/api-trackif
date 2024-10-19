package org.trackifapi.modal.entity.addres;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.trackifapi.modal.entity.child.UserChildModal;
import org.trackifapi.modal.entity.father.UserFatherModal;

@Getter @Setter
@Entity(name = "AddressModalEntity")
public class AddressModal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 500)
    private String street;

    @Column(length = 500)
    private String number;

    @Column(length = 500)
    private String neighborhood;

    @Column(length = 500)
    private String city;

    @Column(length = 500)
    private String state;

    @Column(length = 500)
    private String country;

    @Column(length = 500)
    private String cep;

    @OneToOne
    @JoinColumn(name = "user_child_id")
    private UserChildModal userChild;

    @OneToOne
    @JoinColumn(name = "user_father_id")
    private UserFatherModal userFather;

    public AddressModal(String street, String number, String neighborhood, String city, String state, String country, String cep) {
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.cep = cep;
    }

    public AddressModal() {}
}
