package com.qcblog;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class tesJson {
    @Test
    public void json() {
        // 一个未转化的字符串
        String str = "[{name:'a',value:'aa'},{name:'b',value:'bb'},{name:'c',value:'cc'},{name:'d',value:'dd'}]";
        // 首先把字符串转成 JSONArray  对象
        JSONArray jsonArray = JSONArray.parseArray(str);
        {
            for (int i = 0; i < jsonArray.size(); i++) {
// 遍历 jsonarray 数组，把每一个对象转成 json 对象
                JSONObject job = jsonArray.getJSONObject(i);
                // 得到 每个对象中的属性值
                System.out.println(job.get("name"));
            }
        }
    }
}
