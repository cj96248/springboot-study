package org.chao.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;

public class Consumer {

	public static void main(String[] args) throws Exception {
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
		
		// 声明一个队列
		String queueName = "test";
		channel.queueDeclare(queueName, true, false, false, null);

		// 创建消费者
		DefaultConsumer consumer = new DefaultConsumer(channel);
		
		channel.basicConsume(queueName, true, consumer);
		
		// 获取消息
		// 释放资源，关闭连接
		channel.close();
		connection.close();
		
	}
}
