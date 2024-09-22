package org.trackifapi.services.Token;

import org.springframework.stereotype.Service;
import org.trackifapi.modal.dto.TokenDto;
import org.trackifapi.modal.entity.Child.TokenChild;
import org.trackifapi.modal.entity.Child.UsuarioChild;
import org.trackifapi.modal.repository.TokenChildRepository;
import org.trackifapi.modal.repository.UsuarioChildRepository;

@Service
public class TokenServicesImpl implements TokenSevicesInterface {

    private final TokenChildRepository tokenChildRepository;
    private final UsuarioChildRepository usuarioChildRepository;

    public TokenServicesImpl(TokenChildRepository tokenChildRepository, UsuarioChildRepository usuarioChildRepository) {
        this.tokenChildRepository = tokenChildRepository;
        this.usuarioChildRepository = usuarioChildRepository;
    }

    @Override
    public TokenChild addToken(TokenDto tokenDto, Integer idUsuario) {
        UsuarioChild usuarioChild = usuarioChildRepository.findById(tokenDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        TokenChild token = new TokenChild();
        token.setToken(tokenDto.getToken());
        token.setUsuario(usuarioChild);
        token.setDataExpiration(tokenDto.getDataExpiration());
        return tokenChildRepository.save(token);
    }
}