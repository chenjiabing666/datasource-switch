package com.vivachek.core.utils;

import com.vivachek.core.domain.oath.HeadParam;
import com.vivachek.core.domain.oath.RequestConfigInfo;
import com.vivachek.core.domain.oath.UserInfoVO;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 21:35
 */
public class OathUtils {
    /**
     * 获取当前请求的用户信息
     * @return
     */
    public static UserInfoVO getUserInfo(){
        return RequestContextUtil.getReqAttr(RequestConfigInfo.USER_INFO);
    }

    /**
     * 获取请求头的信息
     * @return
     */
    public static HeadParam getHeadParam(){
        return RequestContextUtil.getReqAttr(RequestConfigInfo.HEAD_INFO);
    }
}