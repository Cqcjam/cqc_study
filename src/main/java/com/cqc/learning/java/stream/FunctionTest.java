package com.cqc.learning.java.stream;

import java.util.function.Function;

/**
 * 文件描述
 *
 * @ProductName: cqc
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.java.stream
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/12/19 15:32
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/12/19 15:32
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 cqc Technologies Inc. All Rights Reserved
 **/
public class FunctionTest {

	public static String functionTest(String str){
		return str + " OK";
	}

	public static String function(String str){
		return str + " YES";
	}

	public static String get(FunctionInterfaceTest t, String str){
		return t.test(str);
	}

	public static void main(String[] args) {

		//functionTest(t->functionTest(new FunctionInterfaceTest::test));

		FunctionInterfaceTest test = t -> t + " hello";
		System.out.println(test.test("me"));

		FunctionInterfaceTest test2 = FunctionTest::function;
		System.out.println(test2.test2("ni"));

		System.out.println(get(test2, "cqc"));
	}
}
