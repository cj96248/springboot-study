package org.chao.rabbitmq.simple;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

public class Consumer {

	public static void main(String[] args) throws Exception {
		// 创建一个 ConnectionFactory
		ConnectionFactory factory = new ConnectionFactory();
		
		// 设置RabbitMQ连接参数
		factory.setHost("localhost");
		factory.setPort(5672);
		factory.setVirtualHost("/");
		
		// 获取一个连接
		Connection connection = factory.newConnection();
		
		// 创建信道Channel
		Channel channel = connection.createChannel();
		
		// 声明一个队列
		String queueName = "test";

		// 创建消费者
		DefaultConsumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				System.out.println("Received message :" + new String(body));
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				channel.basicAck(envelope.getDeliveryTag(), false);
			}
		};
		
		// 获取消息
		channel.basicConsume(queueName, true, consumer);
		
		// 释放资源，关闭连接
		channel.close();
		connection.close();
		
	}
}
