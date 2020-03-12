package com.vivachek.api.back.config;

import com.vivachek.core.domain.rs.ResponseCode;
import com.vivachek.core.domain.rs.ResultResponse;
import com.vivachek.core.exception.AuthenticationException;
import com.vivachek.core.exception.ServiceException;
import com.vivachek.core.utils.ResultResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description 全局异常处理器
 * 暂时先不设置返回头的状态码，统一处理
 * @Author CJB
 * @Date 2020/3/9 23:23
 */
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    /**
     * 业务上的异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {ServiceException.class})
    public ResultResponse onException(ServiceException ex){
      log.error(ex.getMessage());
      return ResultResponseUtils.resultSucess(ex.getCode(),ex.getMessage());
    }


    /**
     * 认证异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {AuthenticationException.class})
    public ResultResponse onException(AuthenticationException ex){
        log.error(ex.getMessage());
        //暂时先统一处理，认证失败
        return ResultResponseUtils.resultSucess(ResponseCode.AUTHENTICATION_ERROR.getCode(),ResponseCode.AUTHENTICATION_ERROR.getMsg());
    }

    /**
     * 处理JSR303校验异常,@Valid抛出的异常
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResultResponse onException(MethodArgumentNotValidException ex){
        log.error(ex.getMessage());
        return ResultResponseUtils.resultFail(ResponseCode.PARAMTER_ERROR);
    }

    /**
     * 通用异常捕捉
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public ResultResponse onException(Exception ex){
        log.error(ex.getMessage());
        return ResultResponseUtils.resultFail(ResponseCode.NOT_KNOWN);
    }




}