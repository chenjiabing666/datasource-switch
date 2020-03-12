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
 * @Date 2020/3/10 13:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article implements Serializable {
    private static final long serialVersionUID = -6369030099472440115L;
    private String id;

    /**
     * 标题
     */
    private String title;

    private Date createTime;

    /**
     * 1 通过 0 没通过
     */
    private Integer status;

    private Date updateTime;

    /**
     * 发布者id
     */
    private String userId;

    /**
     * 标签id
     */
    private String tagId;

    /**
     * 关键词 多个用英文逗号分隔
     */
    private String keyword;
    private String content;
}