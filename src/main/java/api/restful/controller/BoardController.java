package api.restful.controller;

import api.restful.dto.Response;
import api.restful.dto.board.CreateBoardRequest;
import api.restful.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequiredArgsConstructor
@Tag(name = "Board", description = "게시판 관련 API")
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board")
    @Operation(summary = "게시물 생성")
    public ResponseEntity<Response> createBoard(@RequestBody CreateBoardRequest request,
                                                Principal principal) {
        return boardService.createBoard(request, principal);
    }

    @GetMapping("/boards")
    @Operation(summary = "게시물 전체 조회")
    public ResponseEntity<Response> findAll(){
        return boardService.findAll();
    }

    @GetMapping("/board/{id}")
    @Operation(summary = "게시물 단건 조회")
    public ResponseEntity<Response> findOne(@PathVariable Long id){
        return boardService.findOne(id);
    }

    @GetMapping("/boards/member/{id}")
    @Operation(summary = "작성자로 조회")
    public ResponseEntity<Response> findWriter(@PathVariable Long id){
        return boardService.findByWriter(id);
    }

    @DeleteMapping("/board/{id}")
    @Operation(summary = "게시물 삭제")
    public ResponseEntity<Response> delete(@PathVariable Long id){
        return boardService.delete(id);
    }
}
