package org.trackifapi.services.User;

import org.springframework.stereotype.Service;
import org.trackifapi.modal.dto.TokenModalChildDto;
import org.trackifapi.modal.dto.UserChildDto;
import org.trackifapi.modal.dto.UserDataDto;
import org.trackifapi.modal.repository.TokenModalChildRepository;
import org.trackifapi.modal.repository.UserChildRepository;
import org.trackifapi.modal.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListAllUsers {

    private final UserRepository userRepository;
    private final UserChildRepository userChildRepository;
    private final TokenModalChildRepository tokenModalChildRepository;

    public ListAllUsers(UserRepository userRepository, UserChildRepository userChildRepository,
                        TokenModalChildRepository tokenModalChildRepository) {
        this.userRepository = userRepository;
        this.userChildRepository = userChildRepository;
        this.tokenModalChildRepository = tokenModalChildRepository;
    }

    public List<UserDataDto> getListAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDataDto::fromEntity)
                .collect(Collectors.toList());
    }

    public List<UserChildDto> getListAllUserChildren() {
        return userChildRepository.findAll().stream()
                .map(UserChildDto::fromEntity)
                .collect(Collectors.toList());
    }

    public List<TokenModalChildDto> getListAllTokenModalChilds() {
        return tokenModalChildRepository.findAll().stream()
                .map(TokenModalChildDto::fromEntity)
                .collect(Collectors.toList());
    }
}
