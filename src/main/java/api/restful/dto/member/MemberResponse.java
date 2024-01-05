package api.restful.dto.member;

import api.restful.domain.Board;
import api.restful.domain.Member;
import api.restful.dto.board.BoardResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberResponse {

    private Long id;
    private String email;
    private String name;
    private List<BoardResponse> boards = new ArrayList<>();

    public MemberResponse(Member member){
        this.id = member.getId();
        this.email = member.getEmail();
        this.name = member.getName();
        this.boards = Optional.ofNullable(member.getBoards())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(board -> new BoardResponse(board))
                .collect(Collectors.toList());
    }
}
