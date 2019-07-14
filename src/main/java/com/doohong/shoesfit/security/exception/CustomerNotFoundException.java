package com.doohong.shoesfit.security.exception;

import com.doohong.shoesfit.error.BusinessException;
import com.doohong.shoesfit.error.ErrorCode;

public class CustomerNotFoundException extends BusinessException {

    public CustomerNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
