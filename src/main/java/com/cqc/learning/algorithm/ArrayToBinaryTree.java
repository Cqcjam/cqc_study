package com.cqc.learning.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 文件描述
 * @author hspcadmin
 * Copyright © 2020 cqc Technologies Inc. All Rights Reserved
 **/
public class ArrayToBinaryTree {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] array;
		while (sc.hasNext()) {
			int n = sc.nextInt();
			array = new int[n];
			for(int i = 0; i < n; i++) {
				array[i] = sc.nextInt();
			}
			System.out.println("origin arr=" + JSON.toJSONString(array));
			List<Node> list = dealBinaryTree(array);
			System.out.println("result sort arr=" + JSON.toJSONString(list));
			printBinaryTree(list);
		}
	}

	/**
	 * 处理
	 * @param array
	 */
	private static List<Node> dealBinaryTree(int[] array) {
		if (array == null || array.length <= 0) {
			return null;
		}
		//创建二叉树集合
		List<Node> list = new ArrayList<>();
		for(int data : array) {
			list.add(new Node(null, null, data));
		}
		System.out.println(JSON.toJSONString(list));
		for (int i = 0; i <= (array.length>>1) - 1; i++){
			if (array.length > 1<<i + 1) {
				list.get(i).left = list.get(1<<i + 1);
			}
			if (array.length > 1<<i + 2) {
				list.get(i).right = list.get(1<<i + 2);
			}
		}
		return list;


	}
	private static void printBinaryTree(List<Node> array) {
		int i = 0;
		int j = array.size();
		while (j >=0) {
			System.out.println(array.get(i).getData());
			System.out.println(array.get(i).getLeft());
			System.out.println(array.get(i).getRight());
			i++;
			j = j-1;
		}
	}

	public static class Node {
		Node left;
		Node right;
		int data;

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node(Node left, Node right, int data) {
			this.left = left;
			this.right = right;
			this.data = data;
		}
	}


}
