package com.xingfire.clientcode.application;

import android.app.Application;

/**
 * Created by ge on 2018/1/12.
 * @function 1.他是程序的入口 2.初始化工作
 *             3.为整个应用的其他模块提供上下文
 */

public class ImoocApplication extends Application {

    public static ImoocApplication imoocApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        imoocApplication = this;
    }

    public static ImoocApplication getInstace(){
        return imoocApplication;
    }

}
