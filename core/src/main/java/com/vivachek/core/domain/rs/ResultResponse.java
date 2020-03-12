package com.vivachek.core.domain.rs;

import lombok.Data;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 15:11
 */
@Data
public class ResultResponse<T> {
    private String code;
    private T body;
    private String msg;

    public ResultResponse(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public ResultResponse(String code,String msg,T body){
        this.code=code;
        this.body=body;
    }

    public ResultResponse(){}

}