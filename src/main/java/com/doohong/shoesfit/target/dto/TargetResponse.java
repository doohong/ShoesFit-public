package com.doohong.shoesfit.target.dto;

import com.doohong.shoesfit.relation.domain.Relation;
import com.doohong.shoesfit.shoes.domain.Shoes;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
public class TargetResponse {
    private List<Shoes> shoesList;
    private List<Relation> relationList;
    private targetDTO targetDTO;

}
