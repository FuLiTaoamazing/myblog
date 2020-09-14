package com.flt.util;

import com.flt.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: RedisUtil
 * @description:
 * @author: fulitao
 * @create: 2020-09-11 16:12
 **/
@Component
public class RedisUtil {
    private RedisTemplate<String, Object> redisTemplate;

    public RedisUtil() {
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 设置有效时间
     *
     * @param key     Redis键
     * @param timeout 超时时间
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout) {

        return expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 设置有效时间
     *
     * @param key     Redis键
     * @param timeout 超时时间
     * @param unit    时间单位
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout, final TimeUnit unit) {

        Boolean ret = redisTemplate.expire(key, timeout, unit);
        return ret != null && ret;
    }

    public boolean hasKey(String key) {
        Boolean aBoolean = redisTemplate.hasKey(key);
        return aBoolean;
    }

    /**
     * 删除单个key
     *
     * @param key 键
     * @return true=删除成功；false=删除失败
     */
    public boolean del(final String key) {

        Boolean ret = redisTemplate.delete(key);
        return ret != null && ret;
    }

    /**
     * 删除多个key
     *
     * @param keys 键集合
     * @return 成功删除的个数
     */
    public long del(final Collection<String> keys) {

        Long ret = redisTemplate.delete(keys);
        return ret == null ? 0 : ret;
    }

    /**
     * 存入普通对象
     *
     * @param key   Redis键
     * @param value 值
     */
    public void set(final String key, final Object value) {

        redisTemplate.opsForValue().set(key, value, 1, TimeUnit.MINUTES);
    }

    // 存储普通对象操作

    /**
     * 存入普通对象
     *
     * @param key     键
     * @param value   值
     * @param timeout 有效期，单位秒
     */
    public void set(final String key, final Object value, final long timeout) {

        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    /**
     * 获取普通对象
     *
     * @param key 键
     * @return 对象
     */
    public Object get(final String key) {

        return redisTemplate.opsForValue().get(key);
    }

    /*
     * @Description:String类型进行加1操作
     * @Author: fulitao
     * @param key:
     * @param increm:
     * @return: void
     * @Date: 2020/9/14 上午8:56
     **/
    public void increment(final String key, Long increm) {
        redisTemplate.opsForValue().increment(key, increm);
    }

    // 存储Hash操作

    /**
     * 往Hash中存入数据
     *
     * @param key   Redis键
     * @param hKey  Hash键
     * @param value 值
     */
    public void hPut(final String key, final String hKey, final Object value) {

        redisTemplate.opsForHash().put(key, hKey, value);
    }

    /**
     * 往Hash中存入多个数据
     *
     * @param key    Redis键
     * @param values Hash键值对
     */
    public void hPutAll(final String key, final Map<String, Object> values) {

        redisTemplate.opsForHash().putAll(key, values);
    }

    /**
     * 获取Hash中的数据
     *
     * @param key  Redis键
     * @param hKey Hash键
     * @return Hash中的对象
     */
    public Object hGet(final String key, final String hKey) {

        return redisTemplate.opsForHash().get(key, hKey);
    }

    /**
     * 获取多个Hash中的数据
     *
     * @param key   Redis键
     * @param hKeys Hash键集合
     * @return Hash对象集合
     */
    public List<Object> hMultiGet(final String key, final Collection<Object> hKeys) {

        return redisTemplate.opsForHash().multiGet(key, hKeys);
    }

    // 存储Set相关操作

    /**
     * 往Set中存入数据
     *
     * @param key    Redis键
     * @param values 值
     * @return 存入的个数
     */
    public long sSet(final String key, final Object... values) {
        Long count = redisTemplate.opsForSet().add(key, values);
        return count == null ? 0 : count;
    }

    /**
     * 删除Set中的数据
     *
     * @param key    Redis键
     * @param values 值
     * @return 移除的个数
     */
    public long sDel(final String key, final Object... values) {
        Long count = redisTemplate.opsForSet().remove(key, values);
        return count == null ? 0 : count;
    }

    public Set<Object> sGet(String key) {
        Set<Object> members = redisTemplate.opsForSet().members(key);
        return members;
    }

    // 存储List相关操作

    /**
     * 往List中存入数据
     *
     * @param key   Redis键
     * @param value 数据
     * @return 存入的个数
     */
    public long lPush(final String key, final Object value) {
        Long count = redisTemplate.opsForList().rightPush(key, value);
        return count == null ? 0 : count;
    }

    /**
     * 往List中存入多个数据
     *
     * @param key    Redis键
     * @param values 多个数据
     * @return 存入的个数
     */
    public long lPushAll(final String key, final Collection<Object> values) {
        Long count = redisTemplate.opsForList().rightPushAll(key, values);
        return count == null ? 0 : count;
    }

    /**
     * 往List中存入多个数据
     *
     * @param key    Redis键
     * @param values 多个数据
     * @return 存入的个数
     */
    public long lPushAll(final String key, final Object... values) {
        Long count = redisTemplate.opsForList().rightPushAll(key, values);
        return count == null ? 0 : count;
    }

    /**
     * 从List中获取begin到end之间的元素
     *
     * @param key   Redis键
     * @param start 开始位置
     * @param end   结束位置（start=0，end=-1表示获取全部元素）
     * @return List对象
     */
    public List<Object> lGet(final String key, final int start, final int end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /*
     * @Description:往sort_set中存入耽搁数据
     * @Author: fulitao
     * @param key: sort_set的key
     * @param score: 排列值
     * @param member: 所存入的内容
     * @return: boolean
     * @Date: 2020/9/11 下午4:18
     **/
    public boolean zSet(final String key, final Integer score, Object member) {
        Boolean flag = redisTemplate.opsForZSet().add(key, member, score);
        return flag;
    }

    /*
     * @Description:
     * @Author: fulitao
     * @param key: sort_set的key
     * @param members: 多个value(key对象,value分数)
     * @return: boolean
     * @Date: 2020/9/11 下午4:30
     **/
    public boolean zSet(final String key, final Map<Object, Double> objects) {
        Set<Object> keys = objects.keySet();
        Set<ZSetOperations.TypedTuple<Object>> members = new HashSet<>();
        DefaultTypedTuple defaultTypedTuple = null;
        for (Object o : keys) {
            defaultTypedTuple = new DefaultTypedTuple(o, objects.get(o));
            members.add(defaultTypedTuple);
        }
        Long count = redisTemplate.opsForZSet().add(key, members);
        return count < members.size();
    }
    /*
     * @Description:获取sort_set中的所有值
     * @Author: fulitao
     * @param kry: sort_set的key
     * @return: object:所有的知
     * @Date: 2020/9/11 下午4:34
     **/

    public Set<Object> zGetAll(final String key) {
        Set<Object> objects = zRange(key, 0L, -1L);
        return objects;
    }

    /*
     * @Description:指定索引中的value
     * @Author: fulitao
     * @param key: sort_set的key
     * @param start: 开始索引
     * @param end: 结束索引
     * @return: java.lang.Object：满足的值
     * @Date: 2020/9/11 下午4:36
     **/
    public Set<Object> zRange(final String key, final Long start, final Long end) {
        Set<Object> objects = redisTemplate.opsForZSet().range(key, start, end);
        return objects;
    }


    public boolean zDele(final String key, final Object... values) {
        Long count = redisTemplate.opsForZSet().remove(key, values);

        return count < values.length;
    }

    public void zIncrement(final String key, final Long increment, final Object member) {
        Double score = redisTemplate.opsForZSet().incrementScore(key, member, increment);
    }
}