package com.cqc.learning.java.file;

/**
 * 文件测试类
 **/
public class FileTest {

	public static void main(String[] args) {
		boolean flag = FileUtils.getInstance().isExists("D:\\", "test.txt");
		System.out.println(flag);

		System.out.println(FileUtils.getInstance().writeToFile("hello word", "test.txt", "D:\\"));

	}
}
