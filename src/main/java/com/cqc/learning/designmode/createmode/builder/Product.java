package com.cqc.learning.designmode.createmode.builder;

/**
 * 文件描述
 **/
public class Product {

	private String partA;

	private String partB;

	public String getPartA() {
		return partA;
	}

	public void setPartA(String partA) {
		this.partA = partA;
	}

	public String getPartB() {
		return partB;
	}

	public void setPartB(String partB) {
		this.partB = partB;
	}

	public void show() {
		System.out.println(this.getPartA() +
				this.getPartB());
	}
}
