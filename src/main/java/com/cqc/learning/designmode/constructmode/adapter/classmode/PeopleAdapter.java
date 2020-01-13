package com.cqc.learning.designmode.constructmode.adapter.classmode;


import com.cqc.learning.designmode.constructmode.adapter.objectmode.ITarget;
import com.cqc.learning.designmode.constructmode.adapter.objectmode.PeopleAdaptee;

/**
 * 文件描述
 * 对象适配器
 **/

public class PeopleAdapter extends PeopleAdaptee implements ITarget {

	/**
	 * 适配器给Adaptee增加能够使用喝的功能
	 */
	@Override
	public void drink() {
		eat();
		System.out.println("people有喝的功能了");
	}
}
