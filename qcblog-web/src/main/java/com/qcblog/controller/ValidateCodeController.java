package com.qcblog.controller;

import com.qcblog.common.ImgValidateCodeUtil;
import com.qcblog.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
public class ValidateCodeController {
    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 生成图片验证码
     * @return
     */
    @RequestMapping("/getImgCode")
    @ResponseBody
    public Map<String, String> getImgCode() {
        Map<String, String> result = new HashMap<>();
        try {
            // 获取 4位数验证码
            result= ImgValidateCodeUtil.getImgCodeBaseCode(4);
            // 将验证码存入redis 中（有效时长3分钟）
            cacheImgCode(result);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    /**
     * 将验证码存入redis 中
     * @param result
     */
    public void cacheImgCode(Map<String, String> result) {
        String imgCode = result.get("imgCode");
        UUID randomUUID = UUID.randomUUID();
        String imgCodeKey = randomUUID.toString();
        System.out.println("imgCodeKey:" + imgCodeKey);
        // 图片验证码有效时间 ：3 分钟
        redisTemplate.opsForValue().set("imgCodeKey", imgCode, 3, TimeUnit.MINUTES);
        result.put("imgCodeKey", imgCodeKey);
    }
    /**
     * 校验验证码
     * @param
     * @param imgCode
     * @return
     */
    @RequestMapping("/checkImgCode")
    @ResponseBody
    public Result checkImgCode(@RequestBody String imgCode) {
        String cacheCode = redisTemplate.opsForValue().get("imgCodeKey");
        if (null == cacheCode) {
            return new Result(false,"验证码已过期，请重新获取！");
        }
        if (cacheCode.equals(imgCode)) {
            return new Result(true,"验证码输入正确");
        }
        return new Result(false,"验证码输入错误");
    }

}
