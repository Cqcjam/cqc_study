package com.cqc.learning.java.stream;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.compress.utils.Lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * 文件描述
 *
 * @ProductName: Hundsun
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.java.stream
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/11/28 15:21
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/11/28 15:21
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class StreamTest {

	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();
		Person person1 = new Person(12L, 12L);
		Person person2 = new Person(13L, 13L);
		Person person3 = new Person(null, 13L);
		Person person4 = new Person(12L, 14L);
		Person person5 = new Person(12L, null);
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		personList.add(person4);
		personList.add(person5);
		/*personList = personList.stream().collect(
				collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getAge()))),
						ArrayList::new));*/

		List<Long> list = personList.stream().map(Person::getAge)
				.filter(t-> (null != t))
				.distinct()
				.collect(Collectors.toList());


		for (Long age : list) {
			List<Long> sexList = personList.stream().filter(t -> null != t.getAge() && t.getAge().equals(age))
					.filter(s -> null != s.getSex()).map(Person::getSex).distinct().collect(Collectors.toList());
			System.out.println("age=" + age + ",List=" + JSON.toJSONString(sexList));
		}

		/*BigDecimal amounts = personList.stream().map(item -> item.getAge())
				.reduce(BigDecimal::add).get();
		amounts = amounts.setScale(1, BigDecimal.ROUND_DOWN);
		System.out.println(amounts);*/
		/*personList = personList.stream()
									  .filter(t-> (
									  		  !"".equals(t.getSex()) &&  "".equals(t.getAge())
											  ? "Female".equals(t.getSex()) :
											  "".equals(t.getSex()) && "".equals(t.getAge())
											  ? "".equals(t.getSex()) : "".equals(t.getSex())
									     ))
				                      .sorted(Comparator.comparing(Person::getAge).reversed())
									  .collect(Collectors.toList());*/

		System.out.println(JSONObject.toJSONString(list));

	}

	static class Person{
		private Long age;
		private Long sex;

		Person(Long age, Long sex) {
			this.age = age;
			this.sex = sex;
		}

		public Long getAge() {
			return age;
		}

		public void setAge(Long age) {
			this.age = age;
		}

		public Long getSex() {
			return sex;
		}

		public void setSex(Long sex) {
			this.sex = sex;
		}

	}
}
