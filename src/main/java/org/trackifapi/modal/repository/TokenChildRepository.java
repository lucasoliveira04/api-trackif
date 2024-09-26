package org.trackifapi.modal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.trackifapi.modal.entity.Child.TokenChild;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface TokenChildRepository extends JpaRepository<TokenChild, Integer> {
    Optional<TokenChild> findByUsuarioId(Integer id);
}