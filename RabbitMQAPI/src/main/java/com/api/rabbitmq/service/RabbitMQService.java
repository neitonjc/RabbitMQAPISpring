package com.api.rabbitmq.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rabbitmq.connections.RabbitMQConnection;

@Service
public class RabbitMQService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	RabbitMQConnection rabbitMQConnection;
	
	public void sendAsynchronous(String exchangeName, String routingKey, String msg) {
		this.rabbitTemplate.send(exchangeName, routingKey, new Message(msg.getBytes()));
	}
	
	public void enviaMsgAssincrona(String nomeFila, Object msg) {
		this.rabbitTemplate.convertAndSend(nomeFila, msg);
	}
	
	public void enviaMsgAssincronaSemConverter(String nomeFila, String msg) {
		this.rabbitTemplate.send(nomeFila, new Message(msg.getBytes()));
	}
	
	public Object enviaMsgSincrona(String nomeFila, Object msg) {
		this.rabbitTemplate.setReplyTimeout(6000);
		
		Object obj = this.rabbitTemplate.convertSendAndReceive(nomeFila, msg);
		
		if(obj==null)
			this.rabbitTemplate.destroy();
		
		return obj;
	}

	public void createQueue(String exchangeName, String exchangeType, String queueName, String routingKey) {
		rabbitMQConnection.createQueue(exchangeName, exchangeType, queueName, routingKey);
	}

}
