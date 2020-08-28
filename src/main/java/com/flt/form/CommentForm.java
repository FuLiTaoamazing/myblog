package com.flt.form;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:
 * path: myblog-com.flt.form-CommentForm
 * date: 2020/8/5 9:17
 */
@Data
public class CommentForm {
    private String nikeName;
    private String email;
    private String blogId;
    private String replyId;
}
