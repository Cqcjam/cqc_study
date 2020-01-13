package com.cqc.learning.designmode.constructmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 文件描述
 *
 * @ProductName: Hundsun
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.designmode.constructmode.proxy
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/11/28 8:58
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/11/28 8:58
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Client {

	public static void main(String[] args) {
		/*StaticProxySubject subject = new StaticProxySubject(new ConcreteSubject());
		subject.dealSubject();*/
		InvocationHandler handler = new DynamicProxySubject(new ConcreteSubject());
		AbstractSubject subject = (AbstractSubject) Proxy.newProxyInstance(AbstractSubject.class.getClassLoader(),
				new Class[]{AbstractSubject.class}, handler);
		subject.dealSubject();
	}
}
