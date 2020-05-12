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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppTest.class, MainApplication.class})
public class AppTest {

	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("beforeClass test。。。");
	}

	@Before
	public void testBefore() {
		System.out.println("before test。。。");
	}

	@Autowired
	TestConfiguration testConfiguration;

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
}
