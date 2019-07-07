package com.doohong.shoesfit.member.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user_role")
@Builder
@Getter
public class MemberRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_no")
    private Long id;

    @Column(name="role_role")
    private String role;
}
