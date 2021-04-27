package com.cqc.learning.designmode.createmode.singlemode;

/**
 * 文件描述
 * Singleton通过将构造方法限定为private避免了类在外部被实例化，
 * 在同一个虚拟机范围内，Singleton的唯一实例只能通过getInstance()方法访问。
 *
 * @author caoqingcong*/
public class Client {

    public static void main(String[] args) {
		//饿汉式
        HungrySingleObject instance = HungrySingleObject.getInstance();
        HungrySingleObject instance3 = HungrySingleObject.getInstance();
		instance.getMethod();
        //懒汉式
		LazySingleObject lazySingleObject = LazySingleObject.getInstance();
        lazySingleObject.getMethod();
		//静态内部类
		StaticInnerClassCreateSingle instance1 = StaticInnerClassCreateSingle.getInstance();
        StaticInnerClassCreateSingle instance2 = StaticInnerClassCreateSingle.getInstance();
		instance1.getMethod();
		if (instance == instance3) {
            System.out.println("YES");
        }


    }
}


