package com.xingfire.sdk.okhttp;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ge on 2018/3/4.
 */

public class RequestParams {
    public ConcurrentHashMap<String, String> urlParams = new ConcurrentHashMap<String, String>();
    public ConcurrentHashMap<String, Object> fileParams = new ConcurrentHashMap<String, Object>();

    public RequestParams() {
        this((Map<String, String>) null);
    }

    public RequestParams(Map<String, String> resource) {
        if (resource != null) {
            for (Map.Entry<String, String> entry : resource.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    private void put(String key, String value) {
        if (key != null && value != null) {
            urlParams.put(key, value);
        }
    }

    public RequestParams(final String key, final String value) {
        this(new HashMap<String, String>() {
            {
                put(key, value);
            }
        });
    }

    public void put(String key, Object object) throws FileNotFoundException {

        if (key != null) {
            fileParams.put(key, object);
        }
    }

    public boolean hasParams() {
        if(urlParams.size() > 0 || fileParams.size() > 0){

            return true;
        }
        return false;
    }

}
