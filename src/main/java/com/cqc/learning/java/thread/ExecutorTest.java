package com.cqc.learning.java.thread;

import java.lang.annotation.Annotation;
import java.util.concurrent.*;

/**
 * 文件描述
 *
 * @ProductName: Hundsun
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.java.thread
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/12/10 17:49
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/12/10 17:49
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class ExecutorTest {

	   // 等价
       ExecutorService executor1 = Executors.newFixedThreadPool(10);
       ThreadPoolExecutor executor2 = new ThreadPoolExecutor(
                10, 10, 0L, TimeUnit.MILLISECONDS
                ,new LinkedBlockingQueue<>()
		        ,Executors.defaultThreadFactory()
                ,new ThreadPoolExecutor.AbortPolicy());

        /*ExecutorService executor = Executors.newSingleThreadExecutor();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1, 1, 10000L, TimeUnit.MILLISECONDS
                ,new LinkedBlockingQueue<>()
                ,new ThreadPoolExecutor.DiscardOldestPolicy());*/

        /*ExecutorService executor = Executors.newCachedThreadPool();
        ThreadPoolExecutor executor = new new ThreadPoolExecutor(0,
                                        Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());*/

	public static void main(String[] args) {
		Annotation[] annotations = ThreadFactory.class.getAnnotations();
		ExecutorService executorService = Executors.newScheduledThreadPool(1);

	}
}
