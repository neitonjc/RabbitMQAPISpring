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
import io.swagger.annotations.ApiParam;

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
	public void createQueue(@RequestParam(required = true) String exchangeName,
								  @RequestParam(required = true) String exchangeType,
								  @RequestParam(required = true) String queueName,
						   		  @RequestParam(required = false) String routingKey) {
		rabbitMQService.createQueue(exchangeName, exchangeType, queueName, routingKey);
	}
	
	@PostMapping(path = "/sendAsynchronous")
	@ApiOperation(value = "Envia mensagens para a Exchange e/ou Routing Key selecionadas")
	@ResponseStatus(HttpStatus.OK)
	public void sendAsynchronous(@RequestParam(required = true) @ApiParam(value = "Nome Exchange") String exchangeName,
							     @RequestParam(required = false) @ApiParam(value = "Routing Key") String routingKey, 
			 				     @RequestBody(required = true) String msg) {
		rabbitMQService.sendAsynchronous(exchangeName, routingKey, msg);
	}

}
