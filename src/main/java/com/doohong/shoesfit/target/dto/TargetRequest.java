package com.doohong.shoesfit.target.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor(access= AccessLevel.PACKAGE)
@ToString
public class TargetRequest {
    @NotNull
    @Valid
    private List<ShoesDTO> shoesList;

    @NotNull
    @Valid
    private TargetDTO target;

    public TargetRequest(List<ShoesDTO> shoesList, TargetDTO target){
        this.shoesList = shoesList;
        this.target = target;
    }

}
