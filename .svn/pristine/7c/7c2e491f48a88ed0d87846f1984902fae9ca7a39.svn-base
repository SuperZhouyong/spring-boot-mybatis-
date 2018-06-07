package com.resumed.sqtwin.utils;


import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.InputStream;

/**
 * @auther Super
 * @data 2018/4/13 0013
 * @time 下午 14:36
 */
public class FtpUpdateUtil {

    //图片路径

   /* @Value("${img.location}")
    private static  String location;*/
//    private static final String FTP_BASEPATH = "/home/ftpadmin/health/images";

    public static boolean uploadFile(String originFileName, InputStream input,String Directory) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("GBK");
        try {
            int reply;
            ftp.connect(AppConstant.FTP_ADDRESS, AppConstant.FTP_PORT);// 连接FTP服务器
            ftp.login(AppConstant.FTP_USERNAME, AppConstant.FTP_PASSWORD);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(Directory);
            ftp.changeWorkingDirectory(Directory);
            ftp.storeFile(originFileName, input);
            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

}
