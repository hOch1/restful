package api.restful.dto.board;

import api.restful.domain.Board;
import api.restful.domain.Member;
import lombok.Data;

@Data
public class CreateBoardRequest {

    private String title;
    private String content;

    public Board toEntity(Member member){
        return Board.builder()
                .title(title)
                .content(content)
                .member(member)
                .build();
    }
}
