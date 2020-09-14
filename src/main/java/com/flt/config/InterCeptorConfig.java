package com.flt.config;

import com.flt.interceptor.HitsInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: InterCeptorConfig
 * @description:
 * @author: fulitao
 * @create: 2020-09-14 09:06
 **/
@Configuration
public class InterCeptorConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new HitsInterceptor());
        interceptorRegistration.addPathPatterns("/**");//拦截所有请求
        interceptorRegistration.//放行静态资源
                excludePathPatterns("/**/*.html")
                .excludePathPatterns("/**/*.js")
                .excludePathPatterns("/**/*.css")
                .excludePathPatterns("/**/*.woff")
                .excludePathPatterns("/**/*.ttf");
    }
}
