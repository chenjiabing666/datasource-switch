package com.vivachek.core.domain.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/10 14:03
 */
@Data
public class ArticleAddReq {
    /**
     * 内容
     */
    @NotBlank
    private String content;

    /**
     * 关键词
     */
    @NotBlank
    private String keyword;

    /**
     * 标题
     */
    @NotBlank
    private String title;

    /**
     * 标签id
     */
    @NotBlank
    private String tagId;
}