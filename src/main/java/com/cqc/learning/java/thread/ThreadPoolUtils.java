package com.cqc.learning.java.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.java.thread
 * @date 2020/7/15-11:09
 */
public class ThreadPoolUtils {

    /** 工具类，构造方法私有化 */
    private ThreadPoolUtils() {super();};

    // 线程池核心线程数
    private final static Integer COREPOOLSIZE = 3;
    // 最大线程数
    private final static Integer MAXIMUMPOOLSIZE = 10;
    // 空闲线程存活时间
    private final static Integer KEEPALIVETIME = 3 * 60;
    /**
     * 线程等待队列
     */
    private static BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);


    protected static ThreadPoolExecutor createExecutors(Integer coreThread, Integer maxThread, Long aliveTime,
                                                     BlockingQueue<Runnable> queue) {
        return new ThreadPoolExecutor(coreThread, maxThread, aliveTime, TimeUnit.SECONDS, queue,
                new ThreadFactoryBuilder().setNameFormat("threadPool-1").build(),
                new ThreadPoolExecutor.AbortPolicy());
    }
}
