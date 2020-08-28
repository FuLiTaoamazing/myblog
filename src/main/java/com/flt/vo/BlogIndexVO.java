package com.flt.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.flt.entity.Tag;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:视图层的VO对象  this VO  View Object
 * path: myblog-com.flt.vo-BlogVO
 * date: 2020/8/3 13:06
 */
@Data
public class BlogIndexVO {
    private Integer id;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String description;
    private Integer views;
    private Integer comments;
    private String firstPicture;
    private boolean recommentd;
    private List<Tag> tags;
}
