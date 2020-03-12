package com.vivachek.core.utils;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vivachek.core.domain.req.PageParam;
import com.vivachek.core.domain.rs.PageData;
import org.springframework.beans.BeanUtils;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/10 16:09
 */
public class PageUtils {
    /**
     * 此处pageNum和pageSize直接作为参数，这里就不封装了，自己可以根据条件封装一下
     * @param pageNum
     * @param pageSize
     * @param iSelect
     * @param <T>
     * @return
     */
    public static <T>PageData<T> getPageInfo(Integer pageNum,Integer pageSize,ISelect iSelect){
        PageInfo<Object> pageInfo = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(iSelect);
        PageData<T> data = new PageData<>();
        BeanUtils.copyProperties(pageInfo,data);
        return data;
    }

}