package com.cqc.learning.designmode.behaviormode.strategy2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 文件描述
 *
 * @ProductName: cqc
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.designmode.behaviormode.strategy2
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/12/16 16:17
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/12/16 16:17
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 cqc Technologies Inc. All Rights Reserved
 **/
public class StrategyFactory {
	private static StrategyFactory factory;
	private StrategyFactory() {}

	private static Map<String, IGradeStrategy> strategyMap = new ConcurrentHashMap<>();
	static {
		strategyMap.put("boy", new BoyGradeStrategy());
		strategyMap.put("girl", new GirlGradeStrategy());
	}

	public static IGradeStrategy createStrategy(String type){
		if (null == strategyMap.get(type)) {
			strategyMap.put(type, new GirlGradeStrategy());
		}
		return strategyMap.get(type);
	}

	public static StrategyFactory buildFactory() {
		if (null == factory) {
			synchronized (StrategyFactory.class) {
				factory = new StrategyFactory();
			}
		}
		return factory;
	}



}
