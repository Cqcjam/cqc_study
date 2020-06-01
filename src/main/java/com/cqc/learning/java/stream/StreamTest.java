package com.cqc.learning.java.stream;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

	private final Long ageTemp = 0L;

	public static void main(String[] args) {

		List<AccountDetail> accountList = new ArrayList<>();
		AccountDetail detail = new AccountDetail();
		detail.setWangAccountPrice(11.11);
		detail.setZhiAccountPrice(0.00);
		detail.setAccountTotalPrice(11.11);
		AccountDetail detail1= new AccountDetail();
		detail1.setWangAccountPrice(11.11);
		detail1.setZhiAccountPrice(0.00);
		detail1.setAccountTotalPrice(11.11);
		accountList.add(detail);
		accountList.add(detail1);

		System.out.println(accountList.stream().collect(Collectors.summingDouble(AccountDetail::getWangAccountPrice)));
		System.out.println(accountList.stream().mapToDouble(AccountDetail::getZhiAccountPrice).sum());
		System.out.println(accountList.stream().mapToDouble(AccountDetail::getAccountTotalPrice).sum());


		List<String> checkDateList = new ArrayList<>(2);
		checkDateList.add("2020.02.01");

		System.out.println(checkDateList.stream().map(startDate -> startDate.substring(0, 7)).collect(Collectors.toList()));


		List<Person> personList = new ArrayList<>();
		Person person1 = new Person(12L, "Male");
		Person person2 = new Person(13L, "Male");
		Person person3 = new Person(1L, "Male");
		Person person4 = new Person(14L, "Female");
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
				.filter(Objects::nonNull)
				.distinct()
				.collect(Collectors.toList());
		System.out.println("list=" + list);

		for (Long age : list) {
			List<String> sexList = personList.stream().filter(t -> null != t.getAge() && t.getAge().equals(age))
					.filter(s -> null != s.getSex()).map(Person::getSex).distinct().collect(Collectors.toList());
			System.out.println("age=" + age + ",List=" + JSON.toJSONString(sexList));
		}
		System.out.println(personList);
		Long amounts = personList.stream().map(Person::getAge)
				.reduce(Long::sum).get();
		System.out.println(amounts);
		/*personList = personList.stream()
									  .filter(t-> (
									  		  !"".equals(t.getSex()) &&  "".equals(t.getAge())
											  ? "Female".equals(t.getSex()) :
											  "".equals(t.getSex()) && "".equals(t.getAge())
											  ? "".equals(t.getSex()) : "".equals(t.getSex())
									     ))
				                      .sorted(Comparator.comparing(Person::getAge).reversed())
									  .collect(Collectors.toList());*/
	}

	static class Person{
		private Long age;
		private String sex;

		Person(Long age, String sex) {
			this.age = age;
			this.sex = sex;
		}

		public Long getAge() {
			return age;
		}

		public void setAge(Long age) {
			this.age = age;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public static Long add(Long age) {
			return Long.valueOf(age);
		}
	}
}
