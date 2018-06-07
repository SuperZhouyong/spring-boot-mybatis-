package com.resumed.sqtwin.configurer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * @auther Super
 * @data 2018/4/10 0010
 * @time 下午 14:38
 */
public class DataSourceContextHolder {
    public static final String One = "one";
    public static final String Two = "two";
    public static final String DEFAULT_DS = "one";
    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceContextHolder.class);
    public static final List<Object> supportList = new ArrayList<>();
    // 线程本地环境
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setType(String type) {
        contextHolder.set(type);
        LOGGER.debug("==============切换数据源，类型：" + type + "================");
    }

    public static String getType() {
        return (contextHolder.get());
    }

    public static void clear() {
        contextHolder.remove();
    }

    public static boolean support(String type) {
        return supportList.contains(type);
    }


}
