package com.cqc.learning.designmode.createmode.abstractfactory;

/**
 * 文件描述
 *
 **/
public class ConcreteFactory2 implements IFactory{
	@Override
	public IProduct createProduct() {
		ConcreteProduct2 product2 = new ConcreteProduct2();
		return product2;
	}
}
