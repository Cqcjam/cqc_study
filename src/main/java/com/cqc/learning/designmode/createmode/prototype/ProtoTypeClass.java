package com.cqc.learning.designmode.createmode.prototype;

/**
 * 文件描述
 *
 * @ProductName: cqc
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.designmode.createmode.prototype
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/12/3 15:02
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/12/3 15:02
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 cqc Technologies Inc. All Rights Reserved
 **/
public class ProtoTypeClass implements Cloneable{

	@Override
	public ProtoTypeClass clone() throws CloneNotSupportedException {
		return (ProtoTypeClass)super.clone();
	}

	protected void testMethod(String name){
		System.out.println("hello " + name);
	}
}
