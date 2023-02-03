package com.cqut.atao.wechat.domain.ai;

import java.io.IOException;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OpenAI.java
 * @Description ChatGPT open ai 接口
 * @createTime 2023年02月03日 14:04:00
 */
public interface OpenAI {

    /**
     * 执行chatgpt
     * @param question 问题描述
     * @return {@link String}
     * @throws IOException
     */
    String doChatGPT(String question) throws IOException;

}
