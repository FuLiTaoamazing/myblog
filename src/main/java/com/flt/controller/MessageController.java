package com.flt.controller;

import com.flt.entity.Message;
import com.flt.service.MessageService;
import com.flt.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:留言的控制类
 * path: myblog-com.flt.controller-MessageController
 * date: 2020/7/31 10:58
 */
@Controller
@RequestMapping(value = "/message/")
public class MessageController {
    @Autowired
    MessageService messageService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO addMessage(@RequestBody Message message) {

        ResultVO resultVO = messageService.saveMessage(message);

        return resultVO;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public ResultVO messageList() {
        ResultVO resultVO = messageService.messageList();
        return resultVO;
    }

    @RequestMapping(value = "reply", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO replyMessage(@RequestBody Message message) {
        System.out.println(message);
        ResultVO resultVO = messageService.saveReplyMessage(message);
        return resultVO;
    }

}
