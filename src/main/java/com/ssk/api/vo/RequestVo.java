package com.ssk.api.vo;

/**
 * Created by sunsk on 2017/3/5.
 */
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class RequestVo {
    private String requestUrl="";
    private HashMap<String ,Object> requestParams=new HashMap<>();
  // private JSON requestParams=new JSONObject();
    private HashMap<String ,Object> requestHeads=new HashMap<>();

}
