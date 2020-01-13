package com.cqc.learning.designmode.behaviormode.strategy2;

/**
 * 文件描述
 *
 * @ProductName: Hundsun
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.designmode.behaviormode.strategy2
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/12/16 16:22
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/12/16 16:22
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Client {

	public static void main(String[] args) {
		IGradeStrategy strategy = StrategyFactory.buildFactory().createStrategy("girl");
		if (null != strategy) {
			System.out.println(strategy.getGrade());
		} else {
			System.out.println("null");
		}
	}
}
