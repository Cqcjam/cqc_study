package com.cqc.learning.cache.redis;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.cache.redis
 * @date 2020/8/14-9:32
 */
public interface DistributeLock {

    /**
     * 获取锁
     * @return 锁标识
     */
    String acquire();

    /**
     * 释放锁(获取锁的时候对应的标识,确保释放的是当前客户端获取到的锁)
     */
    boolean release(String identifier);
}
