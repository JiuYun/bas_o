package com.atom.user.service.impl;

import com.atom.user.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Set;

@Service("redisServiceImpl")
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Set<String> keys(String keyP) {
        return redisTemplate.keys(keyP);
    }

    @Override
    public boolean set(String key, Object value) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set(key,value);
        return true;
    }

    @Override
    public boolean set(String key, Object value, Long expireTime) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set(key,value,expireTime);
        return true;
    }

    @Override
    public void removeByKeys(String... keys) {
        redisTemplate.delete(keys);
    }

    @Override
    public boolean removeByKey(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public Object get(String codeForRedis) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        return operations.get(codeForRedis);
    }

    @Override
    public long expire(String codeForRedis) {
        return 0;
    }

    @Override
    public void incr(String key) {

    }
}
