package com.cqut.atao.wechat.domain.receive.service.logic.imp;

import com.cqut.atao.wechat.domain.receive.model.MessageReq;
import com.cqut.atao.wechat.domain.receive.service.logic.LogicFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UnsubscribeFilter.java
 * @Description 取消关注微信公众号
 * @createTime 2022年06月19日 14:02:00
 */
@Service("unsubscribeFilter")
public class UnsubscribeFilter implements LogicFilter {

    private Logger logger = LoggerFactory.getLogger(UnsubscribeFilter.class);

    @Override
    public String filter(MessageReq request) {
        logger.info("用户{}已取消关注", request.getOpenId());
        return null;
    }

}
