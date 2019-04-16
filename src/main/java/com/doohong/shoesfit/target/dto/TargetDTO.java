package com.doohong.shoesfit.target.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@NoArgsConstructor(access= AccessLevel.PACKAGE)
public class TargetDTO {
    @NotNull
    private String brand;
    @NotNull
    private String name;
}
