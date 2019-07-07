package com.doohong.shoesfit.member.domain;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="tbl_user",uniqueConstraints = {
        @UniqueConstraint(columnNames = "member_email")
})
@Builder
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long id;

    @Column(name="member_email")
    private String email;

    @Column(name = "member_password")
    private String password;

    @Column(name = "member_name")
    @NotEmpty(message = "*Please provide your name")
    private String name;

    @Column(name = "member_active")
    private int active;

    @Column(name = "reg_date")
    @CreationTimestamp
    private LocalDateTime regdate;

    @Column(name = "mod_date")
    @UpdateTimestamp
    private LocalDateTime moddate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "member_role", joinColumns = @JoinColumn(name = "member_no"), inverseJoinColumns = @JoinColumn(name = "role_no"))
    private Set<MemberRole> roles;

}
