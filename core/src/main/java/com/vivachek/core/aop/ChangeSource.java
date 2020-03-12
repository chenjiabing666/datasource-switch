package com.vivachek.core.aop;

import java.lang.annotation.*;

/**
 * @Description 切换数据源
 * @Author CJB
 * @Date 2020/3/12 16:15
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ChangeSource {
    /**
     * 数据源，动态数据源默认的是datasource1，这里默认的直接dataSource2
     * @return
     */
    String value() default "dataSource1";
}