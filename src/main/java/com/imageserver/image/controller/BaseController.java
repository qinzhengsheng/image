package com.imageserver.image.controller;

import com.imageserver.image.common.CommonCode;
import com.imageserver.image.common.ResultBody;

/**
 * @author qinzhengsheng
 * @DATE 2020/4/10
 * @DESC 公共控制层
 */
public class BaseController {




    /**
     * 成功
     *
     * @return
     */
    public static ResultBody success() {
        return success(null);
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static ResultBody success(Object data) {
        ResultBody rb = new ResultBody();
        rb.setCode(CommonCode.SUCCESS.getCode());
        rb.setMessage(CommonCode.SUCCESS.getMessage());
        rb.setResultBody(data);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error() {
        ResultBody rb = new ResultBody();
        rb.setCode(CommonCode.FAIL.getCode());
        rb.setMessage(CommonCode.FAIL.getMessage());
        rb.setResultBody(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(String code, String message) {
        ResultBody rb = new ResultBody();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setResultBody(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error( String message) {
        ResultBody rb = new ResultBody();
        rb.setCode("-1");
        rb.setMessage(message);
        rb.setResultBody(null);
        return rb;
    }






}