package org.trackifapi.modal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.trackifapi.modal.entity.addres.AddressModal;

public interface AddressModalRepository extends JpaRepository<AddressModal, Integer> {
}