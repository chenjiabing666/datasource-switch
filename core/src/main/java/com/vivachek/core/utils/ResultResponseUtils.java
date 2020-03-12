package com.vivachek.core.utils;

import com.vivachek.core.domain.rs.ResponseCode;
import com.vivachek.core.domain.rs.ResultResponse;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 21:41
 */
public class ResultResponseUtils {
    /**
     * 请求成功
     */
    public static ResultResponse resultSucess(){
        return new ResultResponse(ResponseCode.OK.getCode(),ResponseCode.OK.getMsg());
    }

    public static ResultResponse resultSucess(String code,String msg){
        return new ResultResponse(code,msg);
    }

    public static ResultResponse resultSucess(ResponseCode responseCode){
        return new ResultResponse(responseCode.getCode(),responseCode.getMsg());
    }

    public static <T> ResultResponse resultSucess(T body){
        return new ResultResponse(ResponseCode.OK.getCode(),ResponseCode.OK.getMsg(),body);
    }

    /**
     * 处理失败异常
     * @return
     */
    public static ResultResponse resultFail(ResponseCode responseCode){
        return new ResultResponse(responseCode.getCode(),responseCode.getMsg());
    }



}