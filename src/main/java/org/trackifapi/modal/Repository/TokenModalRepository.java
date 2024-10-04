package org.trackifapi.modal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trackifapi.modal.entity.token.TokenModal;

@Repository
public interface TokenModalRepository extends JpaRepository<TokenModal, Integer> {
}