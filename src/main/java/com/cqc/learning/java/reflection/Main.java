package com.cqc.learning.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
			// 第一种获取对象实例
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
			System.out.println(obj);
			// 第一种获取对象实例
			Class clz = Class.forName("com.cqc.learning.java.reflection.RefrectClass");
			Method method = clz.getMethod("setName", String.class);
			Constructor constructor = clz.getConstructor();
			RefrectClass object = (RefrectClass)constructor.newInstance();
			System.out.println(method.invoke(object, "cqc"));
			System.out.println(object.getName());
			Method method2 = obj.getClass().getMethod("setName", String.class);
			Object value = method2.invoke(obj, "cqc");
			System.out.println(value);


			//第二种获取对象实例 需要提前知道类属性
			Class clazz = RefrectClass.class;
			//第三种使用类对象 getClass

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
