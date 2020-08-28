package com.flt.exceptions;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:
 * path: myblog-com.flt.exceptions-BlogException
 * date: 2020/8/28 12:32
 */
//Blog全局异常
public class BlogException extends Exception {

    public BlogException() {
    }

    public BlogException(String message) {
        super(message);
    }
}
