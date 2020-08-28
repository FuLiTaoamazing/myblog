package com.flt.service.impl;

import com.flt.entity.Blog;
import com.flt.entity.Comment;
import com.flt.entity.Tag;
import com.flt.enums.ResponseStatusEnum;
import com.flt.mapper.BlogMapper;
import com.flt.mapper.CommentMapper;
import com.flt.mapper.TagMapper;
import com.flt.service.ArticleService;
import com.flt.util.DateUtils;
import com.flt.util.ResultVOUtils;
import com.flt.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:
 * path: myblog-com.flt.service.impl-ArticleServiceImpl
 * date: 2020/8/3 13:19
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public ResultVO articleIndex() {
        ResultVO resultVO = new ResultVO();
        List<Blog> blogs = blogMapper.findBlogIndex();
        List<BlogIndexVO> blogIndexVOS = new ArrayList<>();
        ArticleVO articleVO = new ArticleVO();
        List<Tag> tags = null;
        //对数据库的blog对象进行处理
        for (Blog blog : blogs) {
            tags = new ArrayList<>();
            BlogIndexVO blogIndexVO = new BlogIndexVO();
            BeanUtils.copyProperties(blog, blogIndexVO);
            String[] tagsStr = blog.getTags().split(",");
            for (String tag : tagsStr) {
                Tag tagById = tagMapper.findTagById(Integer.parseInt(tag));
                tags.add(tagById);
            }
            blogIndexVO.setTags(tags);
            blogIndexVO.setDate(blog.getCreateTime());
            blogIndexVOS.add(blogIndexVO);
        }
        List<Blog> hotList = blogMapper.findHotList();
        List<Tag> tagListg = tagMapper.findAllOrderCount();
        List<Blog> topBlog = blogMapper.findTopBlog();
        articleVO.setBlogs(blogIndexVOS);
        articleVO.setTagList(tagListg);
        articleVO.setHotList(hotList);
        articleVO.setTopList(topBlog);
        resultVO.setCode(ResponseStatusEnum.SUCCESS.getCode());
        resultVO.setMsg(ResponseStatusEnum.SUCCESS.getMsg());
        resultVO.setData(articleVO);
        resultVO.setSuccess(true);
        return resultVO;
    }


    @Override
    public ResultVO selectBlogByTagId(String tagId) {
        ResultVO resultVO = new ResultVO();
        List<BlogIndexVO> blogList = new ArrayList<>();
        List<Tag> tagList = null;
        List<Blog> blogs = null;

        if ("0".equals(tagId)) {
            blogs = blogMapper.findBlogIndex();
            for (Blog blog : blogs) {
                BlogIndexVO blogIndexVo = new BlogIndexVO();
                BeanUtils.copyProperties(blog, blogIndexVo);
                blogIndexVo.setDate(blog.getCreateTime());
                tagList = ResultVOUtils.getTagsByBlog(blog.getTags(), tagMapper);
                blogIndexVo.setTags(tagList);
                blogList.add(blogIndexVo);

            }
        } else {
            blogs = blogMapper.findBlogsByTagId(tagId);
            for (Blog blog : blogs) {
                BlogIndexVO blogIndexVo = new BlogIndexVO();
                BeanUtils.copyProperties(blog, blogIndexVo);
                blogIndexVo.setDate(blog.getCreateTime());
                String tagStr = blog.getTags();
                tagList = ResultVOUtils.getTagsByBlog(tagStr, tagMapper);
                blogIndexVo.setTags(tagList);
                blogList.add(blogIndexVo);
            }
        }


        resultVO.setData(blogList);
        resultVO.setCode(ResponseStatusEnum.SUCCESS.getCode());
        resultVO.setMsg(ResponseStatusEnum.SUCCESS.getMsg());


        return resultVO;
    }


    public ResultVO blogInfo(Integer blogId) {
        ResultVO resultVO = ResultVOUtils.sucess();
        BlogInfoVO blogInfoVO = new BlogInfoVO();
        Blog blog = blogMapper.findBlogById(blogId);
        //组装BlogVO的数据
        BeanUtils.copyProperties(blog, blogInfoVO);
        Date createTime = blog.getCreateTime();
        LocalDate localDate = DateUtils.DateConverLocalDate(createTime);
        String year = localDate.getYear() + "";
        String month = localDate.getMonthValue() + "";
        String day = localDate.getDayOfMonth() + "";
        blogInfoVO.setCreateDay(day);
        blogInfoVO.setCreateYear(year);
        blogInfoVO.setCreateMonth(month);
        blogInfoVO.setAuthor("大胖子程序员");
        //组装当前博客的评论数据
        //找到所有评论
        CommentVO commentVO = null;
        List<CommentVO> commentVOList = new ArrayList<>();
        List<Comment> parentComments = commentMapper.findParentComment(blogId);
        for (Comment parentComment : parentComments) {
            commentVO = new CommentVO();
            commentVO.setParent(parentComment);
            //通过父评论的ID和blogId找到属于当前评论的子评论
            List<Comment> childComments = commentMapper.findChildComment(parentComment.getId(), blogId);
            commentVO.setChilds(childComments);
            commentVOList.add(commentVO);
        }

        blogInfoVO.setComments(commentVOList);
        resultVO.setData(blogInfoVO);
        return resultVO;
    }


    public ResultVO saveComment(Comment comment) {
        ResultVO resultVO = null;
        comment.setImag("http://img.aiqi2126.cn/avatar.png");
        comment.setCreateTime(new Date());
        int i = commentMapper.saveComment(comment);

        if (i > 0) {
            resultVO = ResultVOUtils.saveSuccess();
        } else {
            resultVO = ResultVOUtils.saveError();
        }
        return resultVO;
    }


}
