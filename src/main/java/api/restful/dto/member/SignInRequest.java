package api.restful.dto.member;

import lombok.Data;

@Data
public class SignInRequest {

    private String email;
    private String password;
}
