package com.vivachek.core.exception;

import lombok.Data;

/**
 * @Description 业务上的异常
 * @Author CJB
 * @Date 2020/3/9 22:02
 */
@Data
public class ServiceException extends RuntimeException {

    private String code;

    public ServiceException(){
        super();
    }

    public ServiceException(String msg,String code){
        super(msg);
        this.code=code;
    }
}