package com.api.rabbitmq.controller;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.rabbitmq.service.RabbitMQService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Validated
@Api("API Rest Produtora RabbitMQ")
@RequestMapping({"/queues"})
public class QueuesController {
	
	@Autowired
	private RabbitMQService rabbitMQService;
	
	
	@PostMapping(path = "/create")
	@ApiOperation(value = "Cria Filas")
	@ResponseStatus(HttpStatus.CREATED)
	public void createQueue(@RequestParam("exchangeName") @Nullable String exchangeName,
								  @RequestParam("exchangeType") @Nullable String exchangeType,
								  @RequestParam("queueName") @Nullable String queueName,
						   		  @RequestParam("routingKey") @Nullable String routingKey) {
		rabbitMQService.createQueue(exchangeName, exchangeType, queueName, routingKey);
	}
	
	@PostMapping(path = "/sendAsynchronous")
	@ApiOperation(value = "Envia mensagens para a Exchange e Routing Key selecionadas")
	@ResponseStatus(HttpStatus.OK)
	public void sendAsynchronous(@RequestParam("exchangeName") String exchangeName,
							    @RequestParam("routingKey") @Nullable String routingKey, 
			 				    @RequestBody @NotBlank String msg) {
		rabbitMQService.sendAsynchronous(exchangeName, routingKey, msg);
	}

}
