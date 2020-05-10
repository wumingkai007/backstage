package com.wuxiaotian.util;

public enum ResponseCode {

    SUCCESS(200, "操作成功"),
    ERROR(500);
    private int code;
    private String msg;

    private ResponseCode(int code) {
        this.code = code;
    }

    private ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
