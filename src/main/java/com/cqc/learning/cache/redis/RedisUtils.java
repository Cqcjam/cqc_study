package com.cqc.learning.cache.redis;

import redis.clients.jedis.Jedis;

/**
 * 文件描述
 *
 * @ProductName: cqc
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.cache.redis
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/12/3 8:56
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/12/3 8:56
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 cqc Technologies Inc. All Rights Reserved
 **/
public class RedisUtils {

	private static RedisUtils redisUtils = null;

	private static Jedis jedis = null;

	private RedisUtils() {}

	public static RedisUtils getInstance(){
		if (null == redisUtils ) {
			synchronized (RedisUtils.class) {
				if (null == redisUtils) {
					redisUtils = new RedisUtils();
				}
			}
		}
		return redisUtils;
	}


	public static String get(String redisKey) {
		if (null == redisKey) {
			return "";
		}
		//jedis = new Jedis()
		return "";

	}

}
