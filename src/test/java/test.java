/**
 * Created by sunsk on 2017/3/1.
 */
//实例1 httppost and httpGet
import com.ssk.api.vo.RequestVo;
import org.testng.annotations.Test;
import java.util.HashMap;
import com.ssk.api.http.httpCline;
public class test {
    httpCline hc=new httpCline();
    @Test
    public void getTest() throws Exception{
        String requestUrl="http://www.kuaidi100.com/query";
        HashMap<String ,Object> requestParams=new HashMap<>();
        requestParams.put("type","ems");
        requestParams.put("postid","12122");
        HashMap<String ,Object> requestHeads=new HashMap<>();
        RequestVo requestVo =new RequestVo(requestUrl,requestParams,requestHeads);
        System.err.println(requestParams.toString().split(","));
        hc.httpGet(requestVo);
    }



}
