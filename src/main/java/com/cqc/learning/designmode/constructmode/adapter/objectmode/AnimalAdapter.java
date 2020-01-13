package com.cqc.learning.designmode.constructmode.adapter.objectmode;


/**
 * 文件描述
 * 对象适配器
 **/

public class AnimalAdapter extends PeopleAdaptee implements ITarget {

	private AnimalAdaptee adaptee;

	public AnimalAdapter(AnimalAdaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

	/**
	 * 适配器给Adaptee增加能够使用喝的功能
	 */
	@Override
	public void drink() {
		adaptee.eat();
		System.out.println("Animal有喝的功能了");
	}
}
