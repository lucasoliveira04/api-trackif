package org.trackifapi.services.token;

import org.trackifapi.Enum.RoleEnum;

import java.util.List;
import java.util.Map;

public interface IToken {
    String createToken(RoleEnum role, Object user);
    List<String> decodeToken(String token);
    void deleteToken();
    void updateToken();
}
