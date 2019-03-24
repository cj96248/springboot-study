package org.chao.rabbitmq.simple;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {
	public static void main(String[] args) throws Exception {
		
		String exchangeName = "exchange_test";
		String queueName = "test";
		
		// 创建一个 ConnectionFactory
		ConnectionFactory factory = new ConnectionFactory();
		
		// 设置RabbitMQ参数
		factory.setHost("localhost");
		factory.setPort(5672);
		factory.setVirtualHost("/");
		
		// 获取一个连接
		Connection connection = factory.newConnection();
		
		// 创建Channel
		Channel channel = connection.createChannel();
		
		// 创建一个"direct"类型、非排他、非自动删除的交换机
		channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT, true, false, null);
		
		// 创建一个持久化、非排他的、非自动删除的队列
		channel.queueDeclare(queueName, true, false, false, null);
		
		channel.queueBind(queueName, exchangeName, "key_test");
		// 发送数据
		String message = "Hello world!";
		channel.basicPublish(exchangeName, "key_test", null, message.getBytes());
		
		// 释放资源，关闭连接
		channel.close();
		connection.close();
		
	}
}
