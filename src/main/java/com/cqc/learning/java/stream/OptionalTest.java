package com.cqc.learning.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 文件描述
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class OptionalTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		//list.add("1");
		//System.out.println(Optional.of(list));

		System.out.println(Optional.ofNullable(list));


		if (Optional.ofNullable(list).isPresent()) {
			System.out.println("null");
		} else {
			System.out.println("yes");
		}
	}

}
