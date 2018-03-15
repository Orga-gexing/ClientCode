package com.xingfire.clientcode.constant;

import android.Manifest;

/**
 * Created by Administrator on 2018/3/14.
 */

public class Constant {
    /**
     * 权限常量相关
     */
    public static final int WRITE_READ_EXTERNAL_CODE = 0X11;
    public static final String[] WRITE_READ_EXTERNAL_PERMISSION = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
    public static final int HARDWEAR_CAMERA_CODE = 0X22;
    public static final String[] HARDWEAR_CAMERA_PERMISSION = new String[]{Manifest.permission.CAMERA};

}
