package com.flt.service.impl;

import com.flt.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: RedisService
 * @description:
 * @author: fulitao
 * @create: 2020-09-11 16:46
 **/
@Component
public class RedisService {
    @Autowired
    private RedisUtil redisUtil;

    /*
     * @Description:不同IP的访问次数和页面点击次数
     * @Author: fulitao
     * @param ip:
     * @return: void
     * @Date: 2020/9/14 上午8:57
     **/
    public void TotalVisitsIncrement(String ip) {
        System.out.println("当前访问主机的客户端IP地址为:" + ip);
        if (!redisUtil.hasKey(ip)) {
            //把当前的IP地址放到Redis设置过期时间三十分钟!
            redisUtil.set(ip,"this is timeout");
            boolean expire = redisUtil.expire(ip, 1800);
            System.out.println("设置过期时间是否成功" + expire
            );
            //当Redis没有当前访问客户端的Ip的时候才进行+1操作
            redisUtil.increment("hits", 1L);
        }
        redisUtil.sSet("ipCount", ip);
    }


}
