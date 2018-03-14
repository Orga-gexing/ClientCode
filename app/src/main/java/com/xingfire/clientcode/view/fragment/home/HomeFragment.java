package com.xingfire.clientcode.view.fragment.home;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xingfire.clientcode.R;
import com.xingfire.clientcode.adapter.CourseAdapter;
import com.xingfire.clientcode.module.recommand.BaseRecommandModel;
import com.xingfire.clientcode.module.recommand.RecommandModel;
import com.xingfire.clientcode.network.http.HttpConstants;
import com.xingfire.clientcode.network.http.RequestCenter;
import com.xingfire.clientcode.view.fragment.BaseFragment;
import com.xingfire.sdk.listener.DisposeDataListener;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ge on 2018/1/12.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener,AdapterView.OnItemClickListener {

    private View mContentView;
    private TextView mQRCodeView;
    private TextView mCategoryView;
    private TextView mSearchView;
    private ListView mListView;
    private ImageView mLoadingView;
    private BaseRecommandModel mBaseRecommandModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestRecommandData();
    }

    /**
     * 发送首页数据请求
     */
    public void requestRecommandData() {
        RequestCenter.requestRecommandData(new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                Log.i("MYTAG","----onSuccess" + ((BaseRecommandModel)responseObj).data.list.size());
                mBaseRecommandModel = (BaseRecommandModel)responseObj;
                showSuccessView();
            }

            @Override
            public void onFailure(Object reasonObj) {
                Log.i("MYTAG","----onFailure");
            }
        });
    }

    /**
     * 请求成功后调用方法
     */
    private void showSuccessView() {
        if(mBaseRecommandModel!=null){
            //判断数据非空
            if(mBaseRecommandModel.data.list !=null && mBaseRecommandModel.data.list.size()>0){
                Log.i("MYTAG","---data.list = "+mBaseRecommandModel.data.list);
                mLoadingView.setVisibility(View.GONE);
                mListView.setVisibility(View.VISIBLE);
                //创建Adapter
                CourseAdapter adapter = new CourseAdapter(getActivity(),mBaseRecommandModel.data.list);
                mListView.setAdapter(adapter);

            }else{
                showErrorView();
            }

        }else{

        }
    }

    /**
     * 请求失败方法
     */
    private void showErrorView() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext =  getActivity();
        mContentView =  inflater.inflate(R.layout.fragment_home_layout,container,false);
        initView();
        return mContentView;
    }

    private void initView() {
        mQRCodeView = (TextView) mContentView.findViewById(R.id.qrcode_view);
        mQRCodeView.setOnClickListener(this);
        mCategoryView = (TextView) mContentView.findViewById(R.id.category_view);
        mCategoryView.setOnClickListener(this);
        mSearchView = (TextView) mContentView.findViewById(R.id.search_view);
        mSearchView.setOnClickListener(this);
        mListView = (ListView) mContentView.findViewById(R.id.list_view);
        mListView.setOnItemClickListener(this);
        mLoadingView = (ImageView) mContentView.findViewById(R.id.loading_view);
        //启动loadingView动画
        AnimationDrawable anima = (AnimationDrawable) mLoadingView.getDrawable();
        anima.start();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
