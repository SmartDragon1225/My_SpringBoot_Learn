package com.tian.service;

import java.util.Map;

public interface SendMasssge {
    //发送信息验证码的方法
    boolean send(String phoneNumber, String TemplateCode, Map<String,Object>map);
}
