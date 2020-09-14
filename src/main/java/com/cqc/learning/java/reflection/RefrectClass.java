package com.cqc.learning.java.reflection;

import lombok.Data;

/**
 * 文件描述
 * <p>
 * Copyright © 2019 cqc Technologies Inc. All Rights Reserved
 **/
@Data
public class RefrectClass {
	private Integer age;
	private String name;

	public void getMethod1(){
		System.out.println("method1()");
	}

	private String getMethod2(String name){
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
