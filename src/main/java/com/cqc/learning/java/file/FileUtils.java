package com.cqc.learning.java.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.nio.channels.FileChannel;

/**
 * 文件工具类
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class FileUtils {

	private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

	private FileUtils(){}

	public static final FileUtils getInstance(){
		return LazySingle.INSTANCE;
	}

	private static class LazySingle {
		private static final FileUtils INSTANCE = new FileUtils();
	}

	/**
	 * 判断是否在该路径上有对应的文件
	 * @param filePath 文件路径
	 * @param fileName 文件名称
	 * @return boolean
	 */
	protected static boolean isExists(String filePath, String fileName) {
		File file = new File(filePath + File.separatorChar + fileName);
		boolean flag = true;
		try {
			if (!file.exists()) {
				flag = file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("创建文件异常:" + e.getMessage());
			flag = false;
		}
		return flag;
	}

	/**
	 * 将message写入fileName中
	 * @param message 内容
	 * @param filePath 文件路径
	 * @param fileName 文件名称
	 * @return boolean
	 */
	protected static boolean writeToFile(String message, String fileName, String filePath) {
		boolean flag;
		FileOutputStream outStream = null;
		try {
			flag = isExists(filePath, fileName);
			if (flag) {
				outStream = new FileOutputStream(new File(filePath + fileName));
				byte[] buf = new byte[message.length()];
				outStream.write(buf, 0 , message.length());
			}
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
}
