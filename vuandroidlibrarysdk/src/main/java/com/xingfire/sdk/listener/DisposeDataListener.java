package com.xingfire.sdk.listener;

/**
 * 自定义事件监听
 * Created by ge on 2018/3/5.
 */

public interface DisposeDataListener {

    /**
     * 请求成功的回调
     * @param responseObj
     */
    public void onSuccess(Object responseObj);

    /**
     * 请求失败的回调
     * @param reasonObj
     */
    public void onFailure(Object reasonObj);

}
