package com.cqc.learning.designmode.createmode.builder;

/**
 * 文件描述
 * 指挥者
 **/
public class Direct {

	public Product createProduct(IBuilder iBuilder){
		iBuilder.buildPartA();
		iBuilder.buildPartB();
		return iBuilder.buildProduct();
	}
}
