package workflow.testcase;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.JavaBeanInfo;
import org.testng.annotations.Test;
import com.ssk.api.json.Workflow;
import java.util.HashMap;
import com.ssk.api.common.fileUntil;

/**
 * Created by sunsk on 2017/8/3.
 */
public class webCreateDefinition {

    String Cookie="0G60s25KR040000PvMqUVZqNxVAkOAhBjd8MhUENoyfRR4ChCvnlW3FCqzK6j4NwmzIfW9MtaogJie0wuRQOGbNJoLBECayOPNSYsUFgjGqc5WI5mqzLaAzlMYPHbgizVqLZxZdy8ZIG62jB7NCEPjBtqyyg9FQia3T8bWESNEz69oPAqCHU07y7CrP0z9No4TBhQzFkJCF2g5ASLWQsLUZTJZJ5grUH7RyvffQqHv5bqI8BrbZNVlyc3qQW0G60s25KR040000PvMqUVZqNxVAkOAhBjd8MhUENoyfRR4ChCvnlW3FCqzK6j4NwmzIfW9MtaogJie0wuRQOGbNJoLBECayOPNSYsUFgjGqc5WI5mqzLaAzlMYPHbgizVqLZxZdy8ZIG62jB7NCEPjBtqyyg9FQia3T8bWESNEz69oPAqCHU07y7CrP0z9No4TBhQzFkJCF2g5ASLWQsLUZTJZJ5grUH7RyvffQqHv5bqI8BrbZNVlyc3qQW";
    @Test
    public void createWorkFlow() throws Exception{
        String requestUrl ="http://www.ceshi112.com/FHH/EM0HXUL/Authorize/Login";
        HashMap<String ,Object> requestHeads=new HashMap();
        requestHeads.put("Content-Type","application/json");
        requestHeads.put("Accept","application/json");
        System.err.println(fileUntil.getCurrentWorkDir());

        String fileUrl=fileUntil.getCurrentWorkDir()+"deploy2.json";
        System.err.println(fileUntil.read(fileUrl));
        JSONObject json =JSONObject.parseObject(fileUntil.read(fileUrl));
        //Workflow(json);
       // fileUntil.read(fileUrl);
       // JSONObject json=
    }
}

