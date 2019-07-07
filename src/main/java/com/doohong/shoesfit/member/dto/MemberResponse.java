package com.doohong.shoesfit.member.dto;


import com.doohong.shoesfit.member.domain.MemberRole;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Builder
public class MemberResponse {
    private String email;
    private String password;
    private String name;
    private int active;
    private LocalDateTime regdate;
    private LocalDateTime moddate;
    private List<MemberRole> roles;
}
