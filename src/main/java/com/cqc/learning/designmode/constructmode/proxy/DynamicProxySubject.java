package com.cqc.learning.designmode.constructmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 *
 * @ProductName: cqc
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.designmode.constructmode.proxy
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/11/28 9:06
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/11/28 9:06
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 cqc Technologies Inc. All Rights Reserved
 **/
public class DynamicProxySubject implements InvocationHandler {

	private Object object;

	public DynamicProxySubject(Object subject) {
		this.object = subject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		method.invoke(object, args);
		return null;
	}

}
