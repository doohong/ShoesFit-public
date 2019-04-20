package com.doohong.shoesfit.relation;

import com.doohong.shoesfit.relation.domain.Relation;
import com.doohong.shoesfit.shoes.domain.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationRepository extends JpaRepository<Relation,Integer> {
    Relation findByShoes1AndShoes2(Shoes shoes1,Shoes shoes2);
}
