package com.xingfire.clientcode.module.recommand;


import com.xingfire.clientcode.module.recommand.user.BaseModel;

import java.util.ArrayList;

/**
 * @author: vision
 * @function:
 * @date: 16/9/2
 */
public class RecommandHeadValue extends BaseModel {

    public ArrayList<String> ads;
    public ArrayList<String> middle;
    public ArrayList<RecommandFooterValue> footer;

}
