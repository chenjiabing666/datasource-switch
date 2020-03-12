package com.vivachek.service;

import com.vivachek.core.domain.oath.UserInfoVO;
import com.vivachek.core.domain.req.LoginReq;
import com.vivachek.core.domain.rs.LoginRes;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 21:01
 */
public interface UserService {
    /**
     * 直接从缓存中取，缓存失效了的话，从数据库中查，再存储在缓存中
     * @param userId
     * @return
     */
    UserInfoVO getUserInfoByUserId(String accessToken,String userId);

    /**
     * 登录
     * @param req
     */
    LoginRes login(LoginReq req);

    /**
     * 注册
     * @param req
     */
    void register(LoginReq req);

    UserInfoVO selectByUserId(String id);



}
