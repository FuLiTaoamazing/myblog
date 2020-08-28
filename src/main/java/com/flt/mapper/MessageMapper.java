package com.flt.mapper;

import com.flt.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {

    List<Message> findAll();

    int addMessage(Message message);

    //找出所有父节点的留言并按照ID降序来排序
    List<Message> findAllParentMessage();

    //找出父节点的所有子节点并按照ID降序来排序
    List<Message> findAllChildMessageByReplyId(String replyId);
}
