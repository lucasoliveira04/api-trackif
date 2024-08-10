package org.trackifapi.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trackifapi.modal.UserFatherModal;
@Repository
public interface UserFatherRepository extends JpaRepository<UserFatherModal, Long> {
}
