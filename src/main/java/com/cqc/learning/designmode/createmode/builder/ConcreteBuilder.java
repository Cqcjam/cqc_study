package com.cqc.learning.designmode.createmode.builder;

/**
 * 文件描述
 *
 **/
public class ConcreteBuilder implements IBuilder{

	private  Product product;

	public ConcreteBuilder() {
		product = new Product();
	}

	@Override
	public void buildPartA() {
		product.setPartA("建造A");
	}

	@Override
	public void buildPartB() {
		product.setPartB("建造B");
	}

	@Override
	public Product buildProduct() {
		return product;
	}

}
