package com.cqc.learning.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 文件描述
 * 链表比较排序
 * @author caoqc
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class LinkedCompareSort {

	private static final Integer COUNT = 5;

	public static void main(String[] args) {

		List<LinkedNode> list1 = createNode();
		List<LinkedNode> list2 = createNode();


	}

	/**
	 * 创建节点集合
	 * @return List
	 */
	private static LinkedList<LinkedNode> createNode() {
		LinkedList<LinkedNode> list = new LinkedList<>();
		for (int i = 0; i < COUNT; i++) {
			LinkedNode node1 = new LinkedNode();
			node1.setData(new Random().nextInt(7) + 1);
			node1.setNext(new LinkedNode());
			list.add(node1);
		}
		return list;
	}

	/**
	 * 单链表数据结构
	 */
	public static class LinkedNode {

		LinkedNode next;
		Integer data;

		public LinkedNode getNext() {
			return next;
		}

		public void setNext(LinkedNode next) {
			this.next = next;
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

	}
}
