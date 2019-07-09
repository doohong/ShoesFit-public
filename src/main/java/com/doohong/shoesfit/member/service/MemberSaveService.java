package com.doohong.shoesfit.member.service;

import com.doohong.shoesfit.member.MemberRepository;
import com.doohong.shoesfit.member.domain.Member;
import com.doohong.shoesfit.member.domain.MemberRole;
import com.doohong.shoesfit.member.dto.MemberDTO;
import com.doohong.shoesfit.member.dto.MemberResponse;
import com.doohong.shoesfit.member.MemberRoleRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@RequiredArgsConstructor
@Service
public class MemberSaveService {
    private final MemberRepository memberRepository;
    private final MemberRoleRepository memberRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberResponse saveMember(MemberDTO memberDTO){
        memberRoleRepository.save(MemberRole.builder().role("ADMIN").build());
        MemberRole memberRole = memberRoleRepository.findByRole("ADMIN");
        System.out.println(memberRole.toString());
        Member member = Member.builder()
                .email(memberDTO.getEmail())
                .password(passwordEncoder.encode(memberDTO.getPassword()))
                .name(memberDTO.getName())
                .active(1)
                .roles(new ArrayList<MemberRole>(Arrays.asList(memberRole)))
                .build();
        Member savemember =  memberRepository.save(member);
        System.out.println(savemember.getRoles().toString());
        return MemberResponse.builder()
                .email(savemember.getEmail())
                .password(savemember.getPassword())
                .name(savemember.getName())
                .active(savemember.getActive())
                .roles(savemember.getRoles())
                .build();


    }


}
