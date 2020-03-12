package com.vivachek.api.back.controller;

import com.vivachek.core.domain.req.ArticleAddReq;
import com.vivachek.core.domain.rs.ResultResponse;
import com.vivachek.core.utils.ResultResponseUtils;
import com.vivachek.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/10 10:42
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/add")
    public ResultResponse list(@RequestBody @Valid ArticleAddReq req){
        articleService.add(req);
        return ResultResponseUtils.resultSucess();
    }
}