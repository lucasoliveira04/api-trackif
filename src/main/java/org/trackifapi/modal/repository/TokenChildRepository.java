package org.trackifapi.modal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trackifapi.modal.entity.Child.TokenChild;

@Repository
public interface TokenChildRepository extends JpaRepository<TokenChild, Integer> {
}