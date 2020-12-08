package com.cqc.learning.java.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author caoqingcong
 * @projectName cqc_study
 * @packageName com.cqc.learning.java.thread
 * @date 2020/7/15-12:06
 */
public class Main {


    public static void main(String[] args) {
        ThreadPoolExecutor executor = ThreadPoolUtils.createExecutors(1, 2, 3L, new LinkedBlockingQueue<>(1));
        executor.execute(new Test());
    }

    static class Test implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello");
        }
    }
}
