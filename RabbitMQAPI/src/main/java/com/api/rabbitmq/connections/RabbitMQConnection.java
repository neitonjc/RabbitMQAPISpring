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
		Queue filaIncluir = fila(RabbitMQConstantes.FILA_INCLUIR);
		Queue filaListar = fila(RabbitMQConstantes.FILA_LISTAR);
		Queue filaListarPorNome = fila(RabbitMQConstantes.FILA_LISTAR_POR_NOME);
		Queue filaDisparoMassa = fila(RabbitMQConstantes.FILA_DISP_MASSA);
		
		DirectExchange troca = trocaDireta();
		
		Binding linkIncluir = relacionamento(filaIncluir, troca);
		Binding linkListar = relacionamento(filaListar, troca);
		Binding linkListarPorNome = relacionamento(filaListarPorNome, troca);
		Binding linkDisparoMassa = relacionamento(filaDisparoMassa, troca);
		
		this.amqpAdmin.declareQueue(filaIncluir);
		this.amqpAdmin.declareQueue(filaListar);
		this.amqpAdmin.declareQueue(filaListarPorNome);
		this.amqpAdmin.declareQueue(filaDisparoMassa);
		
		this.amqpAdmin.declareExchange(troca);
		
		this.amqpAdmin.declareBinding(linkIncluir);
		this.amqpAdmin.declareBinding(linkListar);
		this.amqpAdmin.declareBinding(linkListarPorNome);
		this.amqpAdmin.declareBinding(linkDisparoMassa);
		
	}
	
}
