/**
 * Created by sunsk on 2017/3/1.
 */
//实例1 httppost and httpGet
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import com.ssk.api.vo.RequestVo;
import org.testng.annotations.Test;
import java.util.HashMap;

public class test {
    public void httpGet(RequestVo requestVo) throws Exception {



        HttpClient client = new DefaultHttpClient();

        HttpGet get=new HttpGet(requestVo.getRequestUrl());

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
    @Test
    public void getTest() throws Exception{
        String requestUrl="http://www.baidu.com";
        HashMap<String ,Object> requestParams=new HashMap<>();
        requestParams.put("value","123");
        requestParams.put("ser","123");
        HashMap<String ,Object> requestHeads=new HashMap<>();
        RequestVo requestVo =new RequestVo(requestUrl,requestParams,requestHeads);
        System.err.println(requestParams.toString().split(","));
        httpGet(requestVo);
    }



}
