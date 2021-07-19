package com.api.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void enviaMsg(String nomeFila, Object msg) {
		this.rabbitTemplate.convertAndSend(nomeFila, msg);
	}

}
