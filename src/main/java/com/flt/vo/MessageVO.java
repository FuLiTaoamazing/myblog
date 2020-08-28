package com.flt.vo;

import com.flt.entity.Message;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:留言视图层对象
 * path: myblog-com.flt.vo-MessageVO
 * date: 2020/7/31 11:49
 */
@Data
public class MessageVO {
    private Message parent;
    private List<Message> childs;
}
