package com.vivachek.core.domain.rs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 23:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRes{
    private String accessToken;
    private String refreshToken;
    //权限...

}