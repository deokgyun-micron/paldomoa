package com.paldomoa.admin.domain;

import com.paldomoa.common.domain.BaseTimeEntity;
import com.paldomoa.member.domain.RoleType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Admin extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 128)
    private String password;

    @Column(nullable = false, length = 30)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private String name;
    private String grade;
    private String address;
    private String status;

    @Builder
    public Admin(Long id, String email, String password, String nickname, RoleType role, String name, String grade, String address, String status) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
        this.name = name;
        this.grade = grade;
        this.address = address;
        this.status = status;
    }
}
