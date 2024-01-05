package api.restful.dto.board;

import api.restful.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponse {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private int goods;

    public BoardResponse(Board board){
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getMember().getName();
        this.goods = Optional.ofNullable(board.getGoods())
                .orElseGet(Collections::emptyList)
                .size();
    }
}
