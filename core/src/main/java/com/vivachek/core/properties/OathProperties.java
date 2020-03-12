package com.vivachek.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 16:38
 */
@Data
@ConfigurationProperties(prefix = "spring.oath")
public class OathProperties {
    /**
     * 秘钥
     */
    private String secret;

    /**
     * token的签发者
     */
    private String issure;

    /**
     * token的过期时间
     */
    private Long accessTokenExpire;

    /**
     * refreshToken的过期时间
     */
    private Long refreshTokenExpire;


    /**
     * 排除验证的uri
     */
    private String[] headExcludeUri=new String[]{};

    /**
     * 登录验证的uri
     */
    private String [] loginExcludeUri=new String[]{};



}