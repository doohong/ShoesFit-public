package com.doohong.shoesfit.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler{
    /**
     *
     * Validated로 binding error 발생시 발생한다.
     *
     */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error("handleMethodArgumentNotValidException",e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_TYPE_VALUE, e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(final BusinessException e) {
        log.error("handleBusinessException", e);
        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
    }
//    @ExceptionHandler(Exception.class)
//    protected void handleAllExeption(final Exception e){
//        log.error("exception",e);
//        e.printStackTrace();
//    }

    /**
     *
     * 패스워드 틀렸을 경우 발생
     */
    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity<ErrorResponse> handleBadCredentialsException(final BadCredentialsException e){
        log.error("handleBadCredentialsException",e);
        final ErrorCode errorCode = ErrorCode.LOGIN_FAIL;
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response,HttpStatus.valueOf(errorCode.getStatus()));
    }
}
