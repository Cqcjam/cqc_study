package com.cqc.learning.designmode.constructmode.proxy;

/**
 * 静态代理
 *
 * @ProductName: cqc
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.designmode.constructmode.proxy
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/11/28 8:56
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/11/28 8:56
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 cqc Technologies Inc. All Rights Reserved
 **/
public class StaticProxySubject implements AbstractSubject{

	AbstractSubject subject;

	public StaticProxySubject(AbstractSubject subject) {
		this.subject = subject;
	}

	@Override
	public void dealSubject() {
		/*if (subject == null) {
			subject = new ConcreteSubject();
		}*/
		preDeal();

		subject.dealSubject();

		afterDeal();
	}

	public void preDeal(){
		System.out.println("代理对象前置操作");
	}

	public void afterDeal(){
		System.out.println("代理后置操作");
	}
}
