package com.cqc.learning.designmode.behaviormode.strategy;

/**
 * 文件描述
 * 策略模式，根据对应的实现策略子类来调用不同的策略方法
 **/
public class Client {

	public static void main(String[] args) {
		//IStrategy iStrategy = new ConcreteStrategy1();
		IStrategy iStrategy = new ConcreteStrategy2();
		StrategyContext context = new StrategyContext(iStrategy);
		context.callStrategy();
	}
}
