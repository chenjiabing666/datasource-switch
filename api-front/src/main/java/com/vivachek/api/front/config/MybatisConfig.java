package com.vivachek.api.front.config;

import com.github.pagehelper.PageInterceptor;
import com.vivachek.core.properties.PageHelperProperties;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/10 15:24
 */
//@Configuration
public class MybatisConfig {

    private PageHelperProperties pageHelperProperties;

    public MybatisConfig(ObjectProvider<PageHelperProperties> objectProvider){
        this.pageHelperProperties=objectProvider.getIfUnique();
    }

    /**
     * 注入分页插件，springBoot会将注入的插件自动设置到sqlSessionFactory中
     */
    @Bean
    public Interceptor pageInterceptor(){
        PageInterceptor pageInterceptor = new PageInterceptor();
        //加载配置
        Properties properties = new Properties();
        //方言不设置可以自动选择
        if (StringUtils.isNotBlank(pageHelperProperties.getHelperDialect()))
            properties.setProperty("helperDialect",pageHelperProperties.getHelperDialect());
        properties.setProperty("countSql", String.valueOf(pageHelperProperties.getCountSql()));
        properties.setProperty("reasonable",pageHelperProperties.getHelperDialect());
        properties.setProperty("pageSizeZero",pageHelperProperties.getHelperDialect());
        //设置参数
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}