package com.cqut.atao.wechat.domain.ai.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OpenAIConfig.java
 * @Description openai配置信息类
 * @createTime 2023年02月03日 14:24:00
 */
@Data
@Configuration
public class OpenAIConfig {

    @Value("${openai.chatgpt.openai-key}")
    private String openAIKey;

}
