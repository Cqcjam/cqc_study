package com.cqc.learning.java.thread;

import java.util.concurrent.*;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.java.thread
 * @date 2020/7/15-11:09
 */
public class ThreadUtils {

    public static ThreadPoolExecutor createExecutors(Integer coreThread, Integer maxThread, Long aliveTime,
                                                     BlockingQueue<Runnable> queue) {
        return new ThreadPoolExecutor(coreThread, maxThread, aliveTime, TimeUnit.SECONDS, queue);
    }
}
