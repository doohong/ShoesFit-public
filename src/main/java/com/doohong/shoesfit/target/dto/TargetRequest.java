package com.doohong.shoesfit.target.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor(access= AccessLevel.PACKAGE)
public class TargetRequest {
    @Valid
    private List<ShoesDTO> shoesList;


    @Valid
    private targetDTO tartget;


}
