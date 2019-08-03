package com.doohong.shoesfit.security.service;

import com.doohong.shoesfit.error.ErrorCode;
import com.doohong.shoesfit.member.domain.Member;
import com.doohong.shoesfit.member.repository.MemberRepository;
import com.doohong.shoesfit.security.domain.SecurityMember;
import com.doohong.shoesfit.security.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email);

        if(member ==null){
            System.out.println("null");

        }
       return new SecurityMember(Optional.ofNullable(memberRepository.findByEmail(email)).orElseThrow(() -> new CustomerNotFoundException(ErrorCode.LOGIN_FAIL)));
    }
}
