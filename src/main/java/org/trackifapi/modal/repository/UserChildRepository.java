package org.trackifapi.modal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trackifapi.modal.entity.UserChild;

@Repository
public interface UserChildRepository extends JpaRepository<UserChild, Integer> {
}
