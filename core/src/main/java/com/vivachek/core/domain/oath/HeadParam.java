package com.vivachek.core.domain.oath;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 17:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HeadParam {
    private String clientId;
    private String platform;
    private String accessToken;
    private String refreshToken;

    /**
     * 平台
     */
    public static class Platform{
        /**
         * 前台接口
         */
        public static final String API_FORNT="1";

        /**
         * 后台接口
         */
        public static final String API_BACK="2";

    }
}