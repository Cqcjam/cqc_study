package com.cqc.learning.algorithm;

import com.alibaba.fastjson.JSON;

/**
 * 循环打印矩阵
 * @author hspcadmin
 * Copyright © 2020 cqc Technologies Inc. All Rights Reserved
 **/
public class MatrixCirclePrint {

	public static void main(String[] args) {

		Integer[][] matrix = new Integer[5][5];
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = ++count;
			}
		}
		System.out.println("matrix=" + JSON.toJSONString(matrix));
		printMatrix(matrix);
	}

	/**
	 * 打印矩阵
	 * @param matrix 矩阵
	 */
	private static Integer[][] printMatrix(Integer[][] matrix) {
		int startRow = 0, startCol = 0, endRow = matrix.length-1, endCol = matrix[0].length-1;
		Integer[][] result = new Integer[matrix.length][matrix[0].length];

		//只有一行 打印当前列即可
		if (0 == endRow && startCol <= endCol) {
			System.out.println(matrix[startRow][startCol++]);
		}
		//只有一列 打印当前行即可
		if (0 == endCol && startRow <= endRow) {
			System.out.println(matrix[startRow++][startCol]);
		}
		//多行多列
		while (startRow <= endRow && startCol <= endCol) {
			int beginRow = startRow;
			int beginCol = startCol;
			int lastRow = endRow;
			int lastCol = endCol;
			//从左往右
			while (beginCol <= endCol) {
				int x = matrix[beginRow][beginCol++];
				System.out.println(x);
			}
			//从上到下
			while (beginRow < endRow) {
				int y = matrix[++beginRow][lastCol];
				System.out.println(y);
			}
			//从右到左
			while (lastCol > startCol) {
				int z = matrix[lastRow][--lastCol];
				System.out.println(z);
			}
			//从下到上
			while (lastRow > (startRow +1)) {
				int r = matrix[--lastRow][startCol];
				System.out.println(r);
			}
			startRow++;
			startCol++;
			endCol--;
			endRow--;
		}
		return result;
	}
}
