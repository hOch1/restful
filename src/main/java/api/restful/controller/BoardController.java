package api.restful.controller;

import api.restful.dto.Response;
import api.restful.dto.board.CreateBoardRequest;
import api.restful.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<Response> createBoard(@RequestBody CreateBoardRequest request) {
        return boardService.createBoard(request);
    }

    @GetMapping("/boards")
    public ResponseEntity<Response> findAll(){
        return boardService.findAll();
    }

    @GetMapping("/board/{id}")
    public ResponseEntity<Response> findOne(@PathVariable Long id){
        return boardService.findOne(id);
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<Response> delete(@PathVariable Long id){
        return boardService.delete(id);
    }
}
