package org.trackifapi.modal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trackifapi.modal.entity.Child.UsuarioChild;

import java.util.Optional;

@Repository
public interface UsuarioChildRepository extends JpaRepository<UsuarioChild, Integer> {
    Optional<UsuarioChild> findByCpf(String cpf);
    Optional<UsuarioChild> findByRg(String rg);
    Optional<UsuarioChild> findByTelefone(String telefone);
    Optional<UsuarioChild> findByEmail(String email);
}