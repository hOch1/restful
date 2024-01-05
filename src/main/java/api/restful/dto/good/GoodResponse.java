package api.restful.dto.good;

import api.restful.domain.Good;
import lombok.Data;

@Data
public class GoodResponse {

    private Long id;
    private String member_name;
    private String board_title;

    public GoodResponse(Good good){
        this.id = good.getId();
        this.member_name = good.getMember().getName();
        this.board_title = good.getBoard().getTitle();
    }
}
