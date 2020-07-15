package com.cqc.learning.designmode.behaviormode.strategy2;

/**
 * 文件描述
 *
 * @ProductName: cqc
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.designmode.behaviormode.strategy2
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/12/16 16:04
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/12/16 16:04
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 cqc Technologies Inc. All Rights Reserved
 **/
public class GirlGradeStrategy implements IGradeStrategy {


	@Override
	public String getGrade() {
		return "女同学成绩: A";

	}
}
