package com.cqc.learning.designmode.createmode.builder;

/**
 * 文件描述
 *
 **/
public class ConcreteBuilder2 implements IBuilder{

	private Product product;

	public ConcreteBuilder2() {
		this.product = new Product();
	}

	@Override
	public void buildPartA() {
		product.setPartA("建造C");
	}

	@Override
	public void buildPartB() {
		product.setPartB("建造D");
	}

	@Override
	public Product buildProduct() {
		return product;
	}
}
