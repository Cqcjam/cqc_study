package com.cqc.learning.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 文件描述
 * 两个链表相加和
 * <p>
 * Copyright © 2020 cqc Technologies Inc. All Rights Reserved
 **/
public class LinkedPlus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			//集合1
			List<Node> list1 = new ArrayList<>(n);
			for (int i = 0; i < n; i++) {
				list1.add(new Node(sc.nextInt()));
			}
			System.out.println("list1=" + JSON.toJSONString(list1));
			//集合2
			List<Node> list2 = new ArrayList<>(n);
			for (int i = 0; i < n; i++) {
				list2.add(new Node(sc.nextInt()));
			}
			System.out.println("list2=" + JSON.toJSONString(list2));

			List<Node> result = dealPlusNode(list1, list2);
			System.out.println("result=" + JSON.toJSONString(result));
		}

	}


	private static List<Node> dealPlusNode(List<Node> list1, List<Node> list2) {
		List<Node> result = new ArrayList<>(list1.size() + list2.size());
		Node newNode = new Node();
		if (null == list1 && null == list2) {
			return result;
		}
		if (list1 == null) {
		}
		return result;
	}

	private static int dealPlusTwoNode(Node node1, Node node2, int plus) {
		if (node1 != null && node2 != null) {
			return node1.data + node2.data + plus;
		}
		return 0;
	}

	public static class Node{
		private Node next;
		private int data;
		public Node(){}
		public Node(int data){this.data = data;}
		public Node(int data, Node next){
			this.data = data;
			this.next = next;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}
	}

}
