package com.flt.mapper;

import com.flt.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    List<Comment> findParentComment(Integer blogId);

    List<Comment> findChildComment(@Param("targetId") Integer targetId, @Param("blogId") Integer blogId);


    int saveComment(Comment comment);

}
