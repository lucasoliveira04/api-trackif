package org.trackifapi.services.Child;

import org.springframework.stereotype.Service;
import org.trackifapi.modal.entity.Child.UsuarioChild;
import org.trackifapi.modal.dto.UsuarioChildDto;
import org.trackifapi.modal.repository.UsuarioChildRepository;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ListUserChild {
    private final UsuarioChildRepository usuarioChildRepository;

    public ListUserChild(UsuarioChildRepository usuarioChildRepository) {
        this.usuarioChildRepository = usuarioChildRepository;
    }

    public List<UsuarioChildDto> listUserChild() {
        List<UsuarioChild> usuarioChildList = usuarioChildRepository.findAll();
        return usuarioChildList.stream()
                .map(UsuarioChildDto::fromEntity)
                .collect(Collectors.toList());
    }
}
