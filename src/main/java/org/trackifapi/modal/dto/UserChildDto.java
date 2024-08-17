package org.trackifapi.modal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.trackifapi.modal.entity.UserChild;
import org.trackifapi.modal.entity.UserData;

import java.io.Serializable;

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserChildDto implements Serializable {
    private Integer id;
    private UserDataDto userData;

    public static UserChildDto fromEntity(UserChild userChild){
        return UserChildDto.builder()
                .id(userChild.getId())
                .userData(UserDataDto.fromEntity(userChild.getUserData()))
                .build();
    }
}