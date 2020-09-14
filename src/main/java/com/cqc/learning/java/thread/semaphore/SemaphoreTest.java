package com.cqc.learning.java.thread.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    private static Semaphore semaphore = new Semaphore(SemaphoreConstants.MAX_COUNT, true);

    public static void main(String[] args) {
        for (int i = 0; i < SemaphoreConstants.MAX_COUNT; i++) {
            try {
                semaphore.acquire(1);
                System.out.println("获取到了信号资源=" + i);
                System.out.println("Thread=" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }
}
