package api.restful.service;

import api.restful.domain.Board;
import api.restful.domain.Member;
import api.restful.dto.Response;
import api.restful.dto.board.BoardResponse;
import api.restful.dto.board.CreateBoardRequest;
import api.restful.exception.BoardNotFoundException;
import api.restful.exception.MemberNotFoundException;
import api.restful.repository.BoardRepository;
import api.restful.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public ResponseEntity<Response> createBoard(CreateBoardRequest request){
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(MemberNotFoundException::new);
        Board board = request.toEntity(member);

        boardRepository.save(board);

        return ResponseEntity.ok().body(new Response<>(true, new BoardResponse(board)));
    }

    public ResponseEntity<Response> findOne(Long id){
        Board board = boardRepository.findById(id).orElseThrow(BoardNotFoundException::new);

        return ResponseEntity.ok().body(new Response<>(true, new BoardResponse(board)));
    }

    public ResponseEntity<Response> findAll(){
        List<Board> boards = boardRepository.findAll();
        List<BoardResponse> boardResponses = boards.stream()
                .map(board -> new BoardResponse(board))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(new Response<>(true, boardResponses));
    }

    public ResponseEntity<Response> findByWriter(Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
        List<Board> boards = boardRepository.findByMember(member);
        List<BoardResponse> boardResponses = boards.stream()
                .map(board -> new BoardResponse(board))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(new Response<>(true, boardResponses));
    }

    public ResponseEntity<Response> delete(Long id){
        Board board = boardRepository.findById(id).orElseThrow(BoardNotFoundException::new);

        boardRepository.delete(board);

        return ResponseEntity.ok().body(new Response(true, new BoardResponse(board)));
    }
}
