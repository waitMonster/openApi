package com.ssk.api.vo; /**
 * Created by sunsk on 2017/3/1.
 */
//实例1 httppost and httpGet

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class httpClinetest {
    public void httpGet() throws Exception {
        HttpClient client = new DefaultHttpClient();
        HttpGet get=new HttpGet("http://www.baidu.com");
        //HttpResponse
        HttpResponse Response =client.execute(get);
        //打印返回值
        System.out.println(Response.getStatusLine().getStatusCode());
        //打印返回值
        //EntityUtils

        System.out.println(EntityUtils.toString(Response.getEntity()));
        //打印head
        System.out.println(Response.getAllHeaders());
        System.out.println(Response.getFirstHeader("Content-Type"));
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
    public static void main(String[] args) throws Exception {
//        test test =new test();
//        test.httpGet();
//        test.httpPost();

    }

}
