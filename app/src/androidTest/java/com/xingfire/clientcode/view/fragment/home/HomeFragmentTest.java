package com.xingfire.clientcode.view.fragment.home;

import android.util.Log;

import com.xingfire.clientcode.network.http.RequestCenter;
import com.xingfire.sdk.listener.DisposeDataListener;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ge on 2018/3/8.
 */
public class HomeFragmentTest {
    @Test
    public void requestRecommandData() throws Exception {
        RequestCenter.requestRecommandData(new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                Log.i("MYTAG","----onSuccess");
            }

            @Override
            public void onFailure(Object reasonObj) {
                Log.i("MYTAG","----onFailure");
            }
        });
    }

}