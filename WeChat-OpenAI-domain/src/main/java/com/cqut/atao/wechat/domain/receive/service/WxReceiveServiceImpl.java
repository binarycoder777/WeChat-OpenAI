package com.cqut.atao.wechat.domain.receive.service;

import cn.hutool.core.bean.BeanUtil;
import com.cqut.atao.wechat.application.WxReceiveService;
import com.cqut.atao.wechat.application.req.SendMessageReq;
import com.cqut.atao.wechat.domain.receive.model.MessageReq;
import com.cqut.atao.wechat.domain.receive.service.engine.Engine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName WxReceiveServiceImpl.java
 * @Description 处理接收信息
 * @createTime 2022年06月19日 22:26:00
 */
@Slf4j
@Service("wxReceiveService")
public class WxReceiveServiceImpl implements WxReceiveService {

    @Resource
    private Engine msgEngineHandle;

    @Override
    public String doReceive(SendMessageReq req) throws Exception {
        MessageReq messageReq = BeanUtil.copyProperties(req, MessageReq.class);
        return msgEngineHandle.process(messageReq);
    }

}

