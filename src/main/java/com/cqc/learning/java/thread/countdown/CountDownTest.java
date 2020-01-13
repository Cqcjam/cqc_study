package com.cqc.learning.java.thread.countdown;

import java.util.concurrent.CountDownLatch;

public class CountDownTest {

    private static final int THREAD_NUM = 5;

    public static void main(String[] args) {
        CountDownTest test = new CountDownTest();
        CountDownLatch count = new CountDownLatch(THREAD_NUM);
        try {
            System.out.println("等待子线程执行");
            for (int i=0;i<THREAD_NUM;i++) {
                System.out.println("开始执行ThreadName=" + Thread.currentThread().getName() + "--i=" + i );
                test.new SubThread(count).start();
            }
            System.out.println("所有子线程执行完成");
            count.await();
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("开始执行主线程");
        System.out.println("主线程执行完成");

    }

    class SubThread extends Thread {
        CountDownLatch count;
        private SubThread(CountDownLatch thisCount) {
            count = thisCount;
        }
        @Override
        public void run() {
            System.out.println("thread---" + Thread.currentThread().getName());
            count.countDown();
        }
    }
}
