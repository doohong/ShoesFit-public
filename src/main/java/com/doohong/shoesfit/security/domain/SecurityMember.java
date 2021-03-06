package com.doohong.shoesfit.security.domain;


import com.doohong.shoesfit.member.domain.Member;
import com.doohong.shoesfit.member.domain.MemberRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@ToString

public class SecurityMember extends User {
    private static final String ROLE_PREFIX = "ROLE_";

    public SecurityMember(Member member){

        super(member.getEmail(),member.getPassword(),makeGrantedAuthority(member.getRoles()));
    }
    private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles){
        System.out.println("securityMember");
        System.out.println(roles.toString());
        List<GrantedAuthority> list = new ArrayList<>();
        roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRole())));
        System.out.println(list.toString());
        return list;
    }
}
