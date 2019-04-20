package com.doohong.shoesfit.target.validation;

import com.doohong.shoesfit.error.ErrorCode;
import com.doohong.shoesfit.target.dto.ShoesDTO;
import com.doohong.shoesfit.target.dto.TargetRequest;
import com.doohong.shoesfit.target.exception.TargetDuplicateException;
import org.springframework.stereotype.Component;

@Component
public class TargetVelidation {
    public boolean validation(TargetRequest dto){
        for(ShoesDTO shoesDTO : dto.getShoesList()){
            if(shoesDTO.getBrand().equals(dto.getTarget().getBrand()) && shoesDTO.getName().equals(dto.getTarget().getName())) throw  new TargetDuplicateException(ErrorCode.TARGET_NOT_SAME);
        }
        return true;
    }
}
