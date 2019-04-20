package com.doohong.shoesfit.target.exception;

import com.doohong.shoesfit.error.BusinessException;
import com.doohong.shoesfit.error.ErrorCode;

public class TargetDuplicateException extends BusinessException {
    public TargetDuplicateException(ErrorCode errorCode){
        super(errorCode);
    }
}
