package api.restful.controller;

import api.restful.dto.Response;
import api.restful.dto.good.CreateGoodRequest;
import api.restful.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GoodController {

    private final GoodService goodService;

    @PostMapping("/good")
    public ResponseEntity<Response> addGood(@RequestBody CreateGoodRequest request){
        return goodService.addGood(request);
    }
}
