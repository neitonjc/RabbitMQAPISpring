package com.api.rabbitmq.connections;

import org.springframework.amqp.core.AbstractExchange;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConnection {
	
	private AmqpAdmin amqpAdmin;
	
	public RabbitMQConnection(AmqpAdmin amqpAdmin) {
		this.amqpAdmin = amqpAdmin;
	}
	
	@SuppressWarnings("unused")
	private Queue createQueue(String queueName) {
//		Map<String, Object> m = new HashMap<String, Object>();
//		m.put("x-message-ttl", 15000);
//		return new Queue(queueName, true, false, false, m);
		return new Queue(queueName, true, false, false);
	}
	
	private Binding bindingExchange(Queue queue, AbstractExchange exchange, String routingKey) {
		return new Binding(queue.getName(), 
						   Binding.DestinationType.QUEUE, 
						   exchange.getName(), 
						   routingKey, 
						   null);
	}
	
	public void createQueue(String exchangeName, String exchangeType, String queueName, String routingKey) throws RuntimeException {
		AbstractExchange exchange;
		
		switch (exchangeType) {
		case ExchangeTypes.DIRECT:
			exchange = new DirectExchange(exchangeName);
			break;
		case ExchangeTypes.FANOUT:
			exchange = new FanoutExchange(exchangeName);
			break;
		case ExchangeTypes.HEADERS:
			exchange = new HeadersExchange(exchangeName);
			break;
		case ExchangeTypes.TOPIC:
			exchange = new TopicExchange(exchangeName);
			break;
		default:
			throw new RuntimeException("Exchange Type informado não existe!");
		}
		
		Queue queue = new Queue(queueName, true, false, false);
		Binding linkQueueExchange = bindingExchange(queue, exchange, routingKey);
		
		this.amqpAdmin.declareQueue(queue);
		this.amqpAdmin.declareExchange(exchange);
		this.amqpAdmin.declareBinding(linkQueueExchange);
	}
	
}
