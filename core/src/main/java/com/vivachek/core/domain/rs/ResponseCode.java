package com.vivachek.core.domain.rs;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 21:44
 */
public enum  ResponseCode {

    OK("200","请求成功"),
    ACCOUNT_PWD_NOT_TURE("10001","账号或者密码不正确"),
    ACCOUNT_EXIST("1002","账号已经注册过！"),
    //断言存在的异常
    SERVICE_EROOR("1003","业务异常！"),
    AUTHENTICATION_ERROR("1004","认证异常！"),
    NOT_KNOWN("1005","业务未知异常，建议联系管理员处理！"),
    PARAMTER_ERROR("1006","客户端参数传递错误，建议认真检查入参！");


    private String code;

    private String msg;

    ResponseCode(String code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}