package org.chao.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {
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
		
		// 发送数据
		String message = "Hello world!";
		channel.basicPublish("", "test", null, message.getBytes());
		
		// 释放资源，关闭连接
		channel.close();
		connection.close();
		
	}
}
