package com.vivachek.core.utils;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 16:37
 */

import com.vivachek.core.domain.jwt.JwtDomain;
import io.jsonwebtoken.*;

import java.util.Date;

/**
 * JWT的工具类
 */
public class JwtUtils {
    /**
     * 生成token
     */
    public static String createJWT(JwtDomain jwtDomain ){
        JwtBuilder builder = Jwts.builder()
                .setId(jwtDomain.getJti())   //jwt面向对象的id，clientId
                .setIssuedAt(jwtDomain.getIssAt())  //用户登录的日期
                //签发者，在验证token的时候需要验证
                .setIssuer(jwtDomain.getIssure())
                .setSubject(jwtDomain.getSub())//用户名
                .setExpiration(jwtDomain.getExpireAt())  //设置过期时间
                .signWith(SignatureAlgorithm.HS256, jwtDomain.getSecret()); //指定签名的算法和秘钥（盐）
        return builder.compact();
    }

    /**
     * 解析
     * @param token
     * @param secret
     * @return
     * @throws
     */
    public static JwtDomain parse(String token,String secret)throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)  //设置解析的秘钥
                .parseClaimsJws(token)  //解析的token
                .getBody();
        return JwtDomain.builder()
                .jti(claims.getId())
                .expireAt(claims.getExpiration())
                .issAt(claims.getIssuedAt())
                .sub(claims.getSubject())
                .issure(claims.getIssuer())
                .build();

    }

}