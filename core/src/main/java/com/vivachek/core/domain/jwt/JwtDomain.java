package com.vivachek.core.domain.jwt;

import lombok.*;

import java.util.Date;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 17:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtDomain {
    /**
     * 用户id
     */
    private String sub;

    /**
     * clientId
     */
    private String jti;
    /**
     * 登录日期
     */
    private Date issAt;

    /**
     * 过期时间
     */
    private Date expireAt;

    /**
     * 签发者
     */
    private String issure;


    /**
     * 秘钥
     */
    private String secret;
}