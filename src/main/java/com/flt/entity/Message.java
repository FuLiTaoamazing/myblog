package com.flt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:
 * path: myblog-com.flt.entity-Message
 * date: 2020/7/31 11:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Integer id;
    private String nikeName;
    private String targetName;
    private String email;
    private String content;
    private Date createTime;
    //子回复的ID 假如为-1的话代表他是一个parent
    private String replyId;
    private String imag;
}
