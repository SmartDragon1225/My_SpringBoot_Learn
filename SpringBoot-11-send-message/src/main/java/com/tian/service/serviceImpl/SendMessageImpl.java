package com.tian.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.tian.service.SendMasssge;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SendMessageImpl implements SendMasssge {
    @Override
    public boolean send(String phoneNumber, String TemplateCode, Map<String, Object> map) {
        //连接阿里云
        DefaultProfile profile = DefaultProfile.getProfile("cn-qingdao", "<accessKeyId>", "<accessSecret>");
        IAcsClient client = new DefaultAcsClient(profile);          //<accessKeyId>，<accessSecret>注册的账号密码！

        //构建请求
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");//默认
        request.setSysVersion("2017-05-25");//默认
        request.setSysAction("SendSms");//默认

        //自定义参数（手机号，验证码，签名，模板等！）
        request.putQueryParameter("phoneNumber","手机号");//手机号
        request.putQueryParameter("SignName","田智龙通知您");
        request.putQueryParameter("TemplateCode","注册审核通过的模板名称");//注册审核通过的模板名称

        request.putQueryParameter("TemplateParam", JSON.toJSONString(map));

        try {
            //自定义参数（手机号，验证码，签名，模板等！）
            CommonResponse response = client.getCommonResponse(request);//连接
            System.out.println(response.getData());
            return response.getHttpResponse().isSuccess();//返回是否发送成功
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }
}
