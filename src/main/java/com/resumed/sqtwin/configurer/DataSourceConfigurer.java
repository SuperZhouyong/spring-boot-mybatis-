package com.resumed.sqtwin.configurer;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Maps;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Map;


/**
 * @auther Super
 * @data 2018/4/10 0010
 * @time 下午 16:35
 */

@Configuration
public class DataSourceConfigurer {
    private final Logger logger = LoggerFactory.getLogger(DataSourceConfigurer.class);

    @Bean(name = "oneData")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.one")
    public DataSource oneDataSource() {
//        System.out.println("主配");
        logger.info("主配");
        return DataSourceBuilder
                .create()
//                .type(DruidDataSource.class)
                .build();
    }

    @Bean(name = "twoData")
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource twoDataSource() {
        logger.info("从配");
        return DataSourceBuilder
                .create()
//                .type(DruidDataSource.class)
                .build();
    }

   /* @Primary
    @Bean(name = "dynamicDS")
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = Maps.newHashMap();
        targetDataSources.put("one", oneDataSource());
        targetDataSources.put("two", twoDataSource());
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(targetDataSources.get("one"));
        DataSourceContextHolder.supportList.addAll(targetDataSources.keySet());

        return dynamicDataSource;
    }*/
}
