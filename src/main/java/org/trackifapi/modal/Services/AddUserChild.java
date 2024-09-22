package org.trackifapi.modal.Services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.trackifapi.modal.dto.TokenDto;
import org.trackifapi.modal.dto.UsuarioChildDto;
import org.trackifapi.modal.entity.UserChild.Token;
import org.trackifapi.modal.entity.UserChild.UsuarioChild;
import org.trackifapi.modal.repository.TokenRepository;
import org.trackifapi.modal.repository.UsuarioChildRepository;

import java.time.LocalDateTime;

@Service
public class AddUserChild {
    private final UsuarioChildRepository userChildRepository;
    private final TokenRepository tokenRepository;

    public AddUserChild(UsuarioChildRepository userChildRepository, TokenRepository tokenRepository) {
        this.userChildRepository = userChildRepository;
        this.tokenRepository = tokenRepository;
    }

    public ResponseEntity<UsuarioChildDto> add(UsuarioChildDto dto) {
        UsuarioChild user = addUsuarioChild(dto);
        UsuarioChild savedUser = userChildRepository.save(user);

        Token token = addToken(dto.getToken());
        token.setUsuarioChild(savedUser);
        Token savedToken = tokenRepository.save(token);

        savedUser.setToken(savedToken);
        userChildRepository.save(savedUser);


        TokenDto tokenDto = TokenDto.fromEntity(savedToken);
        System.out.println("Token exibido: " + tokenDto);

        dto.setId(savedUser.getId());
        dto.setToken(tokenDto);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


    private UsuarioChild addUsuarioChild(UsuarioChildDto dto) {
        UsuarioChild user = new UsuarioChild();
        user.setNome(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setTelefone(dto.getTelefone());
        user.setCpf(dto.getCpf());
        user.setRg(dto.getRg());
        user.setDataNascimento(dto.getDataNascimento());
        user.setCreated_at(LocalDateTime.now());
        return user;
    }


    private Token addToken(TokenDto dto) {
        if (dto.getToken() == null) {
            throw new IllegalArgumentException("Token is required");
        }
        Token token = new Token();
        token.setToken(dto.getToken());
        token.setDataCriacao(LocalDateTime.now());
        return token;
    }
}
