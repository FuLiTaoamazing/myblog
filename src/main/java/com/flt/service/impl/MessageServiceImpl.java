package com.flt.service.impl;

import com.flt.entity.Message;
import com.flt.enums.ResponseStatusEnum;
import com.flt.mapper.MessageMapper;
import com.flt.service.MessageService;
import com.flt.util.ResultVOUtils;
import com.flt.vo.MessageVO;
import com.flt.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:
 * path: myblog-com.flt.service.impl-MessageServiceImpl
 * date: 2020/7/31 11:19
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    private static final String IMAG = "http://img.aiqi2126.cn/avatar.png";

    @Override
    public ResultVO saveMessage(Message message) {
        ResultVO resultVO = null;
        message.setReplyId("-1");
        message.setCreateTime(new Date());
        message.setImag(IMAG);
        int i = messageMapper.addMessage(message);
        if (i < 0) {
            resultVO = ResultVOUtils.saveError();
        } else {
            resultVO = ResultVOUtils.saveSuccess();
        }
        return resultVO;
    }

    public ResultVO saveReplyMessage(Message replyMsg) {
        ResultVO resultVO = null;
        replyMsg.setCreateTime(new Date());
        replyMsg.setImag(IMAG);
        int i = messageMapper.addMessage(replyMsg);
        if (i < 0) {
            resultVO = ResultVOUtils.saveError();
        } else {
            resultVO = ResultVOUtils.saveSuccess();
        }
        return resultVO;
    }

    @Override
    public List<Message> findAllMessage() {
        return messageMapper.findAll();
    }

    @Override
    public ResultVO messageList() {
        ResultVO result = new ResultVO();
        List<MessageVO> data = new ArrayList<>();
        List<Message> allParentMessage = messageMapper.findAllParentMessage();
        MessageVO messageVO = null;
        int i = 0;
        for (Message parent : allParentMessage) {
            messageVO = new MessageVO();
            messageVO.setParent(parent);
            String replyId = parent.getId() + "";
            if (!replyId.equals("-1")) {
                List<Message> childMessages = messageMapper.findAllChildMessageByReplyId(replyId);
                messageVO.setChilds(childMessages);
            }

            data.add(messageVO);
        }
        result.setCode(ResponseStatusEnum.SUCCESS.getCode());
        result.setMsg(ResponseStatusEnum.SUCCESS.getMsg());
        result.setCount(data.size());
        result.setSuccess(true);
        result.setData(data);
        return result;
    }
}
