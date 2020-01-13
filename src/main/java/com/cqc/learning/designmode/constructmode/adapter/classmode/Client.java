package com.cqc.learning.designmode.constructmode.adapter.classmode;

import com.cqc.learning.designmode.constructmode.adapter.objectmode.ITarget;

/**
 * 文件描述
 * 类适配
 **/
public class Client {

	public static void main(String[] args) {
		ITarget iTarget = new PeopleAdapter();
		iTarget.drink();
	}
}
