package com.flt.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:
 * path: myblog-com.flt.entity-Tag
 * date: 2020/8/3 10:00
 */
@Data
public class Tag {
    private Integer id;
    private String tagName;//标签名字
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
    private Integer blogCount;//标签下的博客数量方便标签排序
}
