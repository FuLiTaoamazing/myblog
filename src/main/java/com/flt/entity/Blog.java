package com.flt.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:
 * path: myblog-com.flt.entity-Blog
 * date: 2020/8/3 9:59
 */
@Data
public class Blog {
    private Integer id;
    private String content;//博客内容
    private String description;//博客简介
    private String title;//标题
    private Integer views;//阅读人数
    private String tags;//标签  可以拥有多个标签
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
    private String firstPicture;//首图
    private boolean conmentabled;//是否开启评论
    private boolean recommentd;//是否推荐 类似置顶

}
