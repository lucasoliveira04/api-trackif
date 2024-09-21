package org.trackifapi.modal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.trackifapi.modal.entity.EnderecoModal;

import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<EnderecoModal, UUID> {
}