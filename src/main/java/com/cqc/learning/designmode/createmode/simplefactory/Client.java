package com.cqc.learning.designmode.createmode.simplefactory;

/**
 * 文件描述
 * 简单工厂模式：设定一个工厂类
 * 抽象接口产品，及对应具体产品
 * 根据不同类型通过工厂生成具体的产品
 **/
public class Client {

	public static void main(String[] args) {
		ISimpleProduct product = new SimpleFactory().createProduct("1");
		product.product();
	}
}
