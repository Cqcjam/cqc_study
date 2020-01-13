package com.cqc.learning.java.thread.CyclicBarrier;

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
public class CyclicBarrierTest {

	private static final int MAX_COUNT = 4;
	private static final int CORE_THREAD = 4;
	private static final int MAX_THREAD = 8;
	private static final Long TIME_WAIT = 8L;
	private static String count;
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(MAX_COUNT);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(
			CORE_THREAD
			,MAX_THREAD
			,TIME_WAIT
			,TimeUnit.SECONDS
			,new LinkedBlockingQueue<>()
			,Executors.defaultThreadFactory()
		);
		try {
			for (int i = 0; i < MAX_COUNT; i++) {
				executor.execute(new SubThread(barrier, i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		new Thread(() -> System.out.println("Hello World Main Thread")).start();

	}

	public static class SubThread implements Runnable{

		private Integer threadCount;

		private CyclicBarrier barrier;

		private SubThread( CyclicBarrier barrier, Integer threadCount){
			this.threadCount = threadCount;
			this.barrier = barrier;
		}
		@Override
		public void run() {
			try {
				barrier.await(10, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			}
			String res = Thread.currentThread().getId() + "--" + threadCount;
			System.out.println(res);
		}
	}
}
