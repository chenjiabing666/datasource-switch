package com.vivachek.oath.intercept;

import com.vivachek.core.domain.jwt.JwtDomain;
import com.vivachek.core.domain.oath.HeadParam;
import com.vivachek.core.domain.oath.RequestConfigInfo;
import com.vivachek.core.domain.oath.UserInfoVO;
import com.vivachek.core.exception.TokenInvalidException;
import com.vivachek.core.properties.OathProperties;
import com.vivachek.core.utils.JwtUtils;
import com.vivachek.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 登录的拦截器，token的校验
 * @Author CJB
 * @Date 2020/3/9 17:44
 */
@Component
public class LoginIntercept implements HandlerInterceptor {

    @Autowired
    private OathProperties oathProperties;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //校验token
        HeadParam headParam= (HeadParam) request.getAttribute(RequestConfigInfo.HEAD_INFO);
        String accessToken = headParam.getAccessToken();
        //解析
        JwtDomain jwtDomain;
        try {
            jwtDomain=JwtUtils.parse(accessToken, oathProperties.getSecret());
        }catch (Exception ex){
            //解析失败就是token过期
            throw new TokenInvalidException();
        }
        //验证,如果签发者不同
        if (!StringUtils.equals(jwtDomain.getIssure(),oathProperties.getIssure())){
            throw new TokenInvalidException();
        }
        //根据token的信息查询用户的相关信息，保存在request中
        UserInfoVO userInfo = userService.getUserInfoByUserId(accessToken,jwtDomain.getSub());
        if (userInfo==null)
            //此处用户不存在，暂时报token失效，让其重新登录
            throw new TokenInvalidException();
        //设置个人信息在request中
        request.setAttribute(RequestConfigInfo.USER_INFO,userInfo);
        return true;
    }
}