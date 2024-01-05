package api.restful.dto.board;

import api.restful.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponse {

    private Long id;
    private String title;
    private String content;
    private String writer;

    public BoardResponse(Board board){
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getMember().getName();
    }
}
