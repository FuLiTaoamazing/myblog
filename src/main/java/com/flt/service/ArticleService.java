package com.flt.service;

import com.flt.entity.Comment;
import com.flt.vo.ResultVO;


public interface ArticleService {
    ResultVO articleIndex();


    ResultVO selectBlogByTagId(String tagId);

    ResultVO blogInfo(Integer blogId);

    ResultVO saveComment(Comment comment);
}
