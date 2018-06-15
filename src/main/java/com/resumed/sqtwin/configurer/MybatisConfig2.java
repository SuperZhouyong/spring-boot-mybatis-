package com.resumed.sqtwin.configurer;


import com.github.pagehelper.PageHelper;
import com.resumed.sqtwin.core.ProjectConstant;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
//@MapperScan(basePackages = "com.resumed.sqtwin.dao.mappertwo", sqlSessionFactoryRef   = "sqlSessionFactory2")
public class MybatisConfig2 {
    private final Logger logger = LoggerFactory.getLogger(MybatisConfig2.class);
    private static final String TAG = "MybatisConfig2";

    @Autowired
    @Qualifier("twoData")
    private DataSource twoData;

    @Bean(name = "sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory2(@Qualifier("twoData") DataSource dataSource) throws Exception {
        logger.info(TAG + "ssssss-----------" + "sqlSessionFactoryBeanTWO++++++++++++");
        SqlSessionFactoryBean factory2 = new SqlSessionFactoryBean();
        factory2.setDataSource(dataSource);
        factory2.setTypeAliasesPackage(ProjectConstant.MODEL_PACKAGE);
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory2.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        return factory2.getObject();

    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer2() {
        MapperScannerConfigurer mapperScannerConfigurer2 = new MapperScannerConfigurer();
        mapperScannerConfigurer2.setSqlSessionFactoryBeanName("sqlSessionFactory2");
        mapperScannerConfigurer2.setBasePackage(ProjectConstant.MAPPER_PACKAGE_TWO);
        //配置通用Mapper，详情请查阅官方文档
        Properties properties = new Properties();
        properties.setProperty("mappers", ProjectConstant.MAPPER_INTERFACE_REFERENCE);
        properties.setProperty("notEmpty", "false");//insert、update是否判断字符串类型!='' 即 test="str != null"表达式内是否追加 and str != ''
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer2.setProperties(properties);
        return mapperScannerConfigurer2;
    }
    }
   /* @Bean
    public SqlSessionTemplate sqlSessionTemplate2() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory2());
        return template;
    }
    @Bean(name = "anotherTransactionManager")
    public DataSourceTransactionManager customTransactionManager(@Qualifier("twoData") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }*/

  /*  @Bean
    public SqlSessionTemplate sqlSessionTemplate2() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory2());
        return template;
    }*/
   /* @Bean(name = "anotherDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource customDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "anotherSqlSessionFactory")
    public SqlSessionFactory customSqlSessionFactory(@Qualifier("anotherDataSource") DataSource dataSource) throws Exception {
        logger.info(TAG+"ssssss-----------"+"sqlSessionFactoryBeanON++++++++++++");
//        System.out.println(TAG+"-------------------");
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);

//        factory.setDataSource(dataSource());
        factory.setTypeAliasesPackage(ProjectConstant.MODEL_PACKAGE);

        //配置分页插件，详情请查阅官方文档
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("pageSizeZero", "true");//分页尺寸为0时查询所有纪录不再执行分页
        properties.setProperty("reasonable", "true");//页码<=0 查询第一页，页码>=总页数查询最后一页
        properties.setProperty("supportMethodsArguments", "true");//支持通过 Mapper 接口参数来传递分页参数
        pageHelper.setProperties(properties);

        //添加插件
        factory.setPlugins(new Interceptor[]{pageHelper});

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));

      *//*  SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));*//*
        return factory.getObject();
    }

    @Bean(name = "anotherTransactionManager")
    public DataSourceTransactionManager customTransactionManager(@Qualifier("anotherDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "anotherSqlSessionTemplate")
    public SqlSessionTemplate customSqlSessionTemplate(@Qualifier("anotherSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }*/



