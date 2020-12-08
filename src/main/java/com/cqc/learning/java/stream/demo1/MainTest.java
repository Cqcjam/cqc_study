package com.cqc.learning.java.stream.demo1;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainTest {

    public static void main(String[] args) {

        JSONArray array = new JSONArray(2);
        JSONObject json = new JSONObject(4);
        json.put("approveTime", "2020-08-06 18:00:01");
        json.put("operateRemark", "");
        json.put("operateStatus", 0);
        json.put("operateUser", "丁磊->关利利");
        JSONObject json2 = new JSONObject(4);
        json2.put("approveTime", "2020-08-06 18:00:02");
        json2.put("operateRemark", "");
        json2.put("operateStatus", 1);
        json2.put("operateUser", "王源");
        array.add(json);
        array.add(json2);

        List<OaApproveDto> oaList =  JSONObject.parseArray(array.toJSONString(), OaApproveDto.class);
        oaList = oaList.stream().sorted(Comparator.comparing(OaApproveDto::getApproveTime).reversed())
                .collect(Collectors.toList());
        oaList.forEach(item->{
            System.out.println(item);
        });
    }
}
