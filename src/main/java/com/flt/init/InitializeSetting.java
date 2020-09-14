package com.flt.init;

import com.flt.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @ClassName: InitializeSetting
 * @description:项目启动初始化
 * @author: fulitao
 * @create: 2020-09-14 09:46
 **/
@Component
@Order(3)
public class InitializeSetting implements ApplicationRunner {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
