/**
 * Created by sunsk on 2017/3/1.
 */
//实例1 httppost and httpGet
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssk.api.vo.RequestVo;
import com.ssk.api.vo.ResponseVo;
import org.testng.annotations.Test;
import java.util.HashMap;
import com.ssk.api.http.httpCline;
public class test {
    httpCline hc=new httpCline();
  //  @Test
//    public void getTest() {
//        String requestUrl="http://www.kuaidi100.com/query";
//        HashMap<String ,Object> requestParams=new HashMap<>();
//        requestParams.put("type","ems");
//        requestParams.put("postid","12122");
//        HashMap<String ,Object> requestHeads=new HashMap<>();
//        RequestVo requestVo =new RequestVo(requestUrl,requestParams,requestHeads);
//        System.err.println(requestParams.toString().split(","));
//        hc.httpPost(requestVo);
//    }

    @Test
    public void login(){
        String requestUrl ="http://www.ceshi112.com/FHH/EM0HXUL/Authorize/Login";
        HashMap<String ,Object> requestHeads=new HashMap();
        requestHeads.put("Content-Type","application/json");
        requestHeads.put("Accept","application/json");

        loginBean loginB =new loginBean();
        loginB.setEnterpriseAccount("57612");
        loginB.setUserAccount("18210911798");
        loginB.setPassword("a123456");
        loginB.setImgCode("");
        loginB.setPersistenceHint("true");
        loginB.setClientId("undefined");

        JSONObject json= JSON.parseObject(JSONObject.toJSONString(loginB));
        System.out.println(json);
        //JSONObject json =new JSONObject();

//        HashMap<String ,Object> requestParams=new HashMap<>();
//        requestParams.put("EnterpriseAccount","57612");
//        requestParams.put("UserAccount","18210911798");
//        requestParams.put("Password","a123456");
//        requestParams.put("ImgCode","");
//        requestParams.put("ClientId","undefined");
//        requestParams.put("PersistenceHint",true);

        RequestVo requestVo =new RequestVo(requestUrl,json,requestHeads);
        ResponseVo responseVo=hc.httpPost(requestVo);
        System.err.println(responseVo.getCookies().get(1).getValue());
    }

}
