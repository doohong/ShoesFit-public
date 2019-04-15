package com.doohong.shoesfit.shoes.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
public class ShoesResponse {
    private Set<String> brandSet;
    private Set<String> nameSet;
    private Map<String, Set<String>> brandNameMap;
}
