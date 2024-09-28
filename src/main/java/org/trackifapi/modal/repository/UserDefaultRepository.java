package org.trackifapi.modal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.trackifapi.modal.entity.UserDefault.UserDefault;

import java.util.Optional;

public interface UserDefaultRepository extends JpaRepository<UserDefault, Integer> {
    Optional<UserDefault> findByCpf(String cpf);
    Optional<UserDefault> findByRg(String rg);
    Optional<UserDefault> findByTelefone(String telefone);
    Optional<UserDefault> findByEmail(String email);
}