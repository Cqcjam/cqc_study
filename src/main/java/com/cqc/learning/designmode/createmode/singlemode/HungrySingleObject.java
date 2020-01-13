package com.cqc.learning.designmode.createmode.singlemode;

/**
 * 文件描述
 * 饿汉式: 天生线程安全，因为每次调用饿汉生成对象，都会提前生成
 * 不用考虑多线程安全问题
 **/
public class HungrySingleObject {

	private static HungrySingleObject instance = new HungrySingleObject();

	private HungrySingleObject(){}

	public static HungrySingleObject getInstance() {

		return instance;
	}

	public void getMethod(){
		System.out.println("hello hungry single");
	}

}
