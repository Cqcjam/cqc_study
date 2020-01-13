package com.cqc.learning.java.thread.countdown;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.concurrent.*;

/**
 * 文件描述
 *
 * @ProductName: Hundsun
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.java.thread.countdown
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/12/16 19:46
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/12/16 19:46
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class CountDown {

	private static final int MAX_COUNT = 4;
	private static final int CORE_THREAD = 2;
	private static final int MAX_THREAD = 3;
	private static final Long TIME_WAIT = 1L;
	private static String count;
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(MAX_COUNT);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(
			CORE_THREAD
			,MAX_THREAD
			,TIME_WAIT
			,TimeUnit.SECONDS
			,new LinkedBlockingQueue<>()
		);
		try {
			for (int i = 0; i < MAX_COUNT; i++) {
				Future<String> future = executor.submit(new SubThread(i));
				latch.countDown();
				System.out.println(future.get());
			}
			latch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Main Thread start");
			}
		}).start();

	}

	public static class SubThread implements Callable<String>{

		private Integer threadCount;

		private SubThread(Integer threadCount){
			this.threadCount = threadCount;
		}
		@Override
		public String call() throws Exception {
			String res = Thread.currentThread().getId() + "--" + threadCount;
			System.out.println(res);
			count = count + 1;
			return count;
		}
	}
}
