package com.cqut.atao.wechat.domain.receive.service.engine;

import com.cqut.atao.wechat.domain.receive.model.MessageReq;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Engine.java
 * @Description 消息引擎接口
 * @createTime 2022年06月19日 14:04:00
 */
public interface Engine {

    /**
     * 过滤器
     * @param request       入参
     * @return              出参
     * @throws Exception    异常
     */
    String process(MessageReq request) throws Exception;

}

