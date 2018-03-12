package com.xingfire.clientcode.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xingfire.clientcode.module.recommand.RecommandBodyValue;

import java.util.ArrayList;

/**
 * 首页列表适配器
 * Created by Administrator on 2018/3/9.
 */

public class CourseAdapter extends BaseAdapter{

    private static final int CARD_COUNT = 4; //item 总共4中类型
    private static final int VIDOE_TYPE = 0x00; // 视频
    private static final int CARD_TYPE_ONE = 0x01; //
    private static final int CARD_TYPE_TWO = 0x02;
    private static final int CARD_TYPE_THREE = 0x03;

    private Context context;
    private ArrayList<RecommandBodyValue> mRecommandBodyValues;
    private int type;


    public CourseAdapter(Context context, ArrayList<RecommandBodyValue> mRecommandBodyValues) {
        this.context = context;
        this.mRecommandBodyValues = mRecommandBodyValues;
    }

    @Override
    public int getCount() {
        return mRecommandBodyValues.size();
    }

    @Override
    public Object getItem(int i) {
        return mRecommandBodyValues.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return CARD_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        RecommandBodyValue value = (RecommandBodyValue) getItem(position);
        return value.type;
    }

    @Override
    public View getView(int position, View convert, ViewGroup viewGroup) {

        int type = getItemViewType(position);
        RecommandBodyValue value = (RecommandBodyValue) getItem(position);

        if(convert == null){
            switch (type){
                case VIDOE_TYPE:

                    break;
                case CARD_TYPE_ONE:

                    break;
                case CARD_TYPE_TWO:

                    break;
                case CARD_TYPE_THREE:

                    break;
            }
        }

        return null;
    }

    /**
     * 缓存创建好的Item
     */
    private static class ViewHolder {
        //所有Card共有属性
       // private CircleImageView mLogoView;
        private TextView mTitleView;
        private TextView mInfoView;
        private TextView mFooterView;
        //Video Card特有属性
        private RelativeLayout mVieoContentLayout;
        private ImageView mShareView;

        //Video Card外所有Card具有属性
        private TextView mPriceView;
        private TextView mFromView;
        private TextView mZanView;
        //Card One特有属性
        private LinearLayout mProductLayout;
        //Card Two特有属性
        private ImageView mProductView;
        //Card Three特有属性
        private ViewPager mViewPager;
    }

}
