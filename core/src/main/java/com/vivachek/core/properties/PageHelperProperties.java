package com.vivachek.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description 分页插件的参数
 * @Author CJB
 * @Date 2020/3/11 9:48
 */
@ConfigurationProperties(prefix = "mybatis.page")
@Data
public class PageHelperProperties  {
    /**
     * 分页插件会自动检测当前的数据库链接，自动选择合适的分页方式。 你可以配置helperDialect属性来指定分页插件使用哪种方言。配置时，可以使用下面的缩写值：
     * oracle,mysql,mariadb,sqlite,hsqldb,postgresql,db2,sqlserver,informix,h2,sqlserver2012,derby
     */
    private String helperDialect;

    /**
     * 是否进行count查询，默认是true，查询
     * 如果设置为false，那么总数total将会为-1，不进行count查询
     */
    private Boolean countSql=true;
    /**
     * 分页合理化参数，默认值为false。当该参数设置为 true 时，pageNum<=0 时会查询第一页， pageNum>pages（超过总数时），会查询最后一页。默认false 时，直接根据参数进行查询。
     */
    private Boolean reasonable=false;
    /**
     * 默认值为 false，当该参数设置为 true 时，如果 pageSize=0 或者 RowBounds.limit = 0 就会查询出全部的结果（相当于没有执行分页查询，但是返回结果仍然是 Page 类型）。
     */
    private Boolean pageSizeZero=false;

}