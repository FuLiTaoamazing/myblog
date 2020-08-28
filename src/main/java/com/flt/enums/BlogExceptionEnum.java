package com.flt.enums;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:
 * path: myblog-com.flt.enums-BlogExceptionEnums
 * date: 2020/8/28 12:34
 */
public enum BlogExceptionEnum {
    SAVE_MESSAGE_FAIL(405, "留言失败"),
    SAVE_MESSAGE_SUCCESS(200, "留言成功"),
    SAVE_COMMONS_FAIL(405, "评论失败"),
    SAVE_COMMONS_SUCCESS(200, "评论成功");

    private Integer code;
    private String msg;

    BlogExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
