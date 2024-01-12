package api.restful.controller;

import api.restful.dto.JwtToken;
import api.restful.dto.Response;
import api.restful.dto.member.MemberResponse;
import api.restful.dto.member.SignInRequest;
import api.restful.dto.member.SignUpRequest;
import api.restful.service.MemberService;
import api.restful.service.SignService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Sign", description = "로그인, 회원가입 API")
@SecurityRequirement(name = "Bearer")
public class SignController {

    private final SignService signService;

    @PostMapping("/signup")
    @Operation(summary = "회원가입")
    public ResponseEntity<Response> signup(@RequestBody SignUpRequest request){
        return signService.signUp(request);
    }

    @PostMapping("/signin")
    @Operation(summary = "로그인")
    public ResponseEntity<Response> signin(@RequestBody SignInRequest request){
        return signService.signIn(request.getEmail(), request.getPassword());
    }

    @PostMapping("/reissue")
    @Operation(summary = "Access Token 재발행")
    public ResponseEntity<Response> reIssue(@RequestHeader HttpHeaders headers,
                                            @RequestBody SignInRequest signInRequest){
        String accessToken = headers.getFirst("Authorization");
        return signService.reissue(accessToken, signInRequest);
    }

}
