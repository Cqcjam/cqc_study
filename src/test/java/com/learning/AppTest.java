package com.learning;


import com.cqc.learning.MainApplication;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

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

	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
		try {
			Assert.assertEquals(1100, 1100);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
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
