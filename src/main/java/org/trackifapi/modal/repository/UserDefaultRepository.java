package org.trackifapi.modal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.trackifapi.modal.entity.UserDefault.UserDefault;

public interface UserDefaultRepository extends JpaRepository<UserDefault, Integer> {
}