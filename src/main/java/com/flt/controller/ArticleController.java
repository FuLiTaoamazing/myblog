package com.flt.controller;

import com.flt.entity.Comment;
import com.flt.form.CommentForm;
import com.flt.service.ArticleService;
import com.flt.service.TagService;
import com.flt.util.ResultVOUtils;
import com.flt.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:文章页面的控制器
 * path: myblog-com.flt.controller-AricleControllere
 * date: 2020/8/3 13:17
 */
@Controller
@RequestMapping(value = "/article/")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TagService tagService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    @ResponseBody
    public ResultVO articleIndex() {
        ResultVO resultVO = articleService.articleIndex();
        return resultVO;
    }

    @RequestMapping(value = "blogsByTagId",method = RequestMethod.GET)
    @ResponseBody
    public ResultVO blogsByTagId(@RequestParam("tagId") String tagId) {
        ResultVO resultVO = articleService.selectBlogByTagId(tagId);
        return resultVO;
    }

    @RequestMapping(value = "blogInfo",method = RequestMethod.GET)
    @ResponseBody
    public ResultVO BlogInfo(@RequestParam("id") Integer blogId) {
        ResultVO resultVO = articleService.blogInfo(blogId);
        return resultVO;
    }

    @RequestMapping(value = "commentBlog",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO commentBlog(@RequestBody Comment comment) {

        ResultVO resultVO = articleService.saveComment(comment);
        return ResultVOUtils.saveSuccess();
    }

    @RequestMapping(value = "replyComment", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO replyComment(@RequestBody Comment comment){
        ResultVO resultVO=articleService.saveComment(comment);
        return resultVO;
    }
}
