package com.doohong.shoesfit.member.dto;

import com.doohong.shoesfit.member.domain.MemberRole;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class LoginMemberResponse {
    private String email;
    private String password;
    private String name;
    private List<MemberRole> roles;
    private String token;
}
