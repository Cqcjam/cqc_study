package com.cqc.learning.designmode.createmode.singlemode;

/**
 * 文件描述
 * 懒汉式本身是非线程安全的
 **/
public class LazySingleObject {

	private volatile static LazySingleObject instance;

	private LazySingleObject() {
	}

	//双重检测
	public static LazySingleObject getInstance() {
		if(instance == null) {
			synchronized (LazySingleObject.class) {
				if (instance == null) {
					instance = new LazySingleObject();
				}
			}
		}
		return instance;
	}

	public void getMethod(){
		System.out.println("hello lazy single");
	}
}
