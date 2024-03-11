package com.paldomoa.admin.dto.member;

import com.paldomoa.member.domain.Member;
import com.paldomoa.member.domain.RoleType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class AdminGetResponse {

    private Long id;

    private String email;

    private String password;

    private String nickname;

    private RoleType role;

    private String name;
    private String grade;
    private String address;
    private String status;


    public static AdminGetResponse of(Member member) {
        return new AdminGetResponse(
                member.getId(),
                member.getEmail(),
                member.getPassword(),
                member.getNickname(),
                member.getRole(),
                member.getName(),
                member.getGrade(),
                member.getAddress(),
                member.getStatus());
    }

}
