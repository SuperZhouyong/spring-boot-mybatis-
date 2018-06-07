package com.resumed.sqtwin.configurer;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @auther Super
 * @data 2018/4/10 0010
 * @time 下午 14:36
 */
public class DynamicDataSource  extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getType();
    }
}
