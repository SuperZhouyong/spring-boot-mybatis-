package com.resumed.sqtwin.utils;

import com.resumed.sqtwin.model.bean.SMSRetObj;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Random;
/*
 *
 *
 *
 * */

/**
 * @auther Super
 * @data 2018/4/11 0011
 * @time 上午 11:43
 */
public class MessageUtil {

    private static final Logger logger = LoggerFactory.getLogger(MessageUtil.class);

    //    private static String userName = "souqiantu";
//    private static String passWord = "100007";


    public SMSRetObj sendByTpl(String cell, Object... args) {
        String tpl = AppConstant.MERGE_MSG;
        int codeNum = RandomUtils.nextInt(1000, 10000);
        tpl=tpl.replace("XXXX",codeNum+"");
        String content = tpl;
//        String code =RandomUtils.nextInt(1000,9999)+"" ;
        try {
            content = String.format(tpl, args);
            logger.info("sendByTpl cell:{} ,content:{}", cell, content);
        } catch (Exception e) {
            logger.info("短信模板错误。 tpl:{} args:{}", tpl, args);
        }
        return sendMessage(cell, content,String.valueOf(codeNum));
    }

    public SMSRetObj sendMessage(String cell, String content,String smsCodeNUm) {

        SMSRetObj retObj = new SMSRetObj();
        if (StringUtils.isEmpty(cell) || StringUtils.isEmpty(content)) {
            logger.info("SMS bad params -- cell:{} content:{}", cell, content);
            retObj.setMsg("短信参数为空");
            return retObj;
        }

      /*  OkHttp3ClientHttpRequestFactory okHttp3ClientHttpRequestFactory = new OkHttp3ClientHttpRequestFactory();
        URI uri = URI.create(postUrl);*/


        RequestBody requestBody = new RequestBody() {
            @Override
            public MediaType contentType() {
                return MediaType.parse("application/x-www-form-urlencoded");
            }

            @Override
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                StringBuilder pb = new StringBuilder();
                pb.append("userid=&account=").append(AppConstant.userName).append("&password=").append(AppConstant.passWord).append("&mobile=")
                        .append(cell).append("&sendTime=&content=").append(content);
                String postData = pb.toString();

                bufferedSink.writeUtf8(postData);
            }
        };
        Request mRequest = new Request.Builder()
                .url(AppConstant.postUrl)
                .post(requestBody)
                .build();
        try {
            //  Response mResponse = 异步发送请求，不需要管发送成功没有
           ApiUtil.getApi().newCall(mRequest).execute();
            retObj.setReturnCode(1);
            retObj.setMsg(smsCodeNUm);
          /*  if (!mResponse.isSuccessful())
                throw new IOException("Unexpected code " + mResponse);

            String string = mResponse.body().string();
            Document doc = DocumentHelper.parseText(string);
            Element root = doc.getRootElement();
            String returnstatus = root.elementText("returnstatus");
            String message = root.elementText("message");
//            String SmsCode = root.elementText("remainpoint");
            if (returnstatus.equals("Success")) {
                retObj.setReturnCode(1);
                retObj.setMsg(smsCodeNUm);
            } else {
                retObj.setMsg(message);
            }*/
//            int i = 3/ 0 ;
//            logger.info("数据返回22222+++++++++" +Thread.currentThread().getName()+ string);
          /*  new Thread(new Runnable() {
                @Override
                public void run() {
                    logger.info("数据返回22222++++++++" +Thread.currentThread().getName());
                }
            }).start();*/
//          |DocumentException | IOException
        } catch (IOException e) {
            e.printStackTrace();
            retObj.setReturnCode(-1);
        }
        return retObj;

    /*    SMSRetObj retObj = new SMSRetObj();

        if (StringUtils.isEmpty(cell) || StringUtils.isEmpty(content)) {
            logger.info("SMS bad params -- cell:{} content:{}", cell, content);
            retObj.setMsg("短信参数为空");
            return retObj;
        }

        try {

            StringBuilder pb = new StringBuilder();
            pb.append("userid=&account=").append(userName).append("&password=").append(passWord).append("&mobile=")
                    .append(cell).append("&sendTime=&content=").append(content);
            String postData = pb.toString();

            //发送POST请求
            URL url = new URL(postUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setDoOutput(true);




            conn.setRequestProperty("Content-Length", "" + postData.length());
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(postData);
            out.flush();
            out.close();

            //获取响应状态
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                logger.error("SMS connect failed! cell:{} content:{}", cell, content);
            }
            //获取响应内容体
            String line, result = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();

            //			System.out.println(result);

            Document doc = null;
            try {
                doc = DocumentHelper.parseText(result);
            } catch (DocumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } // 将字符串转为XML

            Element root = doc.getRootElement();
            String returnstatus = root.elementText("returnstatus");
            String message = root.elementText("message");

            if (returnstatus.equals("Success")) {
                retObj.setReturnCode(1);
            } else {
                retObj.setMsg(message);
            }

            logger.info("result:{} num:******{} msg:{}", result, cell.substring(cell.length() - 5), content);

        } catch (Exception e) {
            logger.error("发送短信失败。。", e);

        }

        return retObj;*/
    }
}
