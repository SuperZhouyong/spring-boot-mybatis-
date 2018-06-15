/*
package com.resumed.sqtwin.configurer;

import com.github.pagehelper.PageHelper;
import com.resumed.sqtwin.core.ProjectConstant;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

*/
/**
 * @auther Super
 * @data 2018/6/12 0012
 * @time 下午 14:34*//*



*/
/*
*
 * Mybatis & Mapper & PageHelper 配置*//*



@Configuration
@MapperScan(basePackages = {"com.resumed.sqtwin.dao"}, sqlSessionFactoryRef = "sqlSessionFactoryBeanThree")
public class MybatisConfigurerThree {
    private static final String TAG = "MybatisConfigurer";
    private final Logger logger = LoggerFactory.getLogger(MybatisConfigurerThree.class);

    @Autowired
    @Qualifier("oneData")
    private DataSource onedData;

    @Bean
    public SqlSessionFactory sqlSessionFactoryBeanThree() throws Exception {


        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();

        factory.setDataSource(onedData);

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
        return factory.getObject();
    }

  */
/*  @Bean
    public MapperScannerConfigurer mapperScannerConfigurerTwo() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBeanTwo");
        mapperScannerConfigurer.setBasePackage(ProjectConstant.MAPPER_PACKAGE_TWO);
        logger.info("我是第二个数据文件读取");

        //配置通用Mapper，详情请查阅官方文档
        Properties properties = new Properties();
        properties.setProperty("mappers", ProjectConstant.MAPPER_INTERFACE_REFERENCE);
        properties.setProperty("notEmpty", "false");//insert、update是否判断字符串类型!='' 即 test="str != null"表达式内是否追加 and str != ''
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);

        return mapperScannerConfigurer;
    }*//*


 */
/*   @Bean
    public SqlSessionTemplate sqlSessionTemplate2() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryBeanTwo());
        return template;
    }*//*

}
*/
