package com.lujiahao.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HyperLogLogOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

/**
 * @author lujiahao
 * @date 2018-09-07 下午3:22
 */
@Service
public class RedisService {

//    @Resource
//    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    public void set(String key, Object value) {
        //更改在redis里面查看key编码问题
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);
    }

    public Object get(String key) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }

    public boolean pfadd(String key, Object... value) {
        HyperLogLogOperations<String, Object> vo = redisTemplate.opsForHyperLogLog();
        Long add = vo.add(key, value);
        if (add < 1) {
            return false;
        }
        return true;
    }

    public long pfcount(String key) {
        HyperLogLogOperations<String, Object> vo = redisTemplate.opsForHyperLogLog();
        return vo.size(key);
    }
}
