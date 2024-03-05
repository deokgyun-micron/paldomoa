package com.paldomoa.service;

import com.paldomoa.domain.Member;
import com.paldomoa.dto.member.MemberSaveRequest;
import com.paldomoa.dto.member.MemberSaveResponse;
import com.paldomoa.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class MemberService {

    private final MemberRepository members;

    public MemberService(MemberRepository members) {
        this.members = members;
    }

    public MemberSaveResponse saveMember(MemberSaveRequest memberSaveRequest) {

        Member member = Member.builder()
                .email(memberSaveRequest.getEmail())
                .password(memberSaveRequest.getPassword())
                .nickname(memberSaveRequest.getNickname())
                .name(memberSaveRequest.getName())
                .address(memberSaveRequest.getAddress())
                .role(memberSaveRequest.getRole())
                .grade(memberSaveRequest.getGrade())
                .status(memberSaveRequest.getStatus())
                .build();

        Member saveMember = members.save(member);
        log.info(saveMember.toString());
        return MemberSaveResponse.from(saveMember);
    }

    public Member getMember(Long id) {
        return members.findById(id).orElse(Member.builder().build());
    }

}
