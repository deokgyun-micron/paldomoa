package com.paldomoa.admin.service;

import com.paldomoa.admin.domain.AdminRepository;
import com.paldomoa.member.domain.Member;
import com.paldomoa.member.domain.MemberRepository;
import com.paldomoa.member.dto.member.MemberSaveRequest;
import com.paldomoa.member.dto.member.MemberSaveResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Member> getMember() {
        return adminRepository.findAll();
    }

}
