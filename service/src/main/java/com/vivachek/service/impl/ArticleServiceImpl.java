package com.vivachek.service.impl;

import com.vivachek.core.aop.ChangeSource;
import com.vivachek.core.domain.Article;
import com.vivachek.core.domain.User;
import com.vivachek.core.domain.oath.UserInfoVO;
import com.vivachek.core.domain.req.ArticleAddReq;
import com.vivachek.core.domain.req.ArticleListReq;
import com.vivachek.core.domain.rs.PageData;
import com.vivachek.core.utils.AssertUtils;
import com.vivachek.core.utils.OathUtils;
import com.vivachek.core.utils.PageUtils;
import com.vivachek.service.ArticleService;
import com.vivachek.service.UserService;
import com.vivachek.service.dao.UserMapper;
import com.vivachek.service.dao2.ArticleMapper;
import org.springframework.aop.config.AopConfigUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/10 14:07
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;



    @Override
    public void add(ArticleAddReq req) {
        Article article = Article.builder()
                .createTime(new Date())
                .status(1)
                .id(UUID.randomUUID().toString())
//                .userId(OathUtils.getUserInfo().getId())
                .build();
        BeanUtils.copyProperties(req,article);
        int i = articleMapper.insertSelective(article);
        AssertUtils.assertTrue(i==1);

        User user = User.builder()
                .id("111")
                .status(1)
                .createTime(new Date())
                .build();
        int j = userMapper.insertUserSelected(user);
//        System.out.println(1/0);
        AssertUtils.assertTrue(j==1);
    }

    @Override
    public PageData<Article> getAll(ArticleListReq req) {
        return PageUtils.getPageInfo(req.getPageNum(),req.getPageSize(),()->articleMapper.selectAll());
    }


    @Override
    @ChangeSource
    public List<Article> getAll() {
        List<Article> articles = articleMapper.selectAll();
        //查询另外一个数据源的数据
//        UserInfoVO infoVO = userService.selectByUserId("e925bf4c-95e1-49e4-bc0e-82146905a519");
        return articles;
    }

    @Override
    public List<Article> getAllByReq(ArticleListReq req) {
        List<Article> articles = articleMapper.selectAll();
        //查询另外一个数据源的数据
        UserInfoVO infoVO = userService.selectByUserId("e925bf4c-95e1-49e4-bc0e-82146905a519");
        return articles;
    }
}