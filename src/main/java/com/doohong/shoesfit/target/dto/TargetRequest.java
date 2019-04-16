package com.doohong.shoesfit.target.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor(access= AccessLevel.PACKAGE)
public class TargetRequest {
    @NotNull
    @Valid
    private List<ShoesDTO> shoesList;

    @Valid
    private TargetDTO tartget;


}
