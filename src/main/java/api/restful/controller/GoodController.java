package api.restful.controller;

import api.restful.dto.Response;
import api.restful.dto.good.CreateGoodRequest;
import api.restful.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GoodController {

    private final GoodService goodService;

    @PostMapping("/good")
    public ResponseEntity<Response> addGood(@RequestBody CreateGoodRequest request){
        return goodService.addGood(request);
    }

    @DeleteMapping("/good/{memberId}/{boardId}")
    public ResponseEntity<Response> deleteGood(@PathVariable Long memberId,
                                               @PathVariable Long boardId){

        return goodService.deleteGood(memberId, boardId);
    }
}
