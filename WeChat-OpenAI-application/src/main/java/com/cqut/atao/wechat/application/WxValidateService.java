package com.cqut.atao.wechat.application;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName WxValidateService.java
 * @Description 微信验证服务
 * @createTime 2023年02月03日 11:50:00
 */
public interface WxValidateService {

    /**
     * 验签
     * @param signature 签名
     * @param timestamp 时间
     * @param nonce     当前
     * @return          结果
     */
    boolean checkSign(String signature, String timestamp, String nonce);


}
