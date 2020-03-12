package com.vivachek.core.utils;

import com.vivachek.core.domain.rs.ResponseCode;
import com.vivachek.core.exception.ServiceException;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 22:02
 */
public class AssertUtils {
    public static void assertTrue(boolean b){
        if (!b)
            throw new ServiceException(ResponseCode.SERVICE_EROOR.getMsg(),ResponseCode.SERVICE_EROOR.getCode());
    }

    public static void assertTrue(boolean b, ResponseCode responseCode){
        if (!b)
            throw new ServiceException(responseCode.getMsg(),responseCode.getCode());
    }
}