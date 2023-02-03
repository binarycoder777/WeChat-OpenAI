package com.cqut.atao.wechat.domain.receive.service.engine;

import com.cqut.atao.wechat.domain.receive.service.logic.LogicFilter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName EngineConfig.java
 * @Description 消息配置
 * @createTime 2022年06月19日 14:04:00
 */
public class EngineConfig {

    @Resource
    private LogicFilter messageFilter;

    @Resource
    private LogicFilter subscribeFilter;

    @Resource
    private LogicFilter unsubscribeFilter;

    protected static Map<String, Map<String, LogicFilter>> logicFilterMap = new HashMap<>();

    @PostConstruct
    public void init() {

        logicFilterMap.put("text", new HashMap<String, LogicFilter>() {{
            put("message", messageFilter);
        }});

        logicFilterMap.put("event", new HashMap<String, LogicFilter>() {
            {
                put("subscribe", subscribeFilter);
                put("unsubscribe", unsubscribeFilter);
            }
        });
    }

}

