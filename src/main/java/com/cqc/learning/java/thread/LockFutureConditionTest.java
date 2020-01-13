package com.cqc.learning.java.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockFutureConditionTest {

    public static void main(String[] args) {
        // 公平锁
        ReentrantLock lock = new ReentrantLock(true);
        Condition condition = lock.newCondition();
        try {
            condition.await();
        } catch (Exception e) {

        }
    }

}
