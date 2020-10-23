package com.imageserver.image.bean;

import com.imageserver.image.common.CommonCode;
import lombok.Data;

/**
 * @author qinzhengsheng
 * @DATE 2020/4/13
 * @DESC 通用业务异常类
 */
@Data
public class BusinessException extends RuntimeException {

    private String code;
    private boolean isShowMsg = true;

    /**
     * 使用枚举传参
     *
     * @param errorCode 异常枚举
     */
    public BusinessException(CommonCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    /**
     * 使用自定义消息
     *
     * @param code 值
     * @param msg 详情
     */
    public BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
    }

}