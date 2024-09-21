package org.trackifapi.modal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.trackifapi.modal.entity.UsuarioMain;

import java.util.UUID;

public interface UsuarioMainRepository extends JpaRepository<UsuarioMain, UUID> {
}