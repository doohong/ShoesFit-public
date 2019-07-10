package com.doohong.shoesfit.security;

import com.doohong.shoesfit.member.MemberRepository;
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
        return
                Optional.ofNullable(memberRepository.findByEmail(email))
                .filter(m-> m!=null)
                .map(m -> new SecurityMember(m)).get()


                ;
    }
}
