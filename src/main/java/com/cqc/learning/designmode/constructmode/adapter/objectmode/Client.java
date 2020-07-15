package com.cqc.learning.designmode.constructmode.adapter.objectmode;

/**
 * 文件描述
 *
 * @ProductName: cqc
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.designmode.adapter
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/11/21 16:30
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/11/21 16:30
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 cqc Technologies Inc. All Rights Reserved
 **/
public class Client {

	public static void main(String[] args) {
		ITarget iTarget = new AnimalAdapter(new AnimalAdaptee());
		iTarget.drink();
	}
}
