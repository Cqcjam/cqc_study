package com.cqc.learning.designmode.createmode.builder;

/**
 * 文件描述
 **/
public class Client {

	public static void main(String[] args) {
		// 指挥者
		Direct direct = new Direct();
		Product product = direct.createProduct(new ConcreteBuilder2());
		product.show();
	}
}
