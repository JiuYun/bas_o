package com.atom.bas.service.impl;

import com.atom.bas.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
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
        operations.set(key,value);
        redisTemplate.expire(key, expireTime,TimeUnit.SECONDS);
        return true;
    }

    @Override
    public void removeByKeys(String... keys) {
        redisTemplate.delete(keys);
    }

    @Override
    public boolean removeByKey(String key) {
        redisTemplate.delete(key);
        return true;
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
        return redisTemplate.getExpire(codeForRedis);
    }

    @Override
    public long incr(String key) {
        return redisTemplate.opsForValue().increment(key,1);
    }
}
