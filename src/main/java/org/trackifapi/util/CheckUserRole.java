package org.trackifapi.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.trackifapi.Enums.RolesEnum;

@Getter @Setter @Service
public class CheckUserRole {
    private RolesEnum role;

    public void checkToUser() {
        if (this.role == null){
            this.role = RolesEnum.USER;
        } else {
            this.role = RolesEnum.USER_CHILD;
        }
    }
}
