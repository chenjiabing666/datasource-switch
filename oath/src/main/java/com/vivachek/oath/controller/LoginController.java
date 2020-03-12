package com.vivachek.oath.controller;

import com.vivachek.core.domain.req.LoginReq;
import com.vivachek.core.domain.rs.ResultResponse;
import com.vivachek.core.utils.ResultResponseUtils;
import com.vivachek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 21:39
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResultResponse login(@RequestBody @Valid LoginReq req){
        return ResultResponseUtils.resultSucess(userService.login(req));
    }

    @PostMapping("/register")
    public ResultResponse register(@RequestBody @Valid LoginReq req){
        userService.register(req);
        return ResultResponseUtils.resultSucess();
    }

}