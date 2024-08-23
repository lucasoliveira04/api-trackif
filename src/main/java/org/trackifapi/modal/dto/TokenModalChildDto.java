package org.trackifapi.modal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.trackifapi.modal.entity.TokenModalChild;
import org.springframework.web.client.RestTemplate;
import org.trackifapi.services.GenerateToken.GenerateTokenServices;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenModalChildDto implements Serializable {
    private Integer id;
    private String token;
    private LocalDateTime createdAt;
    private UserChildDto userChild;
    private String address;
    private String addressBefore;


    public static TokenModalChildDto fromEntity(TokenModalChild tokenModalChild) {
        TokenModalChildDto.TokenModalChildDtoBuilder builder = TokenModalChildDto.builder()
                .id(tokenModalChild.getId())
                .createdAt(tokenModalChild.getCreatedAt())
                .token(tokenModalChild.getToken())
                .address(tokenModalChild.getAddress())
                .addressBefore(tokenModalChild.getAddressBefore())
                .userChild(UserChildDto.fromEntity(tokenModalChild.getUserChild()));

        return builder.build();
    }
}
