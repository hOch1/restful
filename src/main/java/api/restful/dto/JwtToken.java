package api.restful.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
public class JwtToken {

    private String grantType;
    private String authorization;
    private String accessToken;
    private String refreshToken;
    private Date accessTokenExpiresIn;
}
