package com.doohong.shoesfit.member.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tbl_user",uniqueConstraints = {
        @UniqueConstraint(columnNames = "member_email")
})

@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)

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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "member_role", joinColumns = @JoinColumn(name = "member_no"), inverseJoinColumns = @JoinColumn(name = "role_no"))
    private List<MemberRole> roles;

    @Builder
    public Member(String email, String password, @NotEmpty(message = "*Please provide your name") String name, List<MemberRole> roles,int active) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.roles = roles;
        this.active = active;
    }
}
