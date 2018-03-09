package com.xingfire.sdk.listener;

/**
 * 处理数据操作类
 * Created by ge on 2018/3/5.
 */

public class DisposeDataHandle {

    public DisposeDataListener mListener = null;//处理数据监听
    public Class<?> mClass = null; //数据类

    public DisposeDataHandle(DisposeDataListener mListener) {
        this.mListener = mListener;
    }

    public DisposeDataHandle(DisposeDataListener mListener, Class<?> mClass) {
        this.mListener = mListener;
        this.mClass = mClass;
    }
}
