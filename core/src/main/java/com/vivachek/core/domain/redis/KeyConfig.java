package com.vivachek.core.domain.redis;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 21:07
 */
public interface KeyConfig {

    /**
     * accessToken存储的Key
     */
    String ACCESS_TOKEN_KEY_PREFIX="blog:accessToken";

    /**
     * refreshToken存储的Key
     */
    String REFRESH_TOKEN_KEY_PREFIX="blog:refreshToken";
}