package com.cqc.learning.designmode.constructmode.bridge;

import com.cqc.learning.designmode.createmode.builder.ConcreteBuilder;

/**
 * 文件描述
 *
 * @ProductName: Hundsun
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.designmode.constructmode.bridge
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/11/28 17:40
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/11/28 17:40
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class ConcreteClass extends AbstractSuperClass{

	public ConcreteClass(ISuperInterface iSuperInterface){
		super(iSuperInterface);
	}

	@Override
	public void eat() {
		System.out.println("开心吃");
		iSuperInterface.eat();
	}
}
