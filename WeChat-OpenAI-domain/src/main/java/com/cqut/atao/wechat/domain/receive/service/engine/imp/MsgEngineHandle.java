package com.cqut.atao.wechat.domain.receive.service.engine.imp;

import com.cqut.atao.wechat.common.utils.XmlUtil;
import com.cqut.atao.wechat.domain.receive.model.MessageReq;
import com.cqut.atao.wechat.domain.receive.model.MessageRes;
import com.cqut.atao.wechat.domain.receive.service.engine.EngineBase;
import com.cqut.atao.wechat.domain.receive.service.logic.LogicFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MsgEngineHandle.java
 * @Description 消息处理
 * @createTime 2022年06月19日 14:05:00
 */
@Service("msgEngineHandle")
public class MsgEngineHandle extends EngineBase {

    @Value("${wx.config.originalid}")
    private String originalId;

    @Override
    public String process(MessageReq request) throws Exception {
        LogicFilter router = super.router(request);
        if (null == router) {
            return null;
        }
        String resultStr = router.filter(request);
        if (StringUtils.isBlank(resultStr)) {
            return "";
        }

        //反馈信息[文本]
        MessageRes res = new MessageRes();
        res.setToUserName(request.getOpenId());
        res.setFromUserName(originalId);
        res.setCreateTime(String.valueOf(System.currentTimeMillis() / 1000L));
        res.setMsgType("text");
        res.setContent(resultStr);
        return XmlUtil.beanToXml(res);
    }

}

