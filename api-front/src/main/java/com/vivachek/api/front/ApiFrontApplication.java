package com.vivachek.api.front;

import com.vivachek.core.properties.OathProperties;
import com.vivachek.core.properties.PageHelperProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 13:26
 */
@SpringBootApplication
@EnableAsync
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan(value = {"com.vivachek.api.front","com.vivachek.core","com.vivachek.service","com.vivachek.oath"})
@EnableConfigurationProperties(value = {OathProperties.class, PageHelperProperties.class})
public class ApiFrontApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiFrontApplication.class, args);
    }
}