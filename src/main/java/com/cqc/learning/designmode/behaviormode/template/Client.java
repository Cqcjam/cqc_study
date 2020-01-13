package com.cqc.learning.designmode.behaviormode.template;

/**
 * 文件描述
 * 模板模式
 **/
public class Client {

	public static void main(String[] args) {
		TemplateAbstract template = People.getInstance();
		template.templateMethod();
	}

}
