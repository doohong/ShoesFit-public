package com.doohong.shoesfit.member.repository;

import com.doohong.shoesfit.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByEmail(String Email);
}
