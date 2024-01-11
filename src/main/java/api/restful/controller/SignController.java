package api.restful.controller;

import api.restful.dto.Response;
import api.restful.dto.member.MemberResponse;
import api.restful.dto.member.SignInRequest;
import api.restful.dto.member.SignUpRequest;
import api.restful.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Sign", description = "로그인, 회원가입 API")
@SecurityRequirement(name = "Bearer")
public class SignController {

    private final MemberService memberService;

    @PostMapping("/signup")
    @Operation(summary = "회원가입")
    public ResponseEntity<Response> signup(@RequestBody SignUpRequest request){
        return memberService.saveMember(request);
    }

    @PostMapping("/signin")
    @Operation(summary = "로그인")
    public ResponseEntity<Response> signin(@RequestBody SignInRequest request){
        return memberService.signIn(request.getEmail(), request.getPassword());
    }

}