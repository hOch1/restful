package api.restful.service;

import api.restful.config.jwt.JwtTokenProvider;
import api.restful.domain.Member;
import api.restful.domain.Role;
import api.restful.dto.JwtToken;
import api.restful.dto.Response;
import api.restful.dto.member.MemberResponse;
import api.restful.dto.member.SignUpRequest;
import api.restful.exception.MemberEmailAlreadyExistsException;
import api.restful.exception.NotConfirmPassword;
import api.restful.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SignService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public ResponseEntity<Response> signUp(SignUpRequest request){
        validationMember(request);

        Member member = Member.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .role(Role.ROLE_USER)
                .build();

        memberRepository.save(member);

        return ResponseEntity.ok(new Response<>(true, new MemberResponse(member)));
    }


    public ResponseEntity<Response> signIn(String email, String password){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        JwtToken jwtToken = tokenProvider.generateToken(authentication);


        return ResponseEntity.ok(new Response(true, jwtToken));
    }

    private void validationMember(SignUpRequest request) {
        if (!request.getPassword().equals(request.getConfirmPassword()))
            throw new NotConfirmPassword();
        if (memberRepository.existsByEmail(request.getEmail()))
            throw new MemberEmailAlreadyExistsException();
    }
}
