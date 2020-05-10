package com.wuxiaotian.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@Data
@ToString
@ApiModel(value = "JsonResult", description = "JSON请求结果")
public class JsonResult<T> {
    /**
     * 状态码
     */
    @ApiModelProperty(value = "状态码")
    private int code;

    /**
     * 信息
     */
    @ApiModelProperty(value = "信息")
    private String msg;

    /**
     * 数据
     */
    @ApiModelProperty(value = "数据")
    private T data;

    public JsonResult() {
    }

    public JsonResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }
    public JsonResult(ResponseCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = data;
    }
}
