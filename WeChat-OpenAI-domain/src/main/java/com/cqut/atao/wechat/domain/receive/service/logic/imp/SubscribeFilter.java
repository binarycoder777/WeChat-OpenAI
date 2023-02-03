package com.cqut.atao.wechat.domain.receive.service.logic.imp;

import com.cqut.atao.wechat.domain.receive.model.MessageReq;
import com.cqut.atao.wechat.domain.receive.service.logic.LogicFilter;
import org.springframework.stereotype.Service;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName SubscribeFilter.java
 * @Description 关注微信公众号
 * @createTime 2022年06月19日 14:03:00
 */
@Service("subscribeFilter")
public class SubscribeFilter implements LogicFilter {

    @Override
    public String filter(MessageReq request) {
        return "感谢关注，快来参与有奖问答吧！";
    }

}
