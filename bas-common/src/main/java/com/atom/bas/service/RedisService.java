package com.atom.bas.service;

import java.util.Set;

/***
 * 缓存相关操作
 *
 */
public interface RedisService {


    /***
     * 获取相关Key类表
     * keys hello:*
     *
     * @param keyP key 表达式
     * @return
     */
    public Set<String> keys(String keyP);


    /***
     * 写入一个Key到Redis中
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, Object value);


    /***
     * 写入一个Key到Redis中并设置过期时间
     *
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    public boolean set(String key, Object value, Long expireTime);


    /***
     * 删除多个Key
     *
     * @param keys
     */
    public void removeByKeys(String... keys);


    /***
     * 删除Key
     * @param key
     */
    public boolean removeByKey(String key);


    /***
     * 判断一个Key是否存在
     *
     * @param key
     */
    public boolean hasKey(String key);

    /***
     * 获取一个Key-Value
     * @param codeForRedis
     * @return
     */
    Object get(String codeForRedis);

    /***
     * 返回一个Key剩余生命时间
     *
     * @param codeForRedis
     * @return
     */
    long expire(String codeForRedis);

    /***
     * 自增
     *
     * @param key
     */
    void incr(String key);



}
