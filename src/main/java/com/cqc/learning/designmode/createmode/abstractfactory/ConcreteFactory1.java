package com.cqc.learning.designmode.createmode.abstractfactory;

/**
 * 文件描述
 *
 **/
public class ConcreteFactory1 implements IFactory{
	@Override
	public IProduct createProduct() {
		ConcreteProduct1 product1 = new ConcreteProduct1();
		return product1;
	}
}
