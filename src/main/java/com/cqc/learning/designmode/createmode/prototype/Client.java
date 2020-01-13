package com.cqc.learning.designmode.createmode.prototype;

/**
 * 文件描述
 * 原型模式 主要是为了克隆新的对象出来 浅拷贝
 **/
public class Client {

	public static void main(String[] args) throws CloneNotSupportedException {

		ProtoTypeClass protoTypeClass = new ProtoTypeClass();
		//浅拷贝
		ProtoTypeClass protoTypeClass1 = (ProtoTypeClass)protoTypeClass.clone();
		System.out.println("prototype=" + (protoTypeClass.equals(protoTypeClass1) ? true : false));
	}

}
