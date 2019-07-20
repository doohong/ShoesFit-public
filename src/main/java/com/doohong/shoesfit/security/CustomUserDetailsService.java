package com.doohong.shoesfit.security;

import com.doohong.shoesfit.error.ErrorCode;
import com.doohong.shoesfit.member.MemberRepository;
import com.doohong.shoesfit.member.domain.Member;
import com.doohong.shoesfit.security.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return new SecurityMember(Optional.ofNullable(memberRepository.findByEmail(email)).orElseThrow(() -> new CustomerNotFoundException(ErrorCode.LOGIN_FAIL)));
    }
}
