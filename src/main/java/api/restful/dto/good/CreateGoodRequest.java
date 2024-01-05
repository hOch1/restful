package api.restful.dto.good;

import lombok.Data;

@Data
public class CreateGoodRequest {

    private Long member;
    private Long board;
}
