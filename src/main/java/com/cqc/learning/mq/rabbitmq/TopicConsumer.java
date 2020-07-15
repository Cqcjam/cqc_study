package com.cqc.learning.mq.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 文件描述
 *
 * @ProductName: cqc
 * @ProjectName: 3Working
 * @Package: com.cqc.learning.mq.rabbitmq
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/11/29 10:19
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/11/29 10:19
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 cqc Technologies Inc. All Rights Reserved
 **/
public class TopicConsumer {
	private static final String QUEUE_NAME = "cqc_queue";
	private static final String IP_ADDR = "10.20.64.193";
	private static final String CONNECTIME_TIMEOUT = "30000";
	private static final Integer PORT = 5672;

	/**
	 * 接收direct消息
	 */
	private static void receiveMessage() {
		Address[] addresses = new Address[]{
				new Address(IP_ADDR, PORT)
		};

		//创建连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		//默认一分钟(更改为30s)
		factory.setConnectionTimeout(Integer.valueOf(CONNECTIME_TIMEOUT));
		//默认是guest
		factory.setUsername("guest");
		//默认是guest
		factory.setPassword("guest");

		Connection connection;
		Channel channel;
		try {
			//1、建立与服务器之间的连接
			connection = factory.newConnection(addresses);
			//2、创建通道
			channel = connection.createChannel(2);
			//3、设置客户端最多接受未被ack的消息的个数
			channel.basicQos(64);
			//4、创建消费
			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope,
				                           AMQP.BasicProperties properties, byte[] body) throws IOException {
					System.out.println("recv message: " + new String(body));
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
			};
			channel.basicConsume(QUEUE_NAME, consumer);
			//等待回调
			TimeUnit.SECONDS.sleep(5);
			//7、关闭资源
			channel.close();
			connection.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.getMessage();
		} catch (TimeoutException e) {
			e.getCause();
		}
	}

	public static void main(String[] args) {
		receiveMessage();
	}
}
