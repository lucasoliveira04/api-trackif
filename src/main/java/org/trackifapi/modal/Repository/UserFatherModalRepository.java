package org.trackifapi.modal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trackifapi.modal.entity.father.UserFatherModal;

@Repository
public interface UserFatherModalRepository extends JpaRepository<UserFatherModal, Integer> {
}