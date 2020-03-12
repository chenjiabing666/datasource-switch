package com.vivachek.core.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/10 13:52
 */
@Data
public class ArticleTotal implements Serializable {
    private static final long serialVersionUID = -8219390724576839941L;
    private String articleId;
    private String ip;
}