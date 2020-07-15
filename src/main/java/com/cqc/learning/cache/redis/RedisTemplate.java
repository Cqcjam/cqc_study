package com.cqc.learning.cache.redis;

import com.google.common.base.Strings;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

/**
 * Redis Template
 */
public class RedisTemplate {
    JedisPool jedisPool;
    String host;
    int port;
    String password;
    String namespace;

    /**
     * 构造方法
     *
     * @param host      HOST
     * @param port      PORT
     * @param password  PASSWORD
     * @param namespace 命名空间
     */
    public RedisTemplate(String host, int port, String password, String namespace) {
        this.host = Strings.nullToEmpty(host).trim();
        this.port = port;
        this.password = Strings.emptyToNull(Strings.nullToEmpty(password).trim());
        this.namespace = Strings.nullToEmpty(namespace).trim();
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxIdle(10);
        config.setMaxTotal(100);
        config.setMaxWaitMillis(1000 * 10);
        config.setMinIdle(1);
        config.setTestOnBorrow(false);
        config.setTestOnCreate(false);
        config.setTestOnReturn(false);
        config.setTestWhileIdle(true);
        config.setTimeBetweenEvictionRunsMillis(1000 * 60);
        jedisPool = new JedisPool(config, host, port, 1000 * 16, password);
    }

    /**
     * 执行方法
     *
     * @param callback CALLBACK
     * @return RET
     */
    public <T> T exec(Callback<T> callback) {
        if (callback == null) {
            return null;
        }
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return callback.apply(jedis, namespace);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 执行方法
     *
     * @param callback CALLBACK
     * @return RET
     */
    public <T> T exec(TransactionCallable<T> callback) {
        if (callback == null) {
            return null;
        }
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Transaction transaction = null;
            try {
                transaction = jedis.multi();
                T val = callback.apply(transaction, namespace);
                transaction.exec();
                return val;
            } finally {
                if (transaction != null) {
                    transaction.close();
                }
            }
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 非事务类型调用
     */
    public interface Callback<T> {
        /**
         * 给定jedis客户端和一个命名空间
         *
         * @param jedis     JEDIS
         * @param namespace 命名空间
         * @return RET
         */
        T apply(Jedis jedis, String namespace);
    }

    /**
     * 事务类型调用
     */
    public interface TransactionCallable<T> {
        /**
         * 给定jedis客户端和一个命名空间
         *
         * @param transaction JEDIS_TRANSACTION
         * @param namespace   命名空间
         * @return RET
         */
        T apply(Transaction transaction, String namespace);
    }
}
