package com.flt.controller;

import com.flt.enums.BlogExceptionEnum;
import com.flt.exceptions.BlogException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:
 * path: myblog-com.flt.controller-GlobalExceptionController
 * date: 2020/8/28 12:30
 */
@ControllerAdvice
public class GlobalExceptionController {


    @ExceptionHandler(BlogException.class)
    @ResponseBody
    public Map messageException() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", BlogExceptionEnum.SAVE_MESSAGE_FAIL.getCode());
        result.put("msg", BlogExceptionEnum.SAVE_MESSAGE_FAIL.getMsg());
        return result;
    }



}
