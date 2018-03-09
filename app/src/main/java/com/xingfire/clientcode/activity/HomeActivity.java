package com.xingfire.clientcode.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xingfire.clientcode.R;
import com.xingfire.clientcode.activity.base.BaseActivity;
import com.xingfire.clientcode.view.fragment.home.HomeFragment;
import com.xingfire.clientcode.view.fragment.home.MessageFragment;
import com.xingfire.clientcode.view.fragment.home.MineFragment;

/**
 * Created by ge on 2018/1/12.
 *
 * @function 创建所有的Fragment
 */

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private MessageFragment mMessageFragment;
    private MineFragment mMineFragment;
    private HomeFragment mHomeFragment;
    private Fragment[] mFragments;
    private int lastShowFragment; //记录最后显示的fragment状态
    private RelativeLayout mHomeLayout;
    private RelativeLayout mPondLayout;
    private RelativeLayout mMessageLayout;
    private RelativeLayout mMineLayout;
    private TextView mHomeView;
    private TextView mPondView;
    private TextView mMessageView;
    private TextView mMineView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);
        //初始化组件
        initView();
        //初始化fragment
        initFragment();
    }

    private void initView() {
        mHomeLayout = (RelativeLayout) findViewById(R.id.home_layout_view);
        mHomeLayout.setOnClickListener(this);
        mPondLayout = (RelativeLayout) findViewById(R.id.pond_layout_view);
        mPondLayout.setOnClickListener(this);
        mMessageLayout = (RelativeLayout) findViewById(R.id.message_layout_view);
        mMessageLayout.setOnClickListener(this);
        mMineLayout = (RelativeLayout) findViewById(R.id.mine_layout_view);
        mMineLayout.setOnClickListener(this);

        mHomeView = (TextView) findViewById(R.id.home_image_view);
        mPondView = (TextView) findViewById(R.id.fish_image_view);
        mMessageView = (TextView) findViewById(R.id.message_image_view);
        mMineView = (TextView) findViewById(R.id.mine_image_view);
        mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
    }

    private void initFragment() {
        mMessageFragment = new MessageFragment();
        mMineFragment = new MineFragment();
        mHomeFragment = new HomeFragment();
        lastShowFragment = 0;
        mFragments = new Fragment[]{mHomeFragment,mMessageFragment, mMineFragment};
        getSupportFragmentManager().beginTransaction().add(R.id.content_layout, mHomeFragment).show(mHomeFragment).commit();
    }

    private void swithchFragment(int lastIndex, int index) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(mFragments[lastIndex]);
        if (!mFragments[index].isAdded()) {
            fragmentTransaction.add(R.id.content_layout, mFragments[index]);
        }
        fragmentTransaction.show(mFragments[index]).commitAllowingStateLoss();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_layout_view:
                //切换状态栏颜色

                //改变图片背景 文字
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);
                if (lastShowFragment != 0) {
                    swithchFragment(lastShowFragment, 0);
                    lastShowFragment = 0;
                }
                break;
            case R.id.message_layout_view:
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message_selected);
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);
                if (lastShowFragment != 1) {
                    swithchFragment(lastShowFragment, 1);
                    lastShowFragment = 1;
                }
                break;
            case R.id.mine_layout_view:
                mMineView.setBackgroundResource(R.drawable.comui_tab_person_selected);
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                if (lastShowFragment != 2) {
                    swithchFragment(lastShowFragment, 2);
                    lastShowFragment = 2;
                }
                break;
        }
    }
}
