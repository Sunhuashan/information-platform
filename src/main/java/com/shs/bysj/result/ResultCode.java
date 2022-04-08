package com.shs.bysj.result;

public enum ResultCode {

    SUCCESS(200),
    FAIL(400),
    UNAUTHORIZED(403),
    NOT_FOUND(404);


    public int code;

    ResultCode(int code) {
        this.code = code;
    }

}
