package com.doohong.shoesfit.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberDTO {
    private String email;
    private String password;
    private String name;



}
