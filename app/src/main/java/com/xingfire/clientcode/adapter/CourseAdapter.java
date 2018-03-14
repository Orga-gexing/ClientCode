package com.xingfire.clientcode.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xingfire.clientcode.R;
import com.xingfire.clientcode.module.recommand.RecommandBodyValue;
import com.xingfire.clientcode.utils.Util;
import com.xingfire.sdk.glide.GlideImgManager;
import com.xingfire.sdk.utils.DppxUtil;

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

    private Context mContext;
    private ArrayList<RecommandBodyValue> mRecommandBodyValues;
    private ViewHolder mViewHolder;
    private LayoutInflater mInflater;

    public CourseAdapter(Context mContext, ArrayList<RecommandBodyValue> mRecommandBodyValues) {
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
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
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        int type = getItemViewType(position);
        RecommandBodyValue value = (RecommandBodyValue) getItem(position);

        if(convertView == null){
            switch (type){
                case VIDOE_TYPE:
                    mViewHolder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.item_video_layout,viewGroup,false);
                    break;
                case CARD_TYPE_ONE:
                    mViewHolder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.item_product_card_one_layout,viewGroup,false);
                    mViewHolder.mLogoView = (ImageView) convertView.findViewById(R.id.item_logo_view);
                    mViewHolder.mTitleView = (TextView) convertView.findViewById(R.id.item_title_view);
                    mViewHolder.mInfoView = (TextView) convertView.findViewById(R.id.item_info_view);
                    mViewHolder.mFooterView = (TextView) convertView.findViewById(R.id.item_footer_view);
                    mViewHolder.mPriceView = (TextView) convertView.findViewById(R.id.item_price_view);
                    mViewHolder.mFromView = (TextView) convertView.findViewById(R.id.item_from_view);
                    mViewHolder.mZanView = (TextView) convertView.findViewById(R.id.item_zan_view);
//                    mViewHolder.mProductView01 = (ImageView) convertView.findViewById(R.id.mProductView01);
                    mViewHolder.mProductLayout = (LinearLayout) convertView.findViewById(R.id.product_photo_layout);
                    break;
                case CARD_TYPE_TWO:
                    mViewHolder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.item_product_card_two_layout,viewGroup,false);
                    mViewHolder.mLogoView = (ImageView) convertView.findViewById(R.id.item_logo_view);
                    mViewHolder.mTitleView = (TextView) convertView.findViewById(R.id.item_title_view);
                    mViewHolder.mInfoView = (TextView) convertView.findViewById(R.id.item_info_view);
                    mViewHolder.mFooterView = (TextView) convertView.findViewById(R.id.item_footer_view);
                    mViewHolder.mProductView = (ImageView) convertView.findViewById(R.id.product_photo_view);
                    mViewHolder.mPriceView = (TextView) convertView.findViewById(R.id.item_price_view);
                    mViewHolder.mFromView = (TextView) convertView.findViewById(R.id.item_from_view);
                    mViewHolder.mZanView = (TextView) convertView.findViewById(R.id.item_zan_view);
                    //为单个ImageView加载远程图片
                    break;
                case CARD_TYPE_THREE:
                    mViewHolder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.item_product_card_three_layout,viewGroup,false);
                    mViewHolder.mViewPager = (ViewPager) convertView.findViewById(R.id.pager);
                    mViewHolder.mViewPager.setPageMargin(DppxUtil.dip2px(mContext,12));
                    ArrayList<RecommandBodyValue> recommandList = Util.handleData(value);
                    mViewHolder.mViewPager.setAdapter(new MutilsCardPagerAdapter(mContext,recommandList));
                    mViewHolder.mViewPager.setCurrentItem(recommandList.size()*100);
                    //初始化
                    break;
            }
            convertView.setTag(mViewHolder);
        }else{
             mViewHolder = (ViewHolder) convertView.getTag();
        }

        //填充item的数据
        switch (type) {
            case VIDOE_TYPE:
                break;
            case CARD_TYPE_ONE:
//                mImagerLoader.displayImage(mViewHolder.mLogoView, value.logo);
                GlideImgManager.glideLoader(mContext,value.logo,R.mipmap.ic_launcher,R.mipmap.ic_launcher,mViewHolder.mLogoView,0);
//                GlideImgManager.glideLoader(mContext,value.logo,R.mipmap.ic_launcher,R.mipmap.ic_launcher,mViewHolder.mProductView01);
                mViewHolder.mTitleView.setText(value.title);
                mViewHolder.mInfoView.setText(value.info.concat(mContext.getString(R.string.tian_qian)));
                mViewHolder.mFooterView.setText(value.text);
                mViewHolder.mPriceView.setText(value.price);
                mViewHolder.mFromView.setText(value.from);
                mViewHolder.mZanView.setText(mContext.getString(R.string.dian_zan).concat(value.zan));
                //动态添加imageview
                mViewHolder.mProductLayout.removeAllViews();
                for(String url:value.url){
                    mViewHolder.mProductLayout.addView(createImageView(url));
                }
                break;
            case CARD_TYPE_TWO:
                GlideImgManager.glideLoader(mContext,value.logo,R.mipmap.ic_launcher,R.mipmap.ic_launcher,mViewHolder.mLogoView,0);
                GlideImgManager.glideLoader(mContext,value.logo,R.mipmap.ic_launcher,R.mipmap.ic_launcher,mViewHolder.mProductView);
                mViewHolder.mTitleView.setText(value.title);
                mViewHolder.mInfoView.setText(value.info.concat(mContext.getString(R.string.tian_qian)));
                mViewHolder.mFooterView.setText(value.text);
                mViewHolder.mPriceView.setText(value.price);
                mViewHolder.mFromView.setText(value.from);
                mViewHolder.mZanView.setText(mContext.getString(R.string.dian_zan).concat(value.zan));
                break;
            case CARD_TYPE_THREE:

              //
                break;
        }

        return convertView;
    }

    private View createImageView(String url) {
        ImageView pic = new ImageView(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(DppxUtil.dip2px(mContext,100),LinearLayout.LayoutParams.MATCH_PARENT);
        params.leftMargin = DppxUtil.dip2px(mContext,5);
        pic.setLayoutParams(params);
        GlideImgManager.glideLoader(mContext,url,R.mipmap.ic_launcher,R.mipmap.ic_launcher,pic);
        return pic;
    }

    /**
     * 缓存创建好的Item
     */
    private static class ViewHolder {
        //所有Card共有属性
        private ImageView mLogoView;
//        private ImageView mProductView01;
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
