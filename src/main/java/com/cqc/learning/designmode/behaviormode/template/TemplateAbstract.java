package com.cqc.learning.designmode.behaviormode.template;

/**
 * 文件描述
 **/
public abstract class TemplateAbstract {

	//模板方法
	public void templateMethod() {
		eat();
		drink();
	}

	public abstract void eat();

	public abstract void drink();

}
