package com.cqc.learning.java.io;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 *
 * @ProductName: Hundsun
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.java.io
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/12/27 16:03
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/12/27 16:03
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class StringLine {
	public static final String SPILT_STYLE = "|";

	public static final String NEXT_LINE = "\r\n";

	public static void main(String[] args) {
		String str = "aa" + SPILT_STYLE + "bb" + SPILT_STYLE + "cc" + NEXT_LINE;
		String str2 = "cc" + SPILT_STYLE + "bb" + SPILT_STYLE + "cc" + NEXT_LINE;
		List<String> list = new ArrayList<>();
		list.add(str);
		list.add(str2);
		System.out.println(list);
	}
}
