package com.flt.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:Druid配置类
 * path: myblog-com.flt.config-DriuidConfig
 * date: 2020/7/31 8:37
 */
@Configuration
public class DruidConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //配置 Druid的后台监控页面
    //因为没有 web.xml文件使用 javaConfig来注入到Spring容器中
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> parameter = new HashMap<>();
        //配置登录账号和密码
        parameter.put("loginUsername", "admin");
        parameter.put("loginPassword", "heavenly4u");

        //后台允许谁能访问   表示只有本地服务器能访问
//        parameter.put("allow", "");
        parameter.put("resetEnable","false" );
        bean.setInitParameters(parameter);
        return bean;
    }
    //注册自定义过滤器
    public FilterRegistrationBean webStat(){
        FilterRegistrationBean bean=new FilterRegistrationBean(new WebStatFilter());
        Map<String, String> initPara = new HashMap<>();
        //添加过滤规则
        bean.addUrlPatterns("/");

        initPara.put("exclusion","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*" );
        bean.setInitParameters(initPara);
        return bean;
    }


}
