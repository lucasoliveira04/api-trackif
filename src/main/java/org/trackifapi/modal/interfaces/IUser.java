package org.trackifapi.modal.interfaces;


import org.trackifapi.Enum.RoleEnum;

import java.time.LocalDateTime;

public interface IUser {
    String getName();
    String getRg();
    String getCpf();
    int getAge();
    String getEmail();
    String getPhone();
    java.util.Date getDateBirth();
    String getGender();
    LocalDateTime createdAt();
}
