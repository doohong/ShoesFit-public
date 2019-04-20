package com.doohong.shoesfit.target.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@NoArgsConstructor(access= AccessLevel.PACKAGE)
public class ShoesDTO {
    @NotNull
    private String brand;
    @NotNull
    private String name;

    private int size;


    public ShoesDTO(String brand,String name,int size){
        this.brand=brand;
        this.name = name;
        this.size = size;
    }
}
