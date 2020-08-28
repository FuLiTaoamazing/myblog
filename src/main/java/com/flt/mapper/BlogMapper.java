package com.flt.mapper;

import com.flt.entity.Blog;
import com.flt.vo.BlogIndexVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogMapper {
    List<Blog> findAll();

    List<Blog> findBlogIndex();

    List<Blog> findHotList();

    //找到三个置顶博客
    List<Blog> findTopBlog();

    //按分类来查找博客
    List<Blog> findBlogsByTagId(@Param("tagId") String tagId);

    int saveBlog(Blog blog);

    Blog findBlogById(Integer Id);
}
