package com.atom.message.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.atom.bas.common.exception.MsgException;
import com.atom.message.dto.SMSEntity;
import com.atom.message.service.AliYunSMSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("aliYunSMSServiceImpl")
public class AliYunSMSServiceImpl implements AliYunSMSService {

    private Logger logger = LoggerFactory.getLogger(AliYunSMSServiceImpl.class);

    @Value("${aliYun.SMS.accessKeyId}")
    private String accessKeyId;

    @Value("${aliYun.SMS.accessKeySecret}")
    private String accessKeySecret;

    @Value("${aliYun.SMS.sign}")
    private String sign;


    @Override
    public boolean send(SMSEntity entity) {
        try {
            //  设置超时时间
            System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
            System.setProperty("sun.net.client.defaultReadTimeout", "10000");

            // 选择短信节点，一般建议使用和自己最近的接入口
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");
            IAcsClient acsClient = new DefaultAcsClient(profile);

            SendSmsRequest request = new SendSmsRequest();
            request.setMethod(MethodType.POST);
            request.setSignName("怡泰祥");
            request.setOutId("yourOutId");

            // 待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
            request.setPhoneNumbers(entity.getTarget());
            request.setTemplateCode(entity.getTemplateCode());

            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
            if(entity.getParams().size() > 0){
                request.setTemplateParam(JSONObject.toJSONString(entity.getParams()));
            }
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error("发送短信失败", e.getLocalizedMessage());
            throw new MsgException("发送短信失败");
        }
    }



}
