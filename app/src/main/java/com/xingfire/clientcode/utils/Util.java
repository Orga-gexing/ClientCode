package com.xingfire.clientcode.utils;

import com.xingfire.clientcode.module.recommand.RecommandBodyValue;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/13.
 */

public class Util {
    //为ViewPager结构化数据
    public static ArrayList<RecommandBodyValue> handleData(RecommandBodyValue value) {
        ArrayList<RecommandBodyValue> values = new ArrayList<>();
        String[] titles = value.title.split("@");
        String[] infos = value.info.split("@");
        String[] prices = value.price.split("@");
        String[] texts = value.text.split("@");
        ArrayList<String> urls = value.url;
        int start = 0;
        for (int i = 0; i < titles.length; i++) {
            RecommandBodyValue tempValue = new RecommandBodyValue();
            tempValue.title = titles[i];
            tempValue.info = infos[i];
            tempValue.price = prices[i];
            tempValue.text = texts[i];
            tempValue.url = extractData(urls, start, 3);//没三个做一个集合
            start += 3;

            values.add(tempValue);
        }
        return values;
    }

    private static ArrayList<String> extractData(ArrayList<String> source, int start, int interval) {
        ArrayList<String> urlList = new ArrayList<>();
     for(int i = start; i<start+interval;i++){
            urlList.add(source.get(i));
     }
     return urlList;
    }
}
