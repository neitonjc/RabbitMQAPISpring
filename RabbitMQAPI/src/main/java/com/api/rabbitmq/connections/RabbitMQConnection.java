package com.api.rabbitmq.connections;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import com.api.rabbitmq.constantes.RabbitMQConstantes;

@Component
public class RabbitMQConnection {
	
	private static final String NOME_EXCHANGE = "amq.direct"; 
	
	private AmqpAdmin amqpAdmin;
	
	public RabbitMQConnection(AmqpAdmin amqpAdmin) {
		this.amqpAdmin = amqpAdmin;
	}
	
	private Queue fila(String nomeFila) {
		return new Queue(nomeFila, true, false, false);
//		Map<String, Object> m = new HashMap<String, Object>();
//		m.put("message-ttl", 5000);
//		return new Queue(nomeFila, true, false, false, m);
	}
	
	private DirectExchange trocaDireta() {
		return new DirectExchange(NOME_EXCHANGE);
	}
	
	private Binding relacionamento(Queue fila, DirectExchange troca) {
		return new Binding(fila.getName(), 
						   Binding.DestinationType.QUEUE, 
						   troca.getName(), 
						   fila.getName(), 
						   null);
	}
	
	@PostConstruct
	private void adiciona() {
		Queue fila1 = fila(RabbitMQConstantes.FILA_1);
		Queue fila2 = fila(RabbitMQConstantes.FILA_2);
		
		DirectExchange troca = trocaDireta();
		
		Binding link1 = relacionamento(fila1, troca);
		Binding link2 = relacionamento(fila2, troca);
		
		this.amqpAdmin.declareQueue(fila1);
		this.amqpAdmin.declareQueue(fila2);
		
		this.amqpAdmin.declareExchange(troca);
		
		this.amqpAdmin.declareBinding(link1);
		this.amqpAdmin.declareBinding(link2);
		
	}
	
}
