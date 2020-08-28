package com.flt.service;

import com.flt.entity.Message;
import com.flt.vo.ResultVO;

import java.util.List;

public interface MessageService {

    public ResultVO saveMessage(Message message);

    public List<Message> findAllMessage();

    ResultVO saveReplyMessage(Message replyMsg);

    ResultVO messageList();

}
