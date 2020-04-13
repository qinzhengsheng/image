package com.imageserver.image.config;

import com.imageserver.image.bean.BusinessException;
import com.imageserver.image.common.CommonCode;
import com.imageserver.image.common.ResultBody;
import com.imageserver.image.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author qinzhengsheng
 * @DATE 2020/4/13
 * @DESC 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends BaseController {


    @ExceptionHandler(value = BusinessException.class)
    public ResultBody businessExceptionHandler(BusinessException e) {
        log.error("出现错误，错误原因："+e.getMessage());
        return error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResultBody otherExceptionHandler(Exception e) {
        log.error("出现错误，错误原因："+e.getMessage());
        return error(CommonCode.EXCEPTION.getCode(), e.getMessage());
    }

}