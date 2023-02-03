package com.cqut.atao.wechat.application;

import com.cqut.atao.wechat.application.req.SendMessageReq;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName IWxReceiveService.java
 * @Description 处理接收信息
 * @createTime 2022年06月19日 13:55:00
 */
public interface WxReceiveService {

    /**
     * 接收信息
     *
     * @param req    入参
     * @return                  出惨
     * @throws Exception        异常
     */
    String doReceive(SendMessageReq req) throws Exception;

}
