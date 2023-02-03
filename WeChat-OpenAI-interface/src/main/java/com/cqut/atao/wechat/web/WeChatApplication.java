package com.cqut.atao.wechat.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName WeChatApplication.java
 * @Description 启动类
 * @createTime 2023年02月03日 11:19:00
 */
@SpringBootApplication(scanBasePackages = "com.cqut.atao.wechat")
public class WeChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeChatApplication.class, args);
    }

}
