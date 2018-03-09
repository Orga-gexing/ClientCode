package com.xingfire.vuandroidlibrarysdk;

import android.util.Log;

import com.xingfire.sdk.CommonOkHttpClient;
import com.xingfire.sdk.listener.DisposeDataHandle;
import com.xingfire.sdk.listener.DisposeDataListener;
import com.xingfire.sdk.okhttp.CommonRequest;
import com.xingfire.sdk.response.CommonJsonCallback;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void test() {
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