package com.cqc.learning.cache.redis;

import redis.clients.jedis.Jedis;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.cache.redis
 * @date 2020/8/14-9:38
 */
public class MainTestRedis {
    static int n = 500;

    /**
     * 仿秒杀
     */
    public static void secskill() {
        System.out.println(--n);
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            RedisDistributedLock lock = null;
            String unLockIdentify = null;
            try {
                Jedis conn = new Jedis("127.0.0.1",6379);
                conn.auth("123456");
                lock = new RedisDistributedLock(conn, "test1");
                //获取分布式锁
                unLockIdentify = lock.acquire();
                System.out.println(Thread.currentThread().getName() + "正在运行");
                secskill();
            } finally {
                if (lock != null) {
                    //释放锁
                    lock.release(unLockIdentify);
                }
            }
        };

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}
