package com.doohong.shoesfit.shoes.validation;

import com.doohong.shoesfit.error.ErrorCode;
import com.doohong.shoesfit.shoes.domain.Shoes;
import com.doohong.shoesfit.shoes.exception.ShoesDuplicateException;
import com.doohong.shoesfit.target.dto.ShoesDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class ShoesValidation {
    public boolean validation(List<ShoesDTO> shoesList){
        if(shoesList.size()>=2){
            for(int i=0; i<shoesList.size()-1;i++){
                for(int j=i+1;j<shoesList.size();j++){
                    if(shoesList.get(i).getBrand().equals(shoesList.get(j).getBrand()) && shoesList.get(i).getName().equals(shoesList.get(j).getName())){
                        throw new ShoesDuplicateException(ErrorCode.SHOES_NOT_SAME);
                    }
                }
            }
        }
        return true;
    }
}
