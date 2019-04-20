package com.doohong.shoesfit.target.dto;

import com.doohong.shoesfit.relation.domain.Relation;
import com.doohong.shoesfit.shoes.domain.Shoes;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@Builder
public class TargetResponse {
    private List<Shoes> shoesList;
    private List<Relation> relationList;
    private TargetDTO targetDTO;
    private List<List<int[]>> targetSizeList;

}
