package org.trackifapi.services.ListUser;

import org.springframework.stereotype.Service;
import org.trackifapi.modal.Repository.UserChildModalRepository;
import org.trackifapi.modal.Repository.UserFatherModalRepository;
import org.trackifapi.modal.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListUserServices {
    private final UserChildModalRepository userChildModalRepository;
    private final UserFatherModalRepository userFatherModalRepository;

    public ListUserServices(UserChildModalRepository userChildModalRepository, UserFatherModalRepository userFatherModalRepository) {
        this.userChildModalRepository = userChildModalRepository;
        this.userFatherModalRepository = userFatherModalRepository;
    }

    public List<UserDto> listAllFather() {
        return userFatherModalRepository.findAll()
                .stream()
                .map(UserDto::fromEntityFather)
                .collect(Collectors.toList());
    }

    public List<UserDto> listAllChildren() {
        return userChildModalRepository.findAll()
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }
}
