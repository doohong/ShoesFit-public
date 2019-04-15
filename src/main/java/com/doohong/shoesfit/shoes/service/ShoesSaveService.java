package com.doohong.shoesfit.shoes.service;

import com.doohong.shoesfit.shoes.ShoesRepository;
import com.doohong.shoesfit.shoes.domain.Shoes;
import com.doohong.shoesfit.target.dto.ShoesDTO;
import com.doohong.shoesfit.target.dto.TargetRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoesSaveService {
    private ShoesRepository shoesRepository;
    public List<Shoes> shoesSave(List<ShoesDTO> shoesDTOList){
        List<Shoes> shoesList = new ArrayList<>();
        for(ShoesDTO shoesDTO : shoesDTOList){
            Shoes shoes = shoesRepository.findByBrandAndNameAndSize(shoesDTO.getBrand(),shoesDTO.getName(),shoesDTO.getSize());
            if(shoes==null){
                shoes= shoesRepository.save(new Shoes(shoesDTO.getBrand(),shoesDTO.getName(),shoesDTO.getSize()));
            }
            shoesList.add(shoes);
        }
        return shoesList;
    }
}
