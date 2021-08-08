package com.api.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void enviaMsgAssincrona(String nomeFila, Object msg) {
		this.rabbitTemplate.convertAndSend(nomeFila, msg);
	}
	
	public Object enviaMsgSincrona(String nomeFila, Object msg) {
		this.rabbitTemplate.setReplyTimeout(6000);
		
		Object obj = this.rabbitTemplate.convertSendAndReceive(nomeFila, msg);
		
		if(obj==null)
			this.rabbitTemplate.destroy();
		
		return obj;
	}

}
