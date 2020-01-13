package com.cqc.learning.designmode.createmode.abstractfactory;

/**
 * 文件描述
 * 抽象工厂模式：设定一个统一的抽象接口工厂，及对应生成具体产品的接口工厂
 * 抽象接口产品，及对应具体产品
 * 通过抽象接口工厂生成具体的产品工厂，然后在生成产品
 **/
public class Client {

	public static void main(String[] args) {
		IFactory factory = new ConcreteFactory1();
		IProduct product = factory.createProduct();
		product.product();
	}
}
