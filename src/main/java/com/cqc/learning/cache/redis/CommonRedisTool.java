package com.cqc.learning.cache.redis;

import com.google.common.base.Joiner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 */
public class CommonRedisTool {
    private RedisTemplate template;

    public CommonRedisTool(RedisTemplate template) {
        super();
        this.template = template;
    }

    /**
     * 哈希getAll
     */
    public List<String> hGetAll(final String key) {
        return template.exec(new RedisTemplate.Callback<List<String>>() {

            @Override
            public List<String> apply(Jedis jedis, String namespace) {
                byte[] keyByte = toUTF8(Joiner.on(":").join(new String[] {namespace, key}));
                List<String> list = new LinkedList<String>();
                Map<byte[], byte[]> map = jedis.hgetAll(keyByte);
                if (map != null) {
                    for (byte[] b : map.keySet()) {
                        list.add(new String(map.get(b)));
                    }
                }
                return list;
            }
        });
    }

    /**
     * 哈希getAll
     */
    public Map<String, String> hGetAllMap(final String key) {
        return template.exec(new RedisTemplate.Callback<Map<String, String>>() {

            @Override
            public Map<String, String> apply(Jedis jedis, String namespace) {
                byte[] keyByte = toUTF8(Joiner.on(":").join(new String[] {namespace, key}));
                Map<byte[], byte[]> map = jedis.hgetAll(keyByte);
                Map<String, String> stringMap = new HashMap<String, String>();
                if (map != null) {
                    for (Entry<byte[], byte[]> entry : map.entrySet()) {
                        stringMap.put(new String(entry.getKey()), new String(entry.getValue()));
                    }
                }
                return stringMap;
            }
        });
    }

    /**
     * 哈希get
     */
    public String hGet(final String key, final String feild) {
        return template.exec(new RedisTemplate.Callback<String>() {

            @Override
            public String apply(Jedis jedis, String namespace) {
                byte[] keyByte = toUTF8(Joiner.on(":").join(new String[] {namespace, key}));
                byte[] feildByte = toUTF8(feild);
                byte[] b = jedis.hget(keyByte, feildByte);
                if (b == null || b.length == 0) {
                    return null;
                }
                try {
                    return new String(b, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
    }

    /**
     * get
     */
    public String get(final String key) {
        return template.exec(new RedisTemplate.Callback<String>() {

            @Override
            public String apply(Jedis jedis, String namespace) {
                byte[] keyByte = toUTF8(Joiner.on(":").join(new String[] {namespace, key}));
                byte[] b = jedis.get(keyByte);
                if (b == null || b.length == 0) {
                    return null;
                }
                return new String(b);
            }
        });
    }

    /**
     * set
     */
    public void set(final String key, final String value) throws Exception{
        template.exec(new RedisTemplate.TransactionCallable<Void>() {

            @Override
            public Void apply(Transaction transaction, String namespace) {
                byte[] keyByte = toUTF8(Joiner.on(":").join(new String[] {namespace, key}));
                byte[] valueByte = toUTF8(value);
                transaction.set(keyByte, valueByte);
                return null;
            }
        });
    }



    /**
     * 哈希set
     */
    public void hSet(final String key, final String feild, final String value,
        final Integer expireTime) throws Exception{
        template.exec(new RedisTemplate.TransactionCallable<Void>() {

            @Override
            public Void apply(Transaction transaction, String namespace) {
                byte[] keyByte = toUTF8(Joiner.on(":").join(new String[] {namespace, key}));
                byte[] valueByte = toUTF8(value);
                byte[] feildByte = toUTF8(feild);
                transaction.hset(keyByte, feildByte, valueByte);
                if (expireTime != null) {
                    transaction.expire(keyByte, expireTime);
                }
                return null;
            }
        });
    }

    /**
     * 哈希增长指定字段
     */
    public void hIncr(final String key, final String feild, final long value) throws Exception{
        template.exec(new RedisTemplate.TransactionCallable<Void>() {

            @Override
            public Void apply(Transaction transaction, String namespace) {
                byte[] keyByte = toUTF8(Joiner.on(":").join(new String[] {namespace, key}));
                byte[] feildByte = toUTF8(feild);
                transaction.hincrBy(keyByte, feildByte, value);
                return null;
            }
        });
    }

    /**
     * 哈希删除某字段
     */
    public void hDeleteFeild(final String key, final String feild) throws Exception{
        template.exec(new RedisTemplate.TransactionCallable<Void>() {

            @Override
            public Void apply(Transaction transaction, String namespace) {
                byte[] keyByte = toUTF8(Joiner.on(":").join(new String[] {namespace, key}));
                byte[] feildByte = toUTF8(feild);
                transaction.hdel(keyByte, feildByte);
                return null;
            }
        });
    }

    /**
     * 删除
     */
    public void delete(final String key) throws Exception{
        template.exec(new RedisTemplate.TransactionCallable<Void>() {

            @Override
            public Void apply(Transaction transaction, String namespace) {
                byte[] keyByte = toUTF8(Joiner.on(":").join(new String[] {namespace, key}));
                transaction.del(keyByte);
                return null;
            }
        });

    }


    public void expire(final String key, final Integer expireTime) throws Exception{
        template.exec(new RedisTemplate.TransactionCallable<Void>() {

            @Override
            public Void apply(Transaction transaction, String namespace) {
                byte[] keyByte = toUTF8(Joiner.on(":").join(new String[] {namespace, key}));
                transaction.expire(keyByte, expireTime);
                return null;
            }
        });

    }

    /**
     * 转换为UTF-8格式
     *
     * @param val VAL
     */
    byte[] toUTF8(String val) {
        if (val != null) {
            return val.getBytes(Charset.forName("UTF-8"));
        } else {
            return null;
        }
    }
}
