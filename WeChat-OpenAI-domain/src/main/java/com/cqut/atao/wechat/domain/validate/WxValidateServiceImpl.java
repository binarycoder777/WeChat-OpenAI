package com.cqut.atao.wechat.domain.validate;

import com.cqut.atao.wechat.application.WxValidateService;
import com.cqut.atao.wechat.common.utils.SignatureUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName WxValidateServiceImpl.java
 * @Description 消息验证
 * @createTime 2023年02月03日 11:50:00
 */
@Service("wxValidateService")
public class WxValidateServiceImpl implements WxValidateService {

    @Value("${wx.config.token}")
    private String token;

    @Override
    public boolean checkSign(String signature, String timestamp, String nonce) {
        return SignatureUtil.check(token, signature, timestamp, nonce);
    }

}
