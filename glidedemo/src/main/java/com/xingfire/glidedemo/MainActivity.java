package com.xingfire.glidedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIv = (ImageView)findViewById(R.id.iv);
        Glide.with(this).load("http://img.taopic.com/uploads/allimg/120727/201995-120HG1030762.jpg").into(mIv);
    }
}
