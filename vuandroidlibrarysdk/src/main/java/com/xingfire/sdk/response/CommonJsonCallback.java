package com.xingfire.sdk.response;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xingfire.sdk.exception.OkHttpException;
import com.xingfire.sdk.listener.DisposeDataHandle;
import com.xingfire.sdk.listener.DisposeDataListener;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by ge on 2018/3/5.
 *
 * @function 处理json回调响应
 */

public class CommonJsonCallback implements Callback {

    //与服务器返回的字段的一个对应关系
    protected final String RESULT_CODE = "ecode";
    protected final int RESULT_CODE_VALUE = 0;
    protected final String ERROR_MSG = "emsg";
    protected final String EMPTY_MSG = "";

    /**
     * 自定义异常类型
     */
    protected final int NETWORK_ERROR = -1;
    protected final int JSON_ERROR = -2;
    protected final int OTHER_ERROR = -3;

    private Handler mDeliveryHandler;//进行消息转发
    private DisposeDataListener mListener;
    private Class<?> mClass;

    public CommonJsonCallback(DisposeDataHandle handle) {
        this.mListener = handle.mListener;
        this.mClass = handle.mClass;
        this.mDeliveryHandler = new Handler(Looper.getMainLooper());
    }



    @Override
    public void onFailure(Call call, final IOException ioException) {
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.onFailure(new OkHttpException(NETWORK_ERROR, ioException));
            }
        });
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        final String result = response.body().string();
        Log.i("Mytag","---result= "+result.toString());
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(result);
            }
        });
    }

    private void handleResponse(Object result) {


        //如果返回是空，调用onFailure
        if (result == null || result.toString().trim().equals("")) {
            mListener.onFailure(new OkHttpException(NETWORK_ERROR, EMPTY_MSG));
            return;
        }
        //如果不是空，则解析数据
        try {
            if (mClass == null) {
                mListener.onSuccess(result);
            } else {
                JSONObject jObject = new JSONObject(result.toString());
                if(jObject.has(RESULT_CODE)){
                    if(jObject.getInt(RESULT_CODE)==RESULT_CODE_VALUE){
                        //此处使用的是jackson解析数据
                        ObjectMapper mapper = new ObjectMapper();
                        Object object = mapper.readValue(result.toString(), mClass);
                        if (object != null) {
                            mListener.onSuccess(object);
                        } else {
                            mListener.onFailure(new OkHttpException(JSON_ERROR, EMPTY_MSG));
                        }
                    }
                }
            }
        } catch (Exception e) {
            mListener.onFailure(new OkHttpException(OTHER_ERROR, e.getMessage()));
            e.printStackTrace();
        }

    }
}
