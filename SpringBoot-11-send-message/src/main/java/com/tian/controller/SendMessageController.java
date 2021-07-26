package com.tian.controller;

import com.aliyuncs.utils.StringUtils;
import com.tian.service.serviceImpl.SendMessageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

//阿里短信验证功能！
@RestController
@RequestMapping("/iphone")
public class SendMessageController {
    @Autowired
    private SendMessageImpl sendMessage;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("/send/{iphone}")
    public String code(@PathVariable("iphone") String phone){
        //调用发送方法（模拟真实业务！）
        String code = redisTemplate.opsForValue().get(phone);
        if(!StringUtils.isEmpty(code)){
            return phone + ":" + code + "已存在，还没过期";
        }
        //生成一个4为随机验证码
        code = UUID.randomUUID().toString().substring(0,4);
        HashMap<String,Object> map = new HashMap<>();
        map.put("code",code);
        //发送即可
        boolean issend = sendMessage.send(phone,"TemplateCode",map);
        if(issend){
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);//设置5分钟过期
            return phone + ":" + code + "信息已经发送成功！";
        }else {
            return phone + ":" + code + "信息已经发送失败！";
        }
    }
}
