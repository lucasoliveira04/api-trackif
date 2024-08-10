package org.trackifapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trackifapi.dto.UserChildDto;
import org.trackifapi.dto.UserDto;
import org.trackifapi.repository.user.UserChildRepository;
import org.trackifapi.repository.user.UserFatherRepository;
import org.trackifapi.repository.user.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListUsersServices {
    private final UserRepository userRepository;
    private final UserChildRepository userChildRepository;
    private final UserFatherRepository userFatherRepository;

    public ListUsersServices(UserRepository userRepository, UserChildRepository userChildRepository, UserFatherRepository userFatherRepository) {
        this.userRepository = userRepository;
        this.userChildRepository = userChildRepository;
        this.userFatherRepository = userFatherRepository;
    }

    public List<UserDto> getAllDataUser(){
        return userRepository.findAll().stream()
                .map(UserDto::fromUser)
                .collect(Collectors.toList());
    }

    public List<UserChildDto> getAllDataUserChild(){
        return userChildRepository.findAll().stream()
                .map(UserChildDto::fromEntityUserChildDto)
                .collect(Collectors.toList());
    }
}
