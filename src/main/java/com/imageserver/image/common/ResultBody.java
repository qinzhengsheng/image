package com.imageserver.image.common;

import lombok.Data;

/**
 * @author qinzhengsheng
 * @DATE 2020/4/13
 * @DESC 通用返回结果类
 */
@Data
public class ResultBody {

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回实体
     */
    private Object resultBody;


}