package com.cqc.learning.designmode.behaviormode.strategy;

/**
 * 文件描述
 * 策略上下文
 **/
public class StrategyContext {

	IStrategy strategy;

	public  StrategyContext(IStrategy iStrategy) {
		strategy = iStrategy;
	}

	public void callStrategy() {
		strategy.strategyMethod();
	}

}
