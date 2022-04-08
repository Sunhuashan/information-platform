package com.shs.bysj.result;

public class ResultFactory {

    public static Result buildResult(ResultCode resultCode,String msg,Object object) {
        return new Result(resultCode.code,msg,object);
    }

    public static Result buildSuccessResult(Object object) {
        return ResultFactory.buildResult(ResultCode.SUCCESS,"成功",object);
    }

    public static Result buildFailResult(String msg) {
        return ResultFactory.buildResult(ResultCode.FAIL,msg,null);
    }
}
