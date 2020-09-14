package com.flt.interceptor;

import com.flt.service.impl.RedisService;
import com.flt.util.ContextUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: HitsInterceptor
 * @description:
 * @author: fulitao
 * @create: 2020-09-14 08:58
 **/
public class HitsInterceptor implements HandlerInterceptor {


    public HitsInterceptor() {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        String ip
                = request.getRemoteAddr();
        redisService.TotalVisitsIncrement(ip);
        return true;
    }


}
