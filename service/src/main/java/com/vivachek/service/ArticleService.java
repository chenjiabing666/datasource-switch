package com.vivachek.service;

import com.github.pagehelper.PageInfo;
import com.vivachek.core.domain.Article;
import com.vivachek.core.domain.req.ArticleAddReq;
import com.vivachek.core.domain.req.ArticleListReq;
import com.vivachek.core.domain.rs.PageData;

import java.util.List;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/10 14:06
 */
public interface ArticleService {
    void add(ArticleAddReq req);
    PageData<Article> getAll(ArticleListReq req);

    List<Article> getAllByReq(ArticleListReq req);

    List<Article> getAll();


}