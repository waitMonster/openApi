package com.fxiaoke.qa.appUpdate.updateMask.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fxiaoke.api.model.AddOrEditAntaeusConfigDTO;
import com.fxiaoke.api.model.AntaeusButtonType;
import com.fxiaoke.api.model.AntaeusType;
import com.fxiaoke.qa.keydriver.bl.FileUtils;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by sunsk on 2017/1/30.
 */
public class javaBeanMassageOld {
    static AddOrEditAntaeusConfigDTO.Arg cm =new AddOrEditAntaeusConfigDTO.Arg();
    //static AddOrEditAntaeusConfigDTO.Arg javaBean =new AddOrEditAntaeusConfigDTO.Arg();

    //static String filePath=FileUtils.read(ConnetServer.getDateUrl());
    @DataProvider(name="testDateOld")
    //public static  Object[][] testData(Object javaBean,String filePath) throws Exception {
    public static  Object[][] testData(Method m) throws Exception {
        System.err.println(m.getName());
        System.err.println();
        Class a[]=m.getParameterTypes();//获得所有的参数并且存放到数组B中
        for(int j=0;j<a.length;j++)
        {
            System.out.println("参数的类型是"+a[j]);
        }
        int sum = 1;
        int move = 0;
        Object value;
        AddOrEditAntaeusConfigDTO.Arg javaBean =new AddOrEditAntaeusConfigDTO.Arg();
        //javaBeanMassage jm=new javaBeanMassage();
        //Object javaBean=cm;
        Class<?> classType = javaBean.getClass();
        //  Field[] fields = classType.getDeclaredFields();
        HashMap<String, Integer> moveMap = new HashMap();
        //读取json文件
        String jsonStr = null;
        //String jsonStr = FileUtils.read(ConnetServer.getDataUrl());
        //将json文件转换为json对象
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        //循环key转获取正交的值
        for (String key : jsonObject.keySet()) {
            int valueSize = jsonObject.get(key).toString().split(",").length;
            sum = sum + valueSize - 1;
            moveMap.put(key, 0);
        }
        Object[][] b =new  String[sum][1];
        //根据测试用例建立二位数组
        for (int i = 0; i < sum; i++) {
            int inputI=0;
            for (String key : jsonObject.keySet()) {
                inputI++;
                //获取每一个因素的水平
                String factorStr = jsonObject.get(key).toString();
                //获取每一个因素的水平数
                int factorInt = factorStr.split(",").length;
                if (i % factorInt == 0 && factorInt != 1 && i != 0) {
                    move++;
                    moveMap.put(key, move);
                }
                int sunNum = (i + moveMap.get(key)) % factorInt;
                String setMethodName = "set" + key.substring(0, 1).toUpperCase()+key.substring(1);
                //获取字段类型
                Class[] getType=getType(javaBean,key);
                value=factorStr.split(",")[sunNum];
                Object inputValue=valueChange(getType[0].toString(),value);
                // TODO: 2017/1/30  针对枚举值进行转化--需要特殊处理
                if(getType[0].toString().contains(inputValue.toString())){
                    enumInput(key,value);
                }else {
                    if(inputValue.toString().contains("enum.")){
                        inputValue=defindEnum(key,inputValue.toString());
                        Method setMethod = classType.getMethod(setMethodName,getType);
                        setMethod.invoke(javaBean, inputValue);
                    }else{
                        Method setMethod = classType.getMethod(setMethodName,getType);
                        setMethod.invoke(javaBean, inputValue);
                    }
                }

            }
           // System.err.println(javaBean);
           // b[i][0]=String.valueOf(i);
            b[i][0]=javaBean.toString();
        }
        return b;
    }
    /*获取javabean的字段类型
   * @javaBean
   *   javeBean 类
   *@key
   *  javeBean key值
   * */
    public static Class[] getType(Object javaBean,String key) throws Exception{
        Class<?> classType = javaBean.getClass();
        Class[] getType=null;
        Field[] fields = classType.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Object value = null;
            if (fields[i].getName().contains(key) && key.contains(fields[i].getName())) {
                Field field = fields[i];
                getType=new Class[]{field.getType()};
                break;
            }
        }
        return getType;
    }
    /*
* 根据参数类型转换参数的值
* @javaBean
*   javeBean 类
*@key
*  javeBean key值
* */
    public static Object valueChange(String paraType,Object value) {
        Object valueCh=null;
        if(paraType.equals("class java.lang.String")){
            valueCh=String.valueOf(value);
        }else if(paraType.equals("class java.lang.Integer")||paraType.equals("int")){
            valueCh=Integer.parseInt(value.toString());
        }else if(paraType.equals("long")){
            valueCh=Long.parseLong(value.toString());
        }else if (paraType.equals("class java.lang.Boolean")) {
            valueCh=Boolean.valueOf(value.toString());
        }else{
            valueCh="com.fxiaoke";
        }
        return valueCh;
    }
    /*
      * 根据参数类型转换参数的值
     * @javaBean
     *   javeBean 类
     *@key
     *  javeBean key值
     * */
    public  static void enumInput(String key,Object value) {
        if(key=="antaeusType"){
            cm.setAntaeusType(AntaeusType.values()[Integer.parseInt(value.toString())]);
        }
        if(key=="button1"){
            cm.setButton1(AntaeusButtonType.values()[Integer.parseInt(value.toString())]);
        }
        if(key=="button2"){
            cm.setButton2(AntaeusButtonType.values()[Integer.parseInt(value.toString())]);
        }

    }
    public  static Object defindEnum(String key,String value) {
        //获取自定义的描述信息
        if(key=="description") {
            value= UpdateMaskEnum.UpateMessage.values()[Integer.parseInt(value.toString().split("enum.")[1])].toString();
        }
        return  value;
    }
}
