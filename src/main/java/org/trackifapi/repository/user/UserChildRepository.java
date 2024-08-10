package org.trackifapi.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trackifapi.modal.UserChildModal;
@Repository
public interface UserChildRepository extends JpaRepository<UserChildModal, Long> {
}
