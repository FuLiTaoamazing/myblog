package com.flt.enums;

public enum ResponseStatusEnum {
    SUCCESS(200, "成功"),
    ERROR(500, "未知错误"),
    EXPETION(400,"服务器异常");
    private Integer code;
    private String msg;

    ResponseStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
