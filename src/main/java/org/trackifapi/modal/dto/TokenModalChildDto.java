package org.trackifapi.modal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.trackifapi.modal.entity.TokenModalChild;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenModalChildDto implements Serializable {
    private Integer id;
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private UserChildDto userChild;

    public static TokenModalChildDto fromEntity(TokenModalChild tokenModalChild) {
        return TokenModalChildDto.builder()
                .id(tokenModalChild.getId())
                .createdAt(tokenModalChild.getCreatedAt())
                .expiresAt(tokenModalChild.getExpiresAt())
                .token(tokenModalChild.getToken())
                .userChild(UserChildDto.fromEntity(tokenModalChild.getUserChild()))
                .build();
    }

}