package com.vivachek.core.domain.req;
import lombok.Data;

/** 所有需要分页的请求要继承的类，其中提供了分页需要的参数
 * 默认的映射关系是:pageNum=pageNum;pageSize=pageSize;count=countSql;reasonable=reasonable;pageSizeZero=pageSizeZero
 * 也可在设置拦截器的时候指定映射关系，具体看官方文档
 * https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md
 */
@Data
public class PageParam {
    /**
     * 当前第几页
     */
    private Integer pageNum=1;
    /**
     * 每页查询的数量
     */
    private Integer pageSize=10;
    /**
     * 是否进行count查询，默认是true，查询
     * 如果设置为false，那么总数total将会为-1，不进行count查询
     */
    private Boolean countSql=true;
    /**
     * 分页合理化参数，默认值为false。当该参数设置为 true 时，pageNum<=0 时会查询第一页， pageNum>pages（超过总数时），会查询最后一页。默认false 时，直接根据参数进行查询。
     */
    private Boolean reasonable;
    /**
     * 默认值为 false，当该参数设置为 true 时，如果 pageSize=0 或者 RowBounds.limit = 0 就会查询出全部的结果（相当于没有执行分页查询，但是返回结果仍然是 Page 类型）。
     */
    private Boolean pageSizeZero=true;
}