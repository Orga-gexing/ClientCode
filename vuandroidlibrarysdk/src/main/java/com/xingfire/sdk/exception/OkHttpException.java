package com.xingfire.sdk.exception;

/**
 * Created by ge on 2018/3/5.
 */

public class OkHttpException extends Exception {

    private int ecode;

    private Object emsg;

    public OkHttpException(int ecode, Object emsg) {
        this.ecode = ecode;
        this.emsg = emsg;
    }

    public int getEcode() {
        return ecode;
    }

    public Object getEmsg() {
        return emsg;
    }

}
