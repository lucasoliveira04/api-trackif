package org.trackifapi.modal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.trackifapi.modal.entity.UserChild;

public interface UserChildRepository extends JpaRepository<UserChild, Integer> {
}
