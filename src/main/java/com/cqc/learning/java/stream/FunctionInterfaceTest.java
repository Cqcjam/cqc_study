package com.cqc.learning.java.stream;

/**
 * 文件描述
 *
 * @ProductName: Hundsun
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.java.stream
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/12/19 15:30
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/12/19 15:30
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@FunctionalInterface
public interface FunctionInterfaceTest {

	String test(String name);

	default String test2(String name){
		return "hello " + name;
	}

}
