package com.learning;


import com.alibaba.fastjson.JSON;
import com.cqc.learning.MainApplication;
import com.cqc.learning.spring.bean.TestConfiguration;
import com.cqc.learning.spring.bean.entity.Person;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 执行顺序
 * beforeClass-->before-->testInstance-->after-->afterClass
 */
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppTest.class, MainApplication.class})
public class AppTest {
	@Autowired
	TestConfiguration testConfiguration;

	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("beforeClass test。。。");
	}

	@Before
	public void testBefore() {
		System.out.println("before test。。。");
	}

	@Test
	public void shouldAnswerWithTrue() throws ClassNotFoundException{
		Person person = testConfiguration.getPerson();
		System.out.println(JSON.toJSONString(person));
		Class person1 = Class.forName("com.cqc.learning.spring.bean.entity.Person");
		System.out.println(person1);
		System.out.println(Person.class.getClassLoader().getParent());
	}

	@After
	public void testAfter() {
		System.out.println("after test。。。");
	}

	@AfterClass
	public static void testAfterClass() {
		System.out.println("afterClass test。。。");
	}

	@AfterClass
	public static void testAfterClass1() {
		System.out.println("afterClass1 test。。。");
	}



//	@Test
//	public void testMail(){
//		sendAttachmentsMail("caoqingcong@corp.cqc.com", "test", "test", "E:\\cert\\证书使用说明.txt");
//	}
	/**
	 * 发送带附件内容
	 * @param to
	 * @param subject
	 * @param content
	 * @param filePath
	 */
	/*public void sendAttachmentsMail(String to, String subject, String content, String filePath){
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom("it_purchase@service.cqc.com");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content, true);
			FileSystemResource file = new FileSystemResource(new File(filePath));
			String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
			helper.addAttachment(fileName, file);
			javaMailSender.send(message);
			System.out.println("带附件的邮件已经发送。");
		} catch (MessagingException e) {
			System.out.println("发送带附件的邮件时发生异常！");
		}
	}*/

	public static Node transferBinaryTree(Node node) {
		//
		if (null == node) {
			return null;
		}
		//如果左子树不为空 且右子树不为空则进行交换
		if (null != node.left || null != node.right) {
			Node temp = new Node(0);
			temp.data = node.left.data;
			node.left.data = node.right.data;
			node.right.data = temp.data;
		}
		/*// 存在为空情况
		if (null == node.left) {
			Node temp = new Node(0);
			node.left = temp;
			node.left.data = node.right.data;
			node.right.data = null;
		}
		if (null == node.right){
			Node temp = new Node(0);
			node.right = temp;
			node.right.data = node.left.data;
			node.left.data = null;
		}*/
		//递归操作左右字数
		transferBinaryTree(node.left);
		transferBinaryTree(node.right);
		return node;
	}

	/**
	 * 节点定义
	 */
	static class Node {
		Node left;
		Node right;
		Integer data;
		Node (Integer data) {
			this.data = data;
		}

	}

	public static void main(String[] args) {
		Node node = new Node(4);
		node.right = new Node(3);
		node.left = new Node(2);
		System.out.println(JSON.toJSONString(transferBinaryTree((node))));
	}



}
