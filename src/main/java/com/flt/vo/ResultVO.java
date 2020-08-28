package com.flt.vo;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:统一结果封装VO
 * path: myblog-com.flt.vo-ResultVO
 * date: 2020/7/31 11:50
 */
@Data
public class ResultVO {
    private Integer code;
    private boolean success;
    private Integer count;
    private String msg;
    private Object data;
}
