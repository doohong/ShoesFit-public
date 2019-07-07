package com.doohong.shoesfit.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class LoginMemberDTO {
    private String username;
    private String password;
}
