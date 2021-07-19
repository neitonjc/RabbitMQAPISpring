package com.api.consumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.api.consumer.constantes.RabbitMQConstantes;
import com.api.rabbitmq.dto.PessoaDTO;

@Component
public class PessoaConsumer {
	
	@RabbitListener(queues = RabbitMQConstantes.FILA_1)
	private void consumidor(PessoaDTO pessoa) throws Exception {
		if(pessoa.nome.isEmpty())
			throw new RuntimeException(">>>>>>>>>>>----<<<<<<<<<<<");
		
		
		System.out.println("---------");
		System.out.println(pessoa.nome);
		System.out.println(pessoa.email);
	}

}
