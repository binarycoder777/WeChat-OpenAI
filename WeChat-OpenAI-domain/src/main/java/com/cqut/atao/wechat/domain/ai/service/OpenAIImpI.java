package com.cqut.atao.wechat.domain.ai.service;

import com.alibaba.fastjson.JSON;
import com.cqut.atao.wechat.domain.ai.OpenAI;
import com.cqut.atao.wechat.domain.ai.config.OpenAIConfig;
import com.cqut.atao.wechat.domain.ai.model.aggregates.AIAnswer;
import com.cqut.atao.wechat.domain.ai.model.vo.Choices;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OpenAIImpI.java
 * @Description OpenAI接口实现
 * @createTime 2023年02月03日 14:06:00
 */
@Slf4j
@Service("openAI")
public class OpenAIImpI implements OpenAI {

    @Resource
    private OpenAIConfig openAIConfig;

    @Override
    public String doChatGPT(String question) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 封装请求
        HttpPost post = new HttpPost("https://api.openai.com/v1/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer " + openAIConfig.getOpenAIKey());

        String paramJson = "{\"model\": \"text-davinci-003\", \"prompt\": \"" + question + "\", \"temperature\": 0, \"max_tokens\": 1024}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        // 执行请求
        CloseableHttpResponse response = httpClient.execute(post);
        // 封装结果
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String jsonStr = EntityUtils.toString(response.getEntity());
            AIAnswer aiAnswer = JSON.parseObject(jsonStr, AIAnswer.class);
            StringBuilder answers = new StringBuilder();
            List<Choices> choices = aiAnswer.getChoices();
            for (Choices choice : choices) {
                answers.append(choice.getText());
            }
            return answers.toString();
        } else {
            throw new RuntimeException("api.openai.com Err Code is " + response.getStatusLine().getStatusCode());
        }
    }
}
