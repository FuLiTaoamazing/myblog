package com.flt.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ContextUtil
 * @description:
 * @author: fulitao
 * @create: 2020-09-14 09:02
 **/
@Component
public class ContextUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ContextUtil.context = applicationContext;
    }

    public static  Object getBean(String beanName) {
        Object bean =context.getBean(beanName);
        return bean;
    }
}
