package com.cqut.atao.wechat.domain.ai.model.vo;

import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Choices.java
 * @Description 选项
 * @createTime 2023年02月03日 14:08:00
 */
@Data
public class Choices {

    private String text;

    private int index;

    private String logprobs;

    private String finish_reason;

}
