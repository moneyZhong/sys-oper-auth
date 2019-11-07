package com.sys.service.impl;


import com.google.gson.Gson;
import com.sys.comm.dingtalk.DingtalkChatbotClient;
import com.sys.comm.dingtalk.message.TextMessage;
import com.sys.comm.util.JsonResult;
import com.sys.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageServiceImpl implements IMessageService {
    private DingtalkChatbotClient client = new DingtalkChatbotClient();

    @Value("${ding.weebhook}")
    private String dingUri;
    @Value("${ding.env}")
    private String dingEnv;




    @Async
    @Override
    public void sendDingDingMsg(String title, String content) {
        try{
            if(content.length() > 1000){
                content = content.substring(0,1000);
            }
            TextMessage message = new TextMessage(String.format("【%s】%s\r\n详细信息：%s",dingEnv,title,content));
            JsonResult result = client.send(dingUri, message);
            log.info("钉钉发送返回："+new Gson().toJson(result));
        }catch (Exception e){
            log.error("保理服务钉钉消息发送失败",e);
        }
    }


}
