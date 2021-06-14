package com.cqc.learning.mq.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 文件描述 消息生产者
 * @author caoqc
 **/
public class Producer {

	private static final String ROUTING_KEY = "cqc_route_key";
	private static final String EXCHANGE_NAME = "cqc_exchange";
	private static final String QUEUE_NAME = "cqc_queue";
	private static final String IP_ADDR = "10.20.64.192";
	private static final String CONNECTIME_TIMEOUT = "30000";
	private static final Integer PORT = 5672;

	/**
	 * 发送direct消息
	 */
	private static void sendMessage() {
		ConnectionFactory factory = new ConnectionFactory();
		//主机IP
		factory.setHost(IP_ADDR);
		//端口
		factory.setPort(PORT);
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
			connection = factory.newConnection();
			//2、创建通道
			channel = connection.createChannel(2);
			//3、声明交换器(String exchange, String type, boolean durable, boolean autoDelete, Map<String, Object> arguments)
			channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);
			//4、声明队列(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
			channel.queueDeclare(QUEUE_NAME, true, false, false, null);
			//5、绑定(String queue, String exchange, String routingKey)
			channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
			//6、发送消息(String exchange, String routingKey, BasicProperties props, byte[] body)
			String message = "hello world";
			System.out.println("生产者开始发送");
			channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
			channel.basicPublish();
			System.out.println("生产者发送完成");
			//7、关闭资源
			channel.close();
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.getMessage();
		}
	}

	public static void main(String[] args) {
		sendMessage();
	}
}
