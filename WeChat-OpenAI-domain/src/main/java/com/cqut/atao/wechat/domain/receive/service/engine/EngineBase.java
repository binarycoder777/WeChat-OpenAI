package com.cqut.atao.wechat.domain.receive.service.engine;

import com.cqut.atao.wechat.domain.receive.model.MessageReq;
import com.cqut.atao.wechat.domain.receive.service.logic.LogicFilter;

import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName EngineBase.java
 * @Description 引擎基类
 * @createTime 2022年06月19日 14:05:00
 */
public class EngineBase extends EngineConfig implements Engine {

    @Override
    public String process(MessageReq request) throws Exception {
        throw new RuntimeException("未实现消息引擎服务");
    }

    /**
     * 消息类型&业务内容路由器
     *
     * @param request 消息内容
     * @return 返回消息处理器
     */
    protected LogicFilter router(MessageReq request) {

        Map<String, LogicFilter> logicGroup = logicFilterMap.get(request.getMsgType());

        // 事件处理
        if ("event".equals(request.getMsgType())) {
            return logicGroup.get(request.getEvent());
        }

        // 内容处理
        if ("text".equals(request.getMsgType())) {
            return logicGroup.get("message");
        }

        return null;
    }

}
