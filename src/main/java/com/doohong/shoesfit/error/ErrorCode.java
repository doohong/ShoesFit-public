package com.doohong.shoesfit.error;

import lombok.Getter;

@Getter
public enum ErrorCode {
    // TARGET
    TARGET_NOT_FOUND("TN_001","찾으시는 신발 정보가 없습니다.",404),

    //SHOES
    SHOES_NOT_SAME("SN_001","같은 신발을 검색할 수 없습니다.", 404),

    //COMMON
    INVALID_TYPE_VALUE("IV_001","입력값을 확인해 주세요",404),
    METHOD_NOT_ALLOWED("MN_001","유효하지 않는 URL입니다.",400)
    ;
    private final String code;
    private final String message;
    private final int status;

    ErrorCode(String code, String message, int status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}