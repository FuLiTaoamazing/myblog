package com.flt.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:这是博客详细页面的VO 视图层对象
 * path: myblog-com.flt.vo-BlogInfoVO
 * date: 2020/8/4 13:25
 */
@Data
public class BlogInfoVO {
    private String title;
    private Date updateTime;
    private Integer views;
    private String author;
    private String content;
    private String createDay;
    private String createYear;
    private String createMonth;
    private boolean conmentabled;
    private List<CommentVO> comments;

}
