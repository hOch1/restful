package api.restful.dto.member;

import lombok.Data;

@Data
public class SignUpRequest {

    private String email;
    private String password;
    private String confirmPassword;
    private String name;

}
