package org.trackifapi.modal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trackifapi.modal.entity.child.UserChildModal;

@Repository
public interface UserChildModalRepository extends JpaRepository<UserChildModal, Integer> {
}