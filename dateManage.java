package com.fxiaoke.qa.appUpdate.updateMask.common;

import com.fxiaoke.qa.appUpdate.updateMask.common.dateMap;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sunsk on 2017/1/9.
 */

public class dateManage {
    static dateMap map =new dateMap();
    static Map<String,String> mapData =new LinkedHashMap<>();

    @DataProvider(name="testDate")
    public static Object[][] testDate(){
        return test();
    }
        public static Object[][] test(){

        //获取正交列表的测试数值
        mapData=map.datemap();


        int sum=1;
        int move=0;
        ArrayList moveList =new ArrayList();

        for(int i=0;i<mapData.values().toArray().length;i++){
            sum=sum+mapData.values().toArray()[i].toString().split(",").length-1;
            //生成偏移记录表
                moveList.add(0);

        }
        //根据测试用例建立二位数组
        Object[][] a =new  String[sum][mapData.values().toArray().length];
        Object[][] b =new  String[sum][1];
        for(int i=0;i<sum;i++){
           // ArrayList dataList =new ArrayList();
            String dataList="";
            for(int j=0;j<mapData.values().toArray().length;j++){
                //获取每一个因素的水平
                String factorStr =mapData.values().toArray()[j].toString();
                //获取每一个因素的水平数
                int factorInt =factorStr.split(",").length;
                //参数偏移
                if(i%factorInt==0&&factorInt!=1&&i!=0){
                    move++;
                    moveList.set(j,move);
                }
                int sunNum=(i+Integer.parseInt(moveList.get(j).toString()))%factorInt;
                a[i][j]=factorStr.split(",")[sunNum];


                if(j==mapData.values().toArray().length-1){
                    dataList=dataList+a[i][j].toString();
                }else{
                    dataList=dataList+a[i][j].toString()+",";
                }
            }
            b[i][0]=dataList.toString();
            System.err.print(dataList);
        }
        return b;
    }

}
