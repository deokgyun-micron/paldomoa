package com.paldomoa.dto.member;

import com.paldomoa.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSaveResponse {

    private Long id;

    private MemberSaveResponse(Long id) {
        this.id = id;
    }

    public static MemberSaveResponse from(Member member) {
        return new MemberSaveResponse(member.getId());
    }
}
