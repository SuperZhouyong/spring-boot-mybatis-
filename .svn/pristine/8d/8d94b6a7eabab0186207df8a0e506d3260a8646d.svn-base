package com.resumed.sqtwin.utils;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @auther Super
 * @data 2018/4/12 0012
 * @time 上午 11:15
 */
public class ApiUtil {
    private final Logger logger = LoggerFactory.getLogger(ApiUtil.class);
    //读超时长，单位：毫秒
    public static final int READ_TIME_OUT = 10000;//7676
    //连接时长，单位：毫秒
    public static HashMap<String, ApiUtil> sRetrofitManager = new HashMap();
    public static final int CONNECT_TIME_OUT = 10000;//7676
    public OkHttpClient okHttpClient;
//    public ApiUtil mApiUtil;

    private ApiUtil() {
        //增加头部信息  头部镶嵌 token 和 这缓存的一些数据(这里只是 存入的header的格式)
        Interceptor headerInterceptor = new Interceptor() {
            // 返回拦截   只让json 数据格式通过
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                // 每次进入的时候获取tooken 在这里增加进头部 没有的话 就不增加
                /*if (Your.sToken == null || alreadyHasAuthorizationHeader(originalRequest)) {
                    return chain.proceed(originalRequest);
                }*/
                // 登陆的话


                String timestamp = PublicKetUtils.getTimestamp();
                Request build = originalRequest.newBuilder()
//                        .addHeader("Content-Type", getContentType(hostType))
                        .addHeader("timestamp", timestamp)
                        .addHeader("publickey", PublicKetUtils.encryptMD5ToString(timestamp, AppConstant.KEY))

//                        .header("Cache-Control", getCacheControl())
                        .build();
                logger.info("   timestamp  ====" + timestamp + "\n" + "     publickey   ====" + PublicKetUtils.encryptMD5ToString(timestamp, AppConstant.KEY));
                return chain.proceed(build);
            }
        };
        okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .addInterceptor(headerInterceptor)
                // 加密
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                })
                .sslSocketFactory(HTTPSUtils.getInstance().getSslSocketFactory(), HTTPSUtils.getInstance().getTrustManager())
                .build();
    }

    public static OkHttpClient getApi() {
        ApiUtil api = sRetrofitManager.get("API");
        if (api == null) {
            api = new ApiUtil();
            sRetrofitManager.put("API", api);
        }
        return api.okHttpClient;

    }


}
