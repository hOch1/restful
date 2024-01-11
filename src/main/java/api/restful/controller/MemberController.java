package api.restful.controller;

import api.restful.dto.Response;
import api.restful.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@Tag(name = "Member", description = "회원 관련 API")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members")
    @Operation(summary = "회원 전체 조회")
    public ResponseEntity<Response> findAll(){
        return memberService.findAll();
    }

    @GetMapping("/member/{id}")
    @Operation(summary = "회원 단건 조회")
    public ResponseEntity<Response> findOne(
            @PathVariable Long id){

        return memberService.findOne(id);
    }

    @PatchMapping("/member/{id}")
    @Operation(summary = "회원 이름 수정")
    public ResponseEntity<Response> updateName(
            @PathVariable Long id,
            @RequestParam String name){

        return memberService.updateName(id, name);
    }

    @DeleteMapping("/member/{id}")
    @Operation(summary = "회원 단건 삭제")
    public ResponseEntity<Response> delete(
            @PathVariable Long id){

        return memberService.deleteMember(id);
    }
}
