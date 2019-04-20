package com.doohong.shoesfit.target.exception;

import com.doohong.shoesfit.error.BusinessException;
import com.doohong.shoesfit.error.ErrorCode;

public class TargetNotFoundException extends BusinessException {
    public TargetNotFoundException(ErrorCode errorCode){
        super(errorCode);
    }

}
