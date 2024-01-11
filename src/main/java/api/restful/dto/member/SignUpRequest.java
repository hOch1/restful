package api.restful.dto.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SignUpRequest {

    private String email;
    private String password;
    private String confirmPassword;
    private String name;

}
