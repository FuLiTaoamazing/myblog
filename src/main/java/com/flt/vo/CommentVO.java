package com.flt.vo;

import com.flt.entity.Comment;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:
 * path: myblog-com.flt.vo-CommentVO
 * date: 2020/8/4 16:11
 */
@Data
public class CommentVO {
    private Comment parent;
    private List<Comment> childs;
}
