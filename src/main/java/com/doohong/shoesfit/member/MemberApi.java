package com.doohong.shoesfit.member;

import com.doohong.shoesfit.member.dto.LoginMemberDTO;
import com.doohong.shoesfit.member.dto.MemberDTO;
import com.doohong.shoesfit.member.dto.MemberResponse;
import com.doohong.shoesfit.member.service.MemberSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/member")
public class MemberApi {
    private final MemberSaveService memberSaveService;
    @PostMapping(value = "/registration")
    public ResponseEntity<MemberResponse> registration(@RequestBody @Valid MemberDTO memberDTO){
        return new ResponseEntity<>(memberSaveService.saveMember(memberDTO), HttpStatus.OK);
    }


}