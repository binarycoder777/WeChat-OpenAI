package com.cqut.atao.wechat.domain.ai.model.aggregates;

import com.cqut.atao.wechat.domain.ai.model.vo.Choices;
import lombok.Data;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName AIAnswer.java
 * @Description 检索答案
 * @createTime 2023年02月03日 14:09:00
 */
@Data
public class AIAnswer {

    private String id;

    private String object;

    private int created;

    private String model;

    private List<Choices> choices;

}
