package com.doohong.shoesfit.shoes.service;

import com.doohong.shoesfit.shoes.ShoesRepository;
import com.doohong.shoesfit.shoes.domain.Shoes;
import com.doohong.shoesfit.shoes.dto.ShoesResponse;
import com.doohong.shoesfit.target.dto.TargetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ShoesService {
    private final ShoesRepository shoesRepository;

    public ShoesResponse getShoesList(){
        Set<String> brandSet = new HashSet<>();
        Set<String> nameSet = new HashSet<>();
        Map<String,Set<String>> brandNameMap = new HashMap<>();
        for(Shoes shoes : shoesRepository.findAll()){
            brandSet.add(shoes.getBrand());
            nameSet.add(shoes.getName());
            if(!brandNameMap.containsKey(shoes.getBrand())){
                brandNameMap.put(shoes.getBrand(),new HashSet<>());
            }
            Set<String> brandNameSet = brandNameMap.get(shoes.getBrand());
            brandNameSet.add(shoes.getName());
            brandNameMap.put(shoes.getBrand(),brandNameSet);
        }
        return ShoesResponse.builder().brandSet(brandSet).nameSet(nameSet).brandNameMap(brandNameMap).build();

    }
    public List<Shoes> findTargetList(TargetDTO targetDTO){
        return shoesRepository.findByBrandAndName(targetDTO.getBrand(),targetDTO.getName());

    }

    public int getShoesMaxIndex(){
        return shoesRepository.findMaxId();
    }


}
