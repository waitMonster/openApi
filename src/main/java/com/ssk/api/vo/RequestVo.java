package com.ssk.api.vo;

/**
 * Created by sunsk on 2017/3/5.
 */
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class RequestVo {
    private String requestUrl="";
    private HashMap<String ,Object> requestParams=new HashMap<>();
    private HashMap<String ,Object> requestHeads=new HashMap<>();

}
