package com.xingfire.sdk.okhttp;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * Created by ge on 2018/3/4.
 *
 * 封装okHttp请求类
 */

public class CommonRequest {

    /**
     *  post请求
     * @param url
     * @param params
     * @return 返回一个post类型的请求
     */
    public static Request createPostRequest(String url, RequestParams params){

        FormBody.Builder mFormBodyBuild =new FormBody.Builder();
        if(params!=null){
            for (Map.Entry<String,String> entry : params.urlParams.entrySet()){
                mFormBodyBuild.add(entry.getKey(), entry.getValue());
            }
        }
        FormBody mFormBody = mFormBodyBuild.build();
        Request request = new Request.Builder().url(url).post(mFormBody).build();
        return request;
    }

    /**
     * GET请求
     * @param url
     * @param params
     * @return 返回一个get类型的请求
     */
    public static Request createGetRequest(String url,RequestParams params){
        StringBuilder stringBuilder = new StringBuilder(url).append("?");
        if(params!=null){
            for (Map.Entry<String,String> entry : params.urlParams.entrySet()){
                stringBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        Request request = new Request.Builder().url(stringBuilder.substring(0,stringBuilder.length()-1)).build();
        return request;
    }

}
