package api.restful.service;

import api.restful.domain.Member;
import api.restful.dto.member.CreateMemberRequest;
import api.restful.dto.Response;
import api.restful.dto.member.MemberResponse;
import api.restful.exception.MemberEmailAlreadyExistsException;
import api.restful.exception.MemberNotFoundException;
import api.restful.exception.NotConfirmPassword;
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
public class MemberService {

    private final MemberRepository memberRepository;

    public ResponseEntity<Response> saveMember(CreateMemberRequest request){
        validationMember(request);

        Member member = Member.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .name(request.getName())
                .build();

        memberRepository.save(member);

        return ResponseEntity.ok(new Response<>(true, new MemberResponse(member)));
    }

    public ResponseEntity<Response> updateName(Long memberId, String name){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(MemberNotFoundException::new);

        member.updateName(name);
        memberRepository.save(member);

        return ResponseEntity.ok(new Response<>(true, new MemberResponse(member)));
    }

    public ResponseEntity<Response> findOne(Long memberId){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(MemberNotFoundException::new);

        return ResponseEntity.ok().body(new Response<>(true, new MemberResponse(member)));
    }

    public ResponseEntity<Response> findAll(){
        List<Member> members = memberRepository.findAll();

        List<MemberResponse> memberResponses = members.stream()
                .map(member -> new MemberResponse(member))
                .collect(Collectors.toList());

        return ResponseEntity.ok(new Response<>(true, memberResponses));
    }

    public ResponseEntity<Response> deleteMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(MemberNotFoundException::new);

        memberRepository.delete(member);

        return ResponseEntity.ok().body(new Response<>(true, new MemberResponse(member)));
    }

    private void validationMember(CreateMemberRequest request) {
        if (!request.getPassword().equals(request.getConfirmPassword()))
            throw new NotConfirmPassword();
        if (memberRepository.existsByEmail(request.getEmail()))
            throw new MemberEmailAlreadyExistsException();
    }
}
