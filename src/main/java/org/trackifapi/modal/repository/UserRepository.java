package org.trackifapi.modal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trackifapi.modal.entity.UserData;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {
}
