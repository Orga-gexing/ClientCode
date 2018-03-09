package com.xingfire.sdk;

import android.test.InstrumentationTestCase;
import android.util.Log;

import com.xingfire.sdk.listener.DisposeDataHandle;
import com.xingfire.sdk.listener.DisposeDataListener;
import com.xingfire.sdk.okhttp.CommonRequest;
import com.xingfire.sdk.response.CommonJsonCallback;

/**
 * Created by ge on 2018/3/8.
 */

public class TestSubject extends InstrumentationTestCase {

    private static final String TAG = "TestAndroidClass";

    public void test() throws Exception{
        assertEquals(2, 2);
    }

    public void testApi02(){
        int a =1;
        int b =2;
        int c = a+b;
        System.out.print("----打印 = "+c);

    }

    public void testApi(){
        CommonOkHttpClient.sendRequest(CommonRequest.createGetRequest("https://ba9e8ee7-bbe2-4c00-84f8-f1cf66ac66ed.mock.pstmn.io/product/home_recommand.php", null),
            new CommonJsonCallback(new DisposeDataHandle(new DisposeDataListener() {
        @Override
        public void onSuccess(Object responseObj) {
            Log.i("mytag","--onSuccess responseObj");
        }

        @Override
        public void onFailure(Object reasonObj) {
            Log.i("mytag","--onFailure responseObj");
        }
    })));
}
}
