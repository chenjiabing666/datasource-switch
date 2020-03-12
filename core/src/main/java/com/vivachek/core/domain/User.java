package com.vivachek.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 14:58
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private String id;
    private String name;
    private Integer gender;
    private String account;
    private String password;
    private String salt;
    private Integer role;
    private Integer type;
    private Date createTime;
    private Date updateTime;
    private Integer status;
}