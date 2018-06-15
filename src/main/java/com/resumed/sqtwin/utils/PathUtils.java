package com.resumed.sqtwin.utils;

import java.io.File;

/**
 * @auther Super
 * @data 2018/5/15 0015
 * @time 下午 16:40
 */
public class PathUtils {
    public static String getRootPath() {
        String line = File.separator;
        String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
        //windows下
        if ("\\".equals(line)) {
            path = path.replace("/", "\\");  // 将/换成\\

        }
        //linux下
        if ("/".equals(line)) {
            path = path.replace("\\", "/");

        }

        return path;
    }
}
