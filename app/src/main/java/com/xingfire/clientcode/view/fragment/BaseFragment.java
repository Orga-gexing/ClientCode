package com.xingfire.clientcode.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.xingfire.clientcode.constant.Constant;

/**
 * Created by ge on 2018/1/12.
 * @function 主要为我们所有的fragment提供公共的行为或事件
 */

public class BaseFragment extends Fragment {

    protected Activity mContext;

    /**
     * 申请指定的权限
     * @param
     */
    public void requestPermission(int code ,String... params){
        if(Build.VERSION.SDK_INT >= 23){
            requestPermissions(params,code);
        }
    }

    /**
     * 判断是否又指定权限
     */
    public boolean hasPermission(String... params){

        for (String permission : params){
            if(ContextCompat.checkSelfPermission(getActivity(),permission)!= PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case Constant.WRITE_READ_EXTERNAL_CODE:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    doWriteSDCard();
                }
                break;
            case Constant.HARDWEAR_CAMERA_CODE:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    doOpenCamra();
                }
                break;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public void doWriteSDCard() {

    }

    public void doOpenCamra() {

    }

}
