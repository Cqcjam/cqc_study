package com.cqc.learning.designmode.createmode.prototype;

import lombok.extern.slf4j.Slf4j;

/**
 * 文件描述
 * 原型模式 主要是为了克隆新的对象出来 浅拷贝,
 * 		   只复制指向某个对象的指针，而不复制对象本身，新旧对象共享一块内存,新对象变更,原对象数据也会相应的改变
 * 深拷贝: 是全量拷贝,复制并创建一个一摸一样的对象，不共享内存
 * 			修改新对象，旧对象保持不变。
 **/
@Slf4j
public class Client {

	public static void main(String[] args) throws CloneNotSupportedException {

		ProtoTypeClass protoTypeClass = new ProtoTypeClass();
		//浅拷贝
		ProtoTypeClass protoTypeClass1 = protoTypeClass.clone();
		protoTypeClass1.testMethod("world");
		log.info("prototype=" + (protoTypeClass.equals(protoTypeClass1)));
	}
}
