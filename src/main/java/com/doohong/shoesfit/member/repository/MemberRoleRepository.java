package com.doohong.shoesfit.member.repository;

import com.doohong.shoesfit.member.domain.MemberRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRoleRepository extends JpaRepository<MemberRole,Long> {
    MemberRole findByRole(String role);
}
