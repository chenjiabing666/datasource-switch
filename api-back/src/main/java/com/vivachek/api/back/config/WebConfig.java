package com.vivachek.api.back.config;

import com.vivachek.core.properties.OathProperties;
import com.vivachek.oath.intercept.HeadIntercept;
import com.vivachek.oath.intercept.LoginIntercept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 21:27
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private HeadIntercept headIntercept;

    @Autowired
    private LoginIntercept loginIntercept;

    @Autowired
    private OathProperties oathProperties;


    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //Swagger需要排除的uri
        final String[] commonExclude={"/error","/files/**","/system/setting/download","/ws/system/getVersion"};
        registry.addInterceptor(headIntercept).excludePathPatterns(oathProperties.getHeadExcludeUri());
        registry.addInterceptor(loginIntercept).excludePathPatterns(oathProperties.getLoginExcludeUri());
//        registry.addInterceptor(permissionInterceptor).excludePathPatterns(ArrayUtils.addAll(swaggerExclude,commonExclude));
    }


    /**
     * 跨域支持
     * @return
     */
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList(CorsConfiguration.ALL));
        corsConfiguration.setAllowedHeaders(Arrays.asList(CorsConfiguration.ALL));
        corsConfiguration.setAllowedMethods(Arrays.asList(CorsConfiguration.ALL));
        source.registerCorsConfiguration("/**", corsConfiguration);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}