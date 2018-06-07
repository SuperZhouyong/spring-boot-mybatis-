package com.resumed.sqtwin.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @auther Super
 * @data 2018/4/13 0013
 * @time 上午 11:14
 */
public class ImageUtil {
    /**
     * 保存文件，直接以multipartFile形式
     * @param multipartFile
     * @param path 文件保存绝对路径
     * @return 返回文件名
     * @throws IOException
     */
    public static String saveImg(MultipartFile multipartFile, String path,String NewfileName) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //http://192.168.0.77/zd_1000019_RD19902021517814554/1517900940_1000019_RD19902021517814554.png
        // Constants.getUUID()
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        String fileName = NewfileName+ ".png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }
}
