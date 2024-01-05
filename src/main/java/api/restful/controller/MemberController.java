package api.restful.controller;

import api.restful.dto.member.CreateMemberRequest;
import api.restful.dto.Response;
import api.restful.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member/signup")
    public ResponseEntity<Response> signup(
            @RequestBody CreateMemberRequest request){

        return memberService.saveMember(request);
    }

    @GetMapping("/members")
    public ResponseEntity<Response> findAll(){
        return memberService.findAll();
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<Response> findOne(
            @PathVariable Long id){

        return memberService.findOne(id);
    }

    @PatchMapping("/member/{id}")
    public ResponseEntity<Response> updateName(
            @PathVariable Long id,
            @RequestParam String name){

        return memberService.updateName(id, name);
    }

    @DeleteMapping("/member/{id}")
    public ResponseEntity<Response> delete(
            @PathVariable Long id){

        return memberService.deleteMember(id);
    }
}
