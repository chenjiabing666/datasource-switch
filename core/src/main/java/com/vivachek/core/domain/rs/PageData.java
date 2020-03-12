package com.vivachek.core.domain.rs;

import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/10 17:13
 */
@Data
public class PageData<T> {
    //当前页
    private Integer pageNum;
    //每页的数量
    private Integer pageSize;
    //当前页的数量
    private Integer size;

    //总记录数
    protected Long    total;
    //结果集
    protected List<T> list;
}