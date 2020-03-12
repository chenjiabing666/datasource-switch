package com.vivachek.oath.intercept;

import com.vivachek.core.domain.oath.HeadParam;
import com.vivachek.core.domain.oath.RequestConfigInfo;
import com.vivachek.core.exception.HeadInvaildException;
import com.vivachek.core.properties.OathProperties;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.omg.PortableServer.POAPackage.ObjectAlreadyActiveHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.Optional;

/**
 * @Description 请求头拦截器
 * @Author CJB
 * @Date 2020/3/9 17:17
 */
@Component
public class HeadIntercept implements HandlerInterceptor {

    /**
     * 在处理之前拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求头中的数据
        HeadParam headParam = HeadParam.builder()
                .clientId(request.getHeader("clientId"))
                .accessToken(request.getHeader("accessToken"))
                .refreshToken(request.getHeader("refreshToken"))
                .platform(request.getHeader("platform"))
                .build();
        //校验
        if (StringUtils.isAnyEmpty(headParam.getClientId(),headParam.getPlatform()))
            throw new HeadInvaildException();
        //设置在request中
        request.setAttribute(RequestConfigInfo.HEAD_INFO,headParam);
        return true;
    }
}