package api.restful.dto.member;

import lombok.Data;

@Data
public class CreateMemberRequest {

    private String email;
    private String password;
    private String name;
}
