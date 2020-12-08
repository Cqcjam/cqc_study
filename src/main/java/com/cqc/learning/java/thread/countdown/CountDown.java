package com.cqc.learning.java.thread.countdown;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 文件描述
 *
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
 **/
public class CountDown {

	private static final int MAX_COUNT = 4;
	private static final int CORE_THREAD = 2;
	private static final int MAX_THREAD = 3;
	private static final Long TIME_WAIT = 1L;
	private static String count;
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(MAX_COUNT);
		ExecutorService executor = new ThreadPoolExecutor(
			CORE_THREAD
			,MAX_THREAD
			,TIME_WAIT
			,TimeUnit.SECONDS
			,new LinkedBlockingQueue<>(1024), new ThreadFactoryBuilder().setNameFormat("factory1").build()
		);
		try {
			for (int i = 0; i < MAX_COUNT; i++) {
				Future<String> future = executor.submit(new SubThread(i, latch));
				latch.countDown();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static class SubThread implements Callable<String>{

		private Integer threadCount;

		private CountDownLatch latch;

		private SubThread(Integer threadCount, CountDownLatch latch){
			this.threadCount = threadCount;
			this.latch = latch;
		}
		@Override
		public String call() throws Exception {
			String resTemp =Thread.currentThread().getName() + "--" + threadCount;
			latch.await();
			String res = Thread.currentThread().getName() + "--" + threadCount;
			System.out.println(res);
			count = count + 1;
			return count;
		}
	}
}
