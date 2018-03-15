package com.xingfire.clientcode.view.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xingfire.clientcode.R;
import com.xingfire.clientcode.module.recommand.RecommandFooterValue;
import com.xingfire.sdk.glide.GlideImgManager;

/**
 * 头部最底下布局
 * Created by Administrator on 2018/3/14.
 */

public class HomeBottomItem extends RelativeLayout {

    private Context mContext;

    /**
     * UI
     */
    private RelativeLayout mRootView;
    private TextView mTitleView;
    private TextView mInfoView;
    private TextView mInterestingView;
    private ImageView mImageOneView;
    private ImageView mImageTwoView;

    /**
     * Data
     */
    private RecommandFooterValue mFooterValue;

    public HomeBottomItem(Context context, RecommandFooterValue mFooterValue) {
        this(context,null,mFooterValue);
    }

    public HomeBottomItem(Context context, AttributeSet attrs, RecommandFooterValue mFooterValue) {
        super(context, attrs);
        this.mContext = context;
        this.mFooterValue = mFooterValue;
        initView();
    }

    private void initView() {
        mRootView = (RelativeLayout) LayoutInflater.from(mContext).inflate(R.layout.item_home_recommand_layout,this);
        mTitleView = (TextView) mRootView.findViewById(R.id.title_view);
        mInfoView = (TextView) mRootView.findViewById(R.id.info_view);
        mInterestingView = (TextView) mRootView.findViewById(R.id.interesting_view);
        mImageOneView = (ImageView) mRootView.findViewById(R.id.icon_1);
        mImageTwoView = (ImageView) mRootView.findViewById(R.id.icon_2);

        mTitleView.setText(mFooterValue.title);
        mInfoView.setText(mFooterValue.info);
        mInterestingView.setText(mFooterValue.from);

        GlideImgManager.glideLoader(mContext,mFooterValue.imageOne,R.mipmap.ic_launcher,R.mipmap.ic_launcher,mImageOneView);
        GlideImgManager.glideLoader(mContext,mFooterValue.imageTwo,R.mipmap.ic_launcher,R.mipmap.ic_launcher,mImageTwoView);
    }


}
