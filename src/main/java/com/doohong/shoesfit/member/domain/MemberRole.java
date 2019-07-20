package com.doohong.shoesfit.member.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user_role")

@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class MemberRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_no")
    private Long id;


    @Column(name="role_role")
    private String role;

    @Builder
    public MemberRole(String role) {
        this.role = role;
    }
}
