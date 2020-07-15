package com.cqc.learning.java.stream;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.expression.ExpressionException;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

/**
 * 1、Optional.of(obj)如果是空的会抛出NullPointerException异常，可以使用ofNullable(obj)避免空指针异常
 * 2、Optional.empty()创建一个空Optional
 * 3、Optional.ofNullable(obj).orElse()
 * 文件描述
 * <p>
 * Copyright © 2019 cqc Technologies Inc. All Rights Reserved
 **/
public class OptionalTest {

	public static void main(String[] args) {
		User user = new User();
		user.setName("gg");

		User user1 = Optional.ofNullable(user).orElse(createUser(user.getName()));
		System.out.println(JSON.toJSON(user1));

		User user2 = Optional.ofNullable(user).orElseGet(() ->createUser(user.getName()));
		System.out.println(JSON.toJSONString(user2));

		System.out.println(JSON.toJSONString(Optional.ofNullable(user).orElseThrow(() ->new ExpressionException("hh"))));


		//判断空
//		System.out.println(Optional.ofNullable(list).orElse(Collections.singletonList("1")));
//		System.out.println(Optional.empty());
//		new Optional<Integer>().isPresent()
		/*Date endDate = new Date();
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		System.out.println("end0=" + end.getTime());
		end.add(Calendar.MONTH, 1);
		Date end1 = end.getTime();
		System.out.println("end1=" + end1);
		end.add(Calendar.DAY_OF_YEAR, Integer.parseInt("2"));
		System.out.println("end2=" + end.getTime());

		System.out.println(getStartTime(end1));
		System.out.println(getEndTime(end1));*/
	}

	private static User createUser(String name) {
		User user = new User();
		user.setName("hh");
		System.out.println(name);
		return user;
	}

	@Data
	private static class User{
		private String name;

	}


	/**
	 * 获取指定日期的最后时间
	 */
	public static Date getEndTime(Date time) {
		Date startTime = getStartTime(time);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startTime);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
		calendar.set(Calendar.MILLISECOND, calendar.get(Calendar.MILLISECOND) - 1);
		return calendar.getTime();
	}

	public static Date getStartTime(Date time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		return calendar.getTime();
	}
}
