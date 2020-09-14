package com.flt.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

/**
 * @ClassName: RedisConfig
 * @description:
 * @author: fulitao
 * @create: 2020-09-11 16:01
 **/
@Configuration
public class RedisConfig {


    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<String, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        //创建Jackson序列化
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        //配置ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        //设置可见性
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //设置默认类型
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        //获取String类型的序列化规则
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //设置Redis String数据类型的key默认序列化
        template.setKeySerializer(stringRedisSerializer);
        //设置Redis Hash数据类型的Key为String序列化
        template.setHashKeySerializer(RedisSerializer.string());
        //设置Redis String数据类型的value为Jackson序列化
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //设置Redis Hash数据类型的value未Jack序列化
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        //在数据设置之后
        template.afterPropertiesSet();
        return template;
    }



}
