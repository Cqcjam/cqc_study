package com.cqc.learning.designmode.constructmode.proxy;

/**
 * 文件描述
 *
 * @ProductName: Hundsun
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.designmode.constructmode.proxy
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/11/28 8:55
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/11/28 8:55
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class ConcreteSubject implements AbstractSubject{
	@Override
	public void dealSubject() {
		System.out.println("我是真实对象");
	}
}
