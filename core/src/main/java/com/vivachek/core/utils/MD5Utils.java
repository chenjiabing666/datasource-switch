package com.vivachek.core.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 22:10
 */
public class MD5Utils {
    public static String encode(String pwd,String salt){
        Md5Hash md5Hash = new Md5Hash(pwd,salt);
        return md5Hash.toHex();
    }
}