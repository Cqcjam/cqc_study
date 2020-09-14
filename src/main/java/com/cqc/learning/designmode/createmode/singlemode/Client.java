package com.cqc.learning.designmode.createmode.singlemode;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文件描述
 * Singleton通过将构造方法限定为private避免了类在外部被实例化，
 * 在同一个虚拟机范围内，Singleton的唯一实例只能通过getInstance()方法访问。
 **/
public class Client {

    public static void main(String[] args) {
	/*	HungrySingleObject instance = HungrySingleObject.getInstance();
		instance.getMethod();

		StaticInnerClassCreateSingle instance1 = StaticInnerClassCreateSingle.getInstance();
		instance1.getMethod();

		LazySingleObject lazySingleObject = LazySingleObject.getInstance();
		lazySingleObject.getMethod();*/
        Person person1 = new Person("1111", null);
        Person person2 = new Person("1111", null);
        List<Person> list = new ArrayList<>(2);
        list.add(person1);
        list.add(person2);
        List<String> emailList = list.stream()
                .map(Person::getEmail).distinct().collect(Collectors.toList());
       /* Map<String, String> namePosition = list.stream()
                .collect(Collectors.toMap(Person::getEmail, Person::getName));*/
//        System.out.println("namePosition=" + JSON.toJSONString(namePosition));
        System.out.println("emlistList=" + JSON.toJSONString(emailList));
        System.out.println("emlistListSIze=" + emailList.size());
        System.out.println("list=" + list.size());
        List<Integer> list1 = new ArrayList<>(2);
        list1.add(1);
        list1.add(2);
        System.out.println("tets=" + Joiner.on(",").join(list1));

        String emailTest = "wwacb@,email.com";
        List<String> contactEmailList = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(emailTest);
        System.out.println("contactEmailList=" + JSON.toJSONString(contactEmailList));


        List<String> positionList = list.stream().map(Person::getName).collect(Collectors.toList());
        person1.setName(JSON.toJSONString(positionList.stream().map(x -> x + "").collect(Collectors.toList()))
                .replaceAll("\"", "")
                .replace(",", ";")
                .replace("[", "")
                .replace("]", ""));
        System.out.println(person1.getName());
        System.out.println(positionList);
    }

    @Data
    static class Person {
        private String email;
        private String name;

        Person(String email, String name) {
            this.email = email;
            this.name = name;
        }
    }



}


