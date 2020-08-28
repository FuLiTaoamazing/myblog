package com.flt.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:
 * path: myblog-com.flt.entity-Comment
 * date: 2020/8/4 15:38
 */
@Data
public class Comment {
    private Integer id;
    private Integer blogId;
    private Integer replyId;
    private String nikeName;
    private String targetName;
    private String email;
    private Date createTime;
    private String content;
    private String imag;

}
