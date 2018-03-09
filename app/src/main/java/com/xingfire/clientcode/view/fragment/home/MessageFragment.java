package com.xingfire.clientcode.view.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xingfire.clientcode.R;
import com.xingfire.clientcode.view.fragment.BaseFragment;

/**
 * Created by ge on 2018/1/12.
 */

public class MessageFragment extends BaseFragment {

    private View contentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext =  getActivity();
        contentView = inflater.inflate(R.layout.fragment_message_layout,container,false);
        return contentView;
    }
}
