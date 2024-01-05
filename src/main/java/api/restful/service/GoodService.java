package api.restful.service;

import api.restful.domain.Board;
import api.restful.domain.Good;
import api.restful.domain.Member;
import api.restful.dto.Response;
import api.restful.dto.good.CreateGoodRequest;
import api.restful.dto.good.GoodResponse;
import api.restful.exception.AlreadyGoodException;
import api.restful.exception.BoardNotFoundException;
import api.restful.exception.MemberNotFoundException;
import api.restful.repository.BoardRepository;
import api.restful.repository.GoodRepository;
import api.restful.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class GoodService {

    private final GoodRepository goodRepository;
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    public ResponseEntity<Response> addGood(CreateGoodRequest request){
        Member member = memberRepository.findById(request.getMember()).orElseThrow(MemberNotFoundException::new);
        Board board = boardRepository.findById(request.getBoard()).orElseThrow(BoardNotFoundException::new);

        validationAlreadyGood(request);

        Good good = goodRepository.save(new Good(member, board));

        return ResponseEntity.ok(new Response(true, new GoodResponse(good)));
    }

    private void validationAlreadyGood(CreateGoodRequest request) {
        if(goodRepository.existsByMember_IdAndBoard_Id(request.getMember(), request.getBoard()))
            throw new AlreadyGoodException();
    }
}
