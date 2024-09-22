package org.trackifapi.services.Token;

import org.trackifapi.modal.dto.TokenDto;
import org.trackifapi.modal.entity.Child.TokenChild;

public interface TokenSevicesInterface {
    TokenChild addToken(TokenDto tokenDto, Integer idUsuario);
}
