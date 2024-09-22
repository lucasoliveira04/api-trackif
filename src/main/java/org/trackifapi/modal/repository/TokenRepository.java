package org.trackifapi.modal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trackifapi.modal.entity.UserChild.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {
}