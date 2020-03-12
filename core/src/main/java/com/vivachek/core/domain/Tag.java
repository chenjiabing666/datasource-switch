package com.vivachek.core.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 标签
 * @Author CJB
 * @Date 2020/3/10 13:53
 */
@Data
public class Tag implements Serializable {
    private static final long serialVersionUID = 6259073487914160035L;
    private String id;
    private String name;
    private Long total;
    private Integer status;
    private Date createTime;
    private Date updateTime;
}