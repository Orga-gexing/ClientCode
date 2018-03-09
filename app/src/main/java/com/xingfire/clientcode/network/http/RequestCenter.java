package com.xingfire.clientcode.network.http;

import com.xingfire.clientcode.module.recommand.BaseRecommandModel;
import com.xingfire.clientcode.module.recommand.user.BaseModel;
import com.xingfire.sdk.CommonOkHttpClient;
import com.xingfire.sdk.listener.DisposeDataHandle;
import com.xingfire.sdk.listener.DisposeDataListener;
import com.xingfire.sdk.okhttp.CommonRequest;
import com.xingfire.sdk.okhttp.RequestParams;

/**
 * 请求地址应用层封装
 *
 * Created by ge on 2018/3/7.
 */

public class RequestCenter {

    private static void postRequest(String url, RequestParams params,DisposeDataListener listener,Class<?> mClass){
        CommonOkHttpClient.sendRequest(CommonRequest.createGetRequest(url,params), new DisposeDataHandle(listener,mClass));
    }
    //首页数据请求
    public static void requestRecommandData(DisposeDataListener listener){
        RequestCenter.postRequest(HttpConstants.HOME_RECOMMAND,null,listener, BaseRecommandModel.class);
    }

}
