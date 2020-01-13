package com.cqc.learning.java.io;

/**
 * 文件描述
 *
 * @ProductName: Hundsun
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.java.io
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/11/23 16:14
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/11/23 16:14
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class IntegerTest {

	public static void main(String[] args) {
		Integer i = 100;
		int j = 100;
		if (i.equals(j)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

		Integer k = 100;
		if (i.equals(k)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

		if ( j == i) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

		if ( k.equals(i)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
