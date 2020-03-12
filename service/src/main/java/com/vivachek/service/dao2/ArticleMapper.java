package com.vivachek.service.dao2;

import com.vivachek.core.domain.Article;

import java.util.List;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/10 14:07
 */
public interface ArticleMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Article article);

    int insertSelective(Article article);

    int updateByPrimaryKeySelective(Article article);

    List<Article> selectAll();
}
