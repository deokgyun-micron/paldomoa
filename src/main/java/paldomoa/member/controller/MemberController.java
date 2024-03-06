package paldomoa.member.controller;

import paldomoa.member.dto.member.MemberGetResponse;
import paldomoa.member.dto.member.MemberSaveRequest;
import paldomoa.member.dto.member.MemberSaveResponse;
import paldomoa.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/api/me")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<Void> join(@RequestBody MemberSaveRequest memberSaveRequest) {
        MemberSaveResponse memberSaveResponse = memberService.saveMember(memberSaveRequest);
        return ResponseEntity
                .created(URI.create("/api/" + memberSaveResponse.getId()))
                .build();
    }

    @GetMapping("/me")
    public ResponseEntity<MemberGetResponse> getCurrentUser(Long id) {
        return ResponseEntity.ok().body(MemberGetResponse.of(memberService.getMember(id)));
    }



}
