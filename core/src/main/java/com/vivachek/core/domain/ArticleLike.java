package com.vivachek.core.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/10 13:55
 */
@Data
public class ArticleLike implements Serializable {
    private static final long serialVersionUID = 2445491763231505618L;
    private String articleId;
    private String ip;
    private Date createTime;
    private Date updateTime;
}