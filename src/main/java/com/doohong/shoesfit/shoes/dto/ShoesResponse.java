package com.doohong.shoesfit.shoes.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Builder
public class ShoesResponse {
    private Set<String> brandList;
    private Set<String> nameList;
    private Map<String, Set<String>> brandNameList;
}
