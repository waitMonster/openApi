package com.ssk.api.http; /**
 * Created by sunsk on 2017/3/1.
 */
//实例1 httppost and httpGet

import com.ssk.api.vo.RequestVo;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import com.ssk.api.common.urlChange;
public class httpCline {
    String url="";
    urlChange uc=new urlChange();
    public void httpGet(RequestVo requestVo) {
        HttpClient client = new DefaultHttpClient();
        url = requestVo.getRequestUrl()+"?";
        url =uc.mapToStr(requestVo.getRequestParams(),url);
        System.out.println(url);
        HttpGet get=new HttpGet(url);
        //HttpResponse
        try {
            HttpResponse Response =client.execute(get);
            //打印返回值
            System.out.println(Response.getStatusLine().getStatusCode());
            //打印返回值
            //EntityUtils
            System.out.println(EntityUtils.toString(Response.getEntity()));
            //打印head
            System.out.println(Response.getFirstHeader("Content-Type"));
      //      ResponseVo responseVo =new ResponseVo();

        }catch (Exception E){

        }


    }
    public void httpPost() throws Exception {
        HttpClient client = new DefaultHttpClient();
        HttpPost post=new HttpPost("http://www.baidu.com");
        //HttpResponse
        HttpResponse Response =client.execute(post);
        //打印返回值
        System.out.println(Response.getStatusLine().getStatusCode());
        //打印返回值
        //EntityUtils

        System.out.println(EntityUtils.toString(Response.getEntity()));
        //打印head
        System.out.println(Response.getAllHeaders());
        System.out.println(Response.getFirstHeader("Content-Type"));
    }


}
