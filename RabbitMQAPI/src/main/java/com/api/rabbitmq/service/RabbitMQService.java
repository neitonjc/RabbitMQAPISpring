package com.api.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rabbitmq.dto.PessoaDTO;

@Service
public class RabbitMQService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void enviaMsgAssincrona(String nomeFila, Object msg) {
		this.rabbitTemplate.convertAndSend(nomeFila, msg);
	}
	
	public PessoaDTO enviaMsgSincrona(String nomeFila, Object msg) {
		this.rabbitTemplate.setReplyTimeout(6000);
		PessoaDTO retorno = (PessoaDTO) this.rabbitTemplate.convertSendAndReceive(nomeFila, msg);
		
		return retorno;
	}

}
