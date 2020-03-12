package com.vivachek.core.utils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * 异步执行需要保存request变量，不要直接使用
 */
public class RequestContextUtil {

    public static HttpServletRequest getRequest(){
        return  ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public static HttpServletResponse getResponse(){
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
    }
    public static <T> T getReqAttr(HttpServletRequest request, String name){
        Object obj = request.getAttribute(name);
        if(obj!=null){
            return (T)obj;
        }
        return null;
    }

    public static <T> T getReqAttr(String name){
        HttpServletRequest request = getRequest();
        Object obj = request.getAttribute(name);
        if(obj!=null){
            return (T)obj;
        }
        return null;
    }


    public static <T> T  getSesAttr(HttpServletRequest request,String name){
        Object obj = request.getSession().getAttribute(name);
        if(obj!=null){
            return (T)obj;
        }
        return null;
    }


    public static <T> T  getSesAttr(String name){
        HttpServletRequest request =  getRequest();
        Object obj = request.getSession().getAttribute(name);
        if(obj!=null){
            return (T)obj;
        }
        return null;
    }

}
