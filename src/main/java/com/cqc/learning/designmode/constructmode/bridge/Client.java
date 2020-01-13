package com.cqc.learning.designmode.constructmode.bridge;

/**
 * 文件描述
 *
 * @ProductName: Hundsun
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.designmode.constructmode.bridge
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/11/28 17:41
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/11/28 17:41
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Client {

	public static void main(String[] args) {
		ISuperInterface superInterface = new SuperClassImple();
		AbstractSuperClass abstractSuperClass = new ConcreteClass(superInterface);
		abstractSuperClass.eat();

	}
}
