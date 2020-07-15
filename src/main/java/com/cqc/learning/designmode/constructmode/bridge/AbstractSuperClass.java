package com.cqc.learning.designmode.constructmode.bridge;

/**
 * 文件描述
 *
 * @ProductName: cqc
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.designmode.constructmode.bridge
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/11/28 17:38
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/11/28 17:38
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 cqc Technologies Inc. All Rights Reserved
 **/
public abstract class AbstractSuperClass implements ISuperInterface{

	ISuperInterface iSuperInterface;

	public  AbstractSuperClass (ISuperInterface iSuperInterface) {
		this.iSuperInterface = iSuperInterface;
	}

	@Override
	public abstract void eat();
}
