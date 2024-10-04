package org.trackifapi.services.token;

import org.trackifapi.Enum.RoleEnum;
import org.trackifapi.modal.entity.child.UserChildModal;

import java.util.UUID;

public class GenerateToken {
    public String generateToken(RoleEnum role, Object user) {
        if (role.equals(RoleEnum.USER_CHILD) && user instanceof UserChildModal) {

            return UUID.randomUUID().toString();
        }
        return "";
    }
}
