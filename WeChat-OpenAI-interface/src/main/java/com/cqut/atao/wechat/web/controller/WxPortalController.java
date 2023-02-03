package com.cqut.atao.wechat.web.controller;

import com.cqut.atao.wechat.application.WxReceiveService;
import com.cqut.atao.wechat.application.WxValidateService;
import com.cqut.atao.wechat.application.req.SendMessageReq;
import com.cqut.atao.wechat.common.utils.XmlUtil;
import com.cqut.atao.wechat.domain.receive.model.MessageRes;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName WxPortalController.java
 * @Description 微信公众号入口
 * @createTime 2022年06月19日 14:08:00
 */
@Slf4j
@RestController
@RequestMapping("/wx/portal/{appid}")
public class WxPortalController {

    @Resource
    private WxValidateService wxValidateService;

    @Resource
    private WxReceiveService wxReceiveService;

    /**
     * 处理微信服务器发来的get请求，进行签名的验证
     * <p>
     * appid     微信端AppID
     * signature 微信端发来的签名
     * timestamp 微信端发来的时间戳
     * nonce     微信端发来的随机字符串
     * echostr   微信端发来的验证字符串
     */
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String validate(@PathVariable String appid,
                           @RequestParam(value = "signature", required = false) String signature,
                           @RequestParam(value = "timestamp", required = false) String timestamp,
                           @RequestParam(value = "nonce", required = false) String nonce,
                           @RequestParam(value = "echostr", required = false) String echostr) {
        try {
            log.info("微信公众号验签信息{}开始 [{}, {}, {}, {}]", appid, signature, timestamp, nonce, echostr);
            if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
                throw new IllegalArgumentException("请求参数非法，请核实!");
            }
            boolean check = wxValidateService.checkSign(signature, timestamp, nonce);
            log.info("微信公众号验签信息{}完成 check：{}", appid, check);
            if (!check) {
                return null;
            }
            return echostr;
        } catch (Exception e) {
            log.error("微信公众号验签信息{}失败 [{}, {}, {}, {}]", appid, signature, timestamp, nonce, echostr, e);
            return null;
        }
    }

    /**
     * 此处是处理微信服务器的消息转发的
     */
    @PostMapping(produces = "application/xml; charset=UTF-8")
    public String post(@PathVariable String appid,
                       @RequestBody String requestBody,
                       @RequestParam("signature") String signature,
                       @RequestParam("timestamp") String timestamp,
                       @RequestParam("nonce") String nonce,
                       @RequestParam("openid") String openid,
                       @RequestParam(name = "encrypt_type", required = false) String encType,
                       @RequestParam(name = "msg_signature", required = false) String msgSignature) {
        try {
            log.info("接收微信公众号信息请求{}开始 {}", openid, requestBody);
            MessageRes message = XmlUtil.xmlToBean(requestBody, MessageRes.class);
            SendMessageReq req = new SendMessageReq();
            req.setOpenId(openid);
            req.setFromUserName(message.getFromUserName());
            req.setMsgType(message.getMsgType());
            req.setContent(StringUtils.isBlank(message.getContent()) ? null : message.getContent().trim());
            req.setEvent(message.getEvent());
            req.setCreateTime(new Date(Long.parseLong(message.getCreateTime()) * 1000L));
            // 此处需要异步处理消息（chat gpt请求响应时间比较长）
            String result = wxReceiveService.doReceive(req);
            log.info("接收微信公众号信息请求{}完成 {}", openid, result);
            return result;
        } catch (Exception e) {
            log.error("接收微信公众号信息请求{}失败 {}", openid, requestBody, e);
            return "";
        }
    }

}

