package com.fxiaoke.qa.appUpdate.updateMask.common;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sunsk on 2017/1/6.
 */
public class dateMap {
    public Map<String,String> datemap(){

            LinkedHashMap<String,String> testData =new LinkedHashMap<>();
            testData.put("version","100543008,100543009");
            testData.put("subClientType","2,3");
            testData.put("downloadUrl","http://www.fxiaoke.com,");
            //枚举值
            testData.put("antaeusType","0,1");
            testData.put("title","下载");
            testData.put("description","0,1");
            testData.put("h5URL","http://www.fxiaoke.com");
            testData.put("button1","0,1,2");
            testData.put("button1Text","下载");
            testData.put("button2","1,2,0");
            testData.put("button2Text","稍后下载");
            testData.put("ignoreTimes","5");
        return testData;

    }

}
