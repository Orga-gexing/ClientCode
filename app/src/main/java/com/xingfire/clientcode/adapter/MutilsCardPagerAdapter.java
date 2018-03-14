package com.xingfire.clientcode.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xingfire.clientcode.R;
import com.xingfire.clientcode.module.recommand.RecommandBodyValue;
import com.xingfire.sdk.glide.GlideImgManager;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2018/3/13.
 */

public class MutilsCardPagerAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<RecommandBodyValue> recommandList;
    private LayoutInflater mInflater;

    public MutilsCardPagerAdapter(Context mContext, ArrayList<RecommandBodyValue> recommandList) {
        this.mContext = mContext;
        this.recommandList = recommandList;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        RecommandBodyValue value = recommandList.get(position % recommandList.size());
        View rootView = mInflater.inflate(R.layout.item_hot_product_pager_layout,null);
        TextView titleView = (TextView) rootView.findViewById(R.id.title_view);
        TextView infoView = (TextView) rootView.findViewById(R.id.info_view);
        TextView gonggaoView = (TextView) rootView.findViewById(R.id.gonggao_view);
        TextView saleView = (TextView) rootView.findViewById(R.id.sale_num_view);
        ImageView[] imageViews = new ImageView[3];
        imageViews[0] = (ImageView) rootView.findViewById(R.id.image_one);
        imageViews[1] = (ImageView) rootView.findViewById(R.id.image_two);
        imageViews[2] = (ImageView) rootView.findViewById(R.id.image_three);

        titleView.setText(value.title);
        infoView.setText(value.price);
        gonggaoView.setText(value.info);
        saleView.setText(value.text);

        for (int i=0;i<imageViews.length;i++){
            GlideImgManager.glideLoader(mContext,value.url.get(i),R.mipmap.ic_launcher,R.mipmap.ic_launcher,imageViews[i]);
        }
        container.addView(rootView,0);
        return rootView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
