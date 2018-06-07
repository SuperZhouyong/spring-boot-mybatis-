package com.resumed.sqtwin.configurer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @auther Super
 * @data 2018/4/10 0010
 * @time 下午 16:22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.METHOD
})
public @interface DS {
    String value() default DataSourceContextHolder.One;
}
