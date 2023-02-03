package com.cqut.atao.wechat.application.req;

import lombok.Data;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MessageReq.java
 * @Description 消息请求
 * @createTime 2023年02月03日 11:57:00
 */
@Data
public class SendMessageReq {

    /**
     * 开放id
     */
    private String openId;

    /**
     * 发送人姓名
     */
    private String fromUserName;

    /**
     * 消息类型
     */
    private String msgType;

    /**
     * 消息类容
     */
    private String content;

    /**
     * 事件
     */
    private String event;

    /**
     * 时间
     */
    private Date createTime;

}
