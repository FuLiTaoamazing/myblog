package com.flt.vo;

import com.flt.entity.Blog;
import com.flt.entity.Tag;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:文章页面的初始化视图层对象
 * path: myblog-com.flt.vo-AricleVO
 * date: 2020/8/3 13:15
 */
@Data
public class ArticleVO {
    private List<BlogIndexVO> blogs;
    private List<Blog> hotList;
    private List<Tag> tagList;
    private List<Blog> topList;

}
