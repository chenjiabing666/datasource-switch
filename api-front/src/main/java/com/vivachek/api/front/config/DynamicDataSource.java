package com.vivachek.api.front.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Description 动态数据源的实现
 * @Author CJB
 * @Date 2020/3/12 14:27
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 决定使用哪个数据源
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        //从ThreadLocal中获取数据源的beanName
        return DynamicThreadLocalHolder.getDataSource();
    }
}