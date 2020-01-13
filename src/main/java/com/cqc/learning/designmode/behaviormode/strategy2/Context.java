package com.cqc.learning.designmode.behaviormode.strategy2;

/**
 * 文件描述
 *
 * @ProductName: Hundsun
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.designmode.behaviormode.strategy2
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/12/16 16:12
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/12/16 16:12
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Context {

	private IGradeStrategy iGradeStrategy;


	public IGradeStrategy getiGradeStrategy() {
		return iGradeStrategy;
	}

	public void setiGradeStrategy(IGradeStrategy iGradeStrategy) {
		this.iGradeStrategy = iGradeStrategy;
	}


	public String getStrategy(IGradeStrategy iGradeStrategy){
		return iGradeStrategy.getGrade();
	}

}
