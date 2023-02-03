package com.cqut.atao.wechat.domain.receive.service.logic.imp;

import com.cqut.atao.wechat.domain.ai.OpenAI;
import com.cqut.atao.wechat.domain.receive.model.MessageReq;
import com.cqut.atao.wechat.domain.receive.service.logic.LogicFilter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName LotteryLogicFilter.java
 * @Description 消息服务
 * @createTime 2022年06月19日 14:03:00
 */
@Service("messageFilter")
public class MessageLogicFilter implements LogicFilter {

    @Resource
    private OpenAI openAI;

    @Override
    public String filter(MessageReq request) throws IOException {
        return openAI.doChatGPT(request.getContent());
    }

}

