package com.vivachek.core.domain.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 21:52
 */
@Data
public class LoginReq {

    @NotBlank
    private String account;

    @NotBlank
    private String password;
}