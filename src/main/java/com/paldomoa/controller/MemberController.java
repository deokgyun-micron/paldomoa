package com.paldomoa.controller;

import com.paldomoa.dto.member.MemberGetResponse;
import com.paldomoa.dto.member.MemberSaveRequest;
import com.paldomoa.dto.member.MemberSaveResponse;
import com.paldomoa.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<Void> join(@RequestBody MemberSaveRequest memberSaveRequest) {
        MemberSaveResponse memberSaveResponse = memberService.saveMember(memberSaveRequest);
        return ResponseEntity
                .created(URI.create("/api/v1/members/" + memberSaveResponse.getId()))
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberGetResponse> getCurrentUser(@PathVariable(name = "id") Long id) {
        log.info("여기다");
        return ResponseEntity.ok(MemberGetResponse.of(memberService.getMember(id)));
    }

}
