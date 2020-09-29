package com.cqc.learning.java.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 文件测试类
 **/
public class FileTest {

	public static void main(String[] args) {

		try {
			//crm对应的邮箱
			Set<String> crmEmailList = Files.lines(Paths.get("E:\\11.txt"), StandardCharsets.UTF_8)
					.collect(Collectors.toSet());
			//it对应的邮箱
			Set<String> itEmailList = Files.lines(Paths.get("E:\\22.txt"), StandardCharsets.UTF_8)
					.collect(Collectors.toSet());
			//取差集
			Set<String> subList = itEmailList.stream().filter(item -> (!crmEmailList.contains(item)))
					.collect(Collectors.toSet());
			//取差集
			Set<String> subList2 = crmEmailList.stream().filter(item -> (!itEmailList.contains(item)))
					.collect(Collectors.toSet());
			System.out.println(subList);
			System.out.println(subList2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
