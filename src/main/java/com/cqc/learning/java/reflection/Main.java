package com.cqc.learning.java.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * 文件描述
 *
 * @ProductName: cqc
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.java.reflection
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/12/3 9:14
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/12/3 9:14
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 cqc Technologies Inc. All Rights Reserved
 **/
public class Main {

	public static void main(String[] args) {
		try {
			RefrectClass obj = (RefrectClass)Class.forName("com.cqc.learning.java.reflection.RefrectClass").newInstance();
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field f : fields) {
				System.out.println("Field=" + f.getName());
			}
			System.out.println("ClassName=" + obj.getClass().getName());

			Method[] methods = obj.getClass().getMethods();
			for (Method m : methods) {
				System.out.println("Method=" + m.getName());
			}
			HashMap map = new HashMap();
			System.out.println(obj);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
}
