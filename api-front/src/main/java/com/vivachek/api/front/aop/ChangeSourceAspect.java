package com.vivachek.api.front.aop;

import com.vivachek.api.front.config.DynamicThreadLocalHolder;
import com.vivachek.core.aop.ChangeSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description 切面
 * @Author CJB
 * @Date 2020/3/12 16:18
 */
@Aspect
@Component
@Slf4j
public class ChangeSourceAspect {
    @Pointcut("@annotation(com.vivachek.core.aop.ChangeSource)")
    public void pointcut() {
    }

    /**
     * 在方法执行之前往ThreadLocal中设置值
     */
    @Before(value = "pointcut()")
    public void beforeOpt(JoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        ChangeSource changeSource = method.getAnnotation(ChangeSource.class);
        log.info("[Switch DataSource]:" + changeSource.value());
        DynamicThreadLocalHolder.setDataSource(changeSource.value());
    }

    /**
     * 结束之后清除
     */
    @After(value = "pointcut()")
    public void afterOpt() {
        DynamicThreadLocalHolder.clearDataSource();
        log.info("[change Default DataSource]");
    }

}