package com.xingfire.clientcode.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/3/13.
 */
public class UtilTest {
    private int start=0;
    @Test
    public void test01(){
        for(int i =0;i<3;i++){

            for (int y = start; y < start +3; y++) {
                System.out.println("myTag="+y);
            }

            start+=3;
        }
    }
}