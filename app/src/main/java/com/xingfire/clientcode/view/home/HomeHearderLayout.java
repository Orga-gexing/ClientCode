package com.xingfire.clientcode.view.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.xingfire.clientcode.R;
import com.xingfire.clientcode.module.recommand.RecommandFooterValue;
import com.xingfire.clientcode.module.recommand.RecommandHeadValue;
import com.xingfire.sdk.glide.GlideImgManager;

/**
 * 自定义头部布局
 * Created by Administrator on 2018/3/14.
 */

public class HomeHearderLayout extends RelativeLayout {

    private Context mContext;
    /**
     * UI
     */
    private RelativeLayout mRootView;
    private LinearLayout mFootLayout;
    private ConvenientBanner mBanner;
    private ImageView[] mImageViews = new ImageView[4];
    private TextView mHotView;
    /**
     * Data
     */
    private RecommandHeadValue mHeadValue;


    public HomeHearderLayout(Context context, RecommandHeadValue mHeadValue) {
        this(context, null, mHeadValue);
    }

    public HomeHearderLayout(Context context, AttributeSet attrs, RecommandHeadValue mHeadValue) {
        super(context, attrs);
        this.mContext = context;
        this.mHeadValue = mHeadValue;
        initView();
    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        mRootView = (RelativeLayout) inflater.inflate(R.layout.listview_home_head_layout, this);
        mBanner = (ConvenientBanner) mRootView.findViewById(R.id.banner_view);
        mFootLayout = (LinearLayout) mRootView.findViewById(R.id.content_layout);


        mBanner.setPages(new CBViewHolderCreator<NetWorkImageHolderView>() {
            @Override
            public NetWorkImageHolderView createHolder() {
                return new NetWorkImageHolderView();
            }
        }, mHeadValue.ads)
                .setPointViewVisible(true)
                .startTurning(2000)
                .setPageIndicator(new int[]{R.drawable.point_01, R.drawable.point_02})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);

        mHotView = (TextView) mRootView.findViewById(R.id.zuixing_view);
        mImageViews[0] = (ImageView) mRootView.findViewById(R.id.head_image_one);
        mImageViews[1] = (ImageView) mRootView.findViewById(R.id.head_image_two);
        mImageViews[2] = (ImageView) mRootView.findViewById(R.id.head_image_three);
        mImageViews[3] = (ImageView) mRootView.findViewById(R.id.head_image_four);
        mFootLayout = (LinearLayout) mRootView.findViewById(R.id.content_layout);

        mHotView.setText(mContext.getString(R.string.today_zuixing));

        for (int i=0;i<mImageViews.length;i++){
            GlideImgManager.glideLoader(mContext,mHeadValue.middle.get(i),R.mipmap.ic_launcher,R.mipmap.ic_launcher,mImageViews[i]);
        }

        for(RecommandFooterValue value : mHeadValue.footer){
          createFooterView(value);
        }
    }

    private void createFooterView(RecommandFooterValue value) {
        mFootLayout.addView(new HomeBottomItem(mContext,value));
    }

    private static class NetWorkImageHolderView implements Holder<String> {

        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int i, String url) {
            GlideImgManager.glideLoader(context, url, R.mipmap.ic_launcher, R.mipmap.ic_launcher, imageView);
        }
    }

}
