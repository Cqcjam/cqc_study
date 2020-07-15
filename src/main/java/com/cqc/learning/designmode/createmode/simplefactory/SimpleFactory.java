package com.cqc.learning.designmode.createmode.simplefactory;


/**
 * 文件描述
 *
 * Copyright © 2019 cqc Technologies Inc. All Rights Reserved
 **/
public class SimpleFactory {

	ISimpleProduct product = null;

	public ISimpleProduct createProduct(String type){

		if (type.equals("1")) {
			product = new ConcreteProduct1();
		} else if (type.equals("2")) {
			product = new ConcreteProduct2();
		}
		return product;
	}
}
