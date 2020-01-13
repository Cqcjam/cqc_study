package com.cqc.learning.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorServiceTest test = new ExecutorServiceTest();
        /*ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(test.new SubThread());
        executor.shutdown();*/

        /*ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            Future<String> submit  = pool.submit(test.new CallTest("ThreadName=" + i));
            list.add(submit);
        }
        for(Future<String> future  : list) {
            System.out.println(future.get());
        }
        pool.shutdown();*/

        ThreadPoolExecutor pool = new ThreadPoolExecutor(10,20,10,
                                                             TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(200),
                                                             new ThreadPoolExecutor.AbortPolicy());
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 10000 ; i++) {
            Future<String> submit  = pool.submit(test.new CallTest("ThreadName=" + i));
            list.add(submit);
        }
        for(Future<String> future  : list) {
            System.out.println(future.get());
        }
        pool.shutdown();

    }

    class CallTest implements Callable<String>{
        private String name;
        private CallTest(String threadName) {
            name = threadName;
        }
        @Override
        public String call() {
            return name;
        }
    }



    class SubThread implements Runnable{
        @Override
        public void run() {
            System.out.println("sub_thread run");
        }
    }
}
