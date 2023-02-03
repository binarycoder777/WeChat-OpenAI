package com.cqut.atao.wechat.test;

import com.cqut.atao.wechat.domain.ai.OpenAI;
import com.cqut.atao.wechat.web.WeChatApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ApiTest.java
 * @Description api test
 * @createTime 2023年02月03日 14:35:00
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeChatApplication.class)
public class ApiTest {

    @Resource
    private OpenAI openAI;

    @Test
    public void testOpenAI() throws IOException {
        String question = "Java之父是谁";
        log.info("结果->{}",openAI.doChatGPT(question));
    }

}

