package com.cqc.learning.designmode.createmode.singlemode;

/**
 * 文件描述
 * Singleton通过将构造方法限定为private避免了类在外部被实例化，
 * 在同一个虚拟机范围内，Singleton的唯一实例只能通过getInstance()方法访问。
 **/
public class Client {

	public static void main(String[] args) {
		HungrySingleObject instance = HungrySingleObject.getInstance();
		instance.getMethod();

		StaticInnerClassCreateSingle instance1 = StaticInnerClassCreateSingle.getInstance();
		instance1.getMethod();

		LazySingleObject lazySingleObject = LazySingleObject.getInstance();
		lazySingleObject.getMethod();
	}

}
