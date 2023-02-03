package com.cqut.atao.wechat.domain.receive.service.logic;

import com.cqut.atao.wechat.domain.receive.model.MessageReq;

import java.io.IOException;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName LogicFilter.java
 * @Description 逻辑接口
 * @createTime 2022年06月19日 14:02:00
 */
public interface LogicFilter {
    String filter(MessageReq request) throws IOException;
}
