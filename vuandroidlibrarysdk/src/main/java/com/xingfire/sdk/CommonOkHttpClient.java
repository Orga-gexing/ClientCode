package com.xingfire.sdk;

import com.xingfire.sdk.https.HttpsUtils;
import com.xingfire.sdk.listener.DisposeDataHandle;
import com.xingfire.sdk.response.CommonJsonCallback;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by ge on 2018/3/4.
 * 请求的发送，参数的配置，https的支持
 */

public class CommonOkHttpClient {
    private static final int TIME_OUT = 30;//超时设置
    private static OkHttpClient mOkHttpClient;

    static {
        //创建构建者对象
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        //设置构建者超时时间
        okHttpBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
        //允许服务器端重定向
        okHttpBuilder.followRedirects(true);

        okHttpBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                //无论什么类型主机都通过
                return true;
            }
        });
        okHttpBuilder.sslSocketFactory(HttpsUtils.initSSLSocketFactory(),HttpsUtils.initTrustManager());
        mOkHttpClient = okHttpBuilder.build();
    }


    public static Call sendRequest(Request request,CommonJsonCallback callback){
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(callback);
        return call;
    }

    public static Call sendRequest(Request request, DisposeDataHandle handle){
       Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonJsonCallback(handle));
        return call;
    }
}
