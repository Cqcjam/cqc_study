package com.cqc.learning.designmode.createmode.singlemode;

/**
 * 文件描述
 * 线程安全且性能不受影响
 **/
public class StaticInnerClassCreateSingle {

		private static class LazyHolder {
			private static final StaticInnerClassCreateSingle INSTANCE = new StaticInnerClassCreateSingle();
		}

		private StaticInnerClassCreateSingle() {
		}

		public static final StaticInnerClassCreateSingle getInstance() {
			return LazyHolder.INSTANCE;
		}

		public void getMethod(){
			System.out.println("hello static single");
		}
}