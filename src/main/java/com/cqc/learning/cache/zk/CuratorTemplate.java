package com.cqc.learning.cache.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicLong;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Curator Template
 */
public class CuratorTemplate {
    private static final Logger logger = LoggerFactory.getLogger(CuratorTemplate.class);
    private static final String LEADER_PATCH = "/leader";
    private static final String LOCK_PATCH = "/lock";
    private static final String ATOMIC_PATCH = "/atomic";
    private static final String ATOMIC_DEFAULT_ID = "DEFAULT_ID";
    private CuratorFramework client;
    private volatile boolean isLeader = false;

    /**
     * 构造函数
     *
     * @param zk ZK 地址
     */
    public CuratorTemplate(String zk) {
        client = CuratorFrameworkFactory.newClient(
                zk, new ExponentialBackoffRetry(1000 * 10, 1000));
        // 初始化client
        client.start();
    }

    /**
     * 选主功能
     *
     * @param bizId 业务ID
     */
    public void leader(String bizId, LeaderLatchListener leaderLatchListener) {
        // 初始化leader
        LeaderLatch leaderLatch = new LeaderLatch(client, LEADER_PATCH + "/" + bizId);
        leaderLatch.addListener(leaderLatchListener);
        try {
            leaderLatch.start();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 创建一个分布式可重入锁
     *
     * @param bizId 业务ID
     * @return 锁
     */
    public InterProcessMutex createInterProcessMutex(String bizId) {
        return new InterProcessMutex(client, LOCK_PATCH + "/" + bizId);
    }

    /**
     * 获取下一个Id数值，如果获取失败，则抛出RuntimeException异常
     *
     * @param bizId      业务ID
     * @param initialize 初始化数值
     * @return 分布式计数
     */
    private Long nextId(String bizId, long initialize) {
        try {
            DistributedAtomicLong distributedAtomicLong = new DistributedAtomicLong(client, ATOMIC_PATCH + "/" + bizId, new RetryNTimes(1000, 1000));
            //  默认起始都是0L
            distributedAtomicLong.initialize(initialize);
            AtomicValue<Long> val = distributedAtomicLong.increment();
            if (val.succeeded()) {
                return val.postValue();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        throw new RuntimeException(String.format("%s GENERATE FAIL", bizId));
    }

    /**
     * 获取下一个Id数值，如果获取失败，则返回null
     *
     * @return 分布式计数
     */
    public Long nextId() {
        return nextId(ATOMIC_DEFAULT_ID, 1000L);
    }
}
