package com.doohong.shoesfit.member;

import com.doohong.shoesfit.member.dto.LoginMemberDTO;
import com.doohong.shoesfit.member.dto.LoginMemberResponse;
import com.doohong.shoesfit.member.dto.MemberDTO;
import com.doohong.shoesfit.member.dto.MemberResponse;
import com.doohong.shoesfit.member.repository.MemberRepository;
import com.doohong.shoesfit.member.service.MemberSaveService;
import com.doohong.shoesfit.security.service.CustomUserDetailsService;
import com.doohong.shoesfit.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/member")
public class MemberApi {
    private final MemberSaveService memberSaveService;
    private final CustomUserDetailsService customUserDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;

    @PostMapping(value = "/registration")
    public ResponseEntity<MemberResponse> registration(@RequestBody @Valid MemberDTO memberDTO) {
        return new ResponseEntity<>(memberSaveService.saveMember(memberDTO), HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginMemberResponse> login(@RequestBody @Valid LoginMemberDTO loginMemberDTO) {
        String userName = loginMemberDTO.getUsername();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, loginMemberDTO.getPassword()));
        String token = jwtTokenProvider.createToken(userName, memberRepository.findByEmail(userName).getRoles());
        LoginMemberResponse response = LoginMemberResponse.builder().email(userName).token(token).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
