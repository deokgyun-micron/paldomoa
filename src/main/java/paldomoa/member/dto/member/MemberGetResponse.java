package paldomoa.member.dto.member;

import paldomoa.member.domain.Member;
import paldomoa.member.domain.RoleType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MemberGetResponse {

    private Long id;

    private String email;

    private String password;

    private String nickname;

    private RoleType role;

    private String name;
    private String grade;
    private String address;
    private String status;


    public static MemberGetResponse of(Member member) {
        return new MemberGetResponse(
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
