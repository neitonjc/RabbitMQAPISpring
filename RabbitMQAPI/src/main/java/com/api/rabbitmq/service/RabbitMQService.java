package com.api.rabbitmq.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<PessoaDTO> enviaMsgSincrona(String nomeFila, Object msg) {
		this.rabbitTemplate.setReplyTimeout(6000);
		
		@SuppressWarnings("unchecked")
		List<PessoaDTO> retorno = (ArrayList<PessoaDTO>) this.rabbitTemplate.convertSendAndReceive(nomeFila, msg);
		
		return retorno;
	}

}
