package com.cqc.learning.designmode.constructmode.bridge;

/**
 * 文件描述
 *
 * @ProductName: cqc
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.designmode.constructmode.bridge
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/11/28 17:35
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/11/28 17:35
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 cqc Technologies Inc. All Rights Reserved
 **/
public class SuperClassImple implements ISuperInterface{

	@Override
	public void eat(){
		System.out.println("超类吃");
	}

}
