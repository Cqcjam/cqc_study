package com.cqc.learning.designmode.behaviormode.template;

/**
 * 文件描述
 * @author hspc
 **/
public class People extends TemplateAbstract{

	private static People people;

	private People(){}

	public static People getInstance(){
		if (people == null) {
			synchronized (People.class) {
				people = new People();
			}
		}
		return people;
	}

	@Override
	public void eat() {
		System.out.println("吃饭。。。");
	}

	@Override
	public void drink() {
		System.out.println("喝水。。。");
	}
}
