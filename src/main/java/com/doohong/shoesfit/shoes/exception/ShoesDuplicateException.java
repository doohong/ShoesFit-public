package com.doohong.shoesfit.shoes.exception;

import com.doohong.shoesfit.error.BusinessException;
import com.doohong.shoesfit.error.ErrorCode;

public class ShoesDuplicateException extends BusinessException {

    public ShoesDuplicateException(ErrorCode errorCode){
        super(errorCode);
    }
}
