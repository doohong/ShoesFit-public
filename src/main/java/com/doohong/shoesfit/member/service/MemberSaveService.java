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

import java.util.Arrays;
import java.util.HashSet;

@RequiredArgsConstructor
public class MemberSaveService {
    private final MemberRepository memberRepository;
    private final MemberRoleRepository memberRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberResponse saveMember(MemberDTO memberDTO){
        MemberRole memberRole = memberRoleRepository.findByRole("ADMIN");
        Member member = Member.builder()
                .email(memberDTO.getEmail())
                .password(passwordEncoder.encode(memberDTO.getPassword()))
                .name(memberDTO.getName())
                .active(1)
                .roles(new HashSet<MemberRole>(Arrays.asList(memberRole)))
                .build();
        memberRepository.save(member);
        return MemberResponse.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .name(member.getName())
                .active(member.getActive())
                .roles(member.getRoles())
                .build();


    }

}
