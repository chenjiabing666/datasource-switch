package com.vivachek.api.front.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.google.common.collect.Maps;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @Description 数据源的配置
 * @Author CJB
 * @Date 2020/3/9 13:45
 */
@Configuration
@MapperScan(basePackages = {"com.vivachek.service.dao","com.vivachek.service.dao2"})
public class DatasourceConfig {

    /**
     * 注入数据源1
     */
    @ConfigurationProperties(prefix = "spring.datasource1")
    @Bean(value = "dataSource1")
    public DataSource dataSource1() {
        return new DruidDataSource();
    }

    /**
     * 第二个数据源
     */
    @Bean(name = "dataSource2")
    @ConfigurationProperties(prefix = "spring.datasource2")
    public DataSource dataSource2() {
        return new DruidDataSource();
    }

    /**
     * 动态数据源
     *
     * @return
     */
    @Bean
    @Primary
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        //默认数据源，在没有切换数据源的时候使用该数据源
        dataSource.setDefaultTargetDataSource(dataSource2());
        HashMap<Object, Object> map = Maps.newHashMap();
        map.put("dataSource1", dataSource1());
        map.put("dataSource2", dataSource2());
        //设置数据源Map，动态切换就是根据key从map中获取
        dataSource.setTargetDataSources(map);
        return dataSource;
    }
}