package org.trackifapi.modal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trackifapi.modal.entity.UserChild.UsuarioChild;

@Repository
public interface UsuarioChildRepository extends JpaRepository<UsuarioChild, Integer> {
}
