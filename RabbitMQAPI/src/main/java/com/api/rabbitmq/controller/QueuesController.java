package com.api.rabbitmq.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

@RestController
@Validated
@RequestMapping({"/queues"})
public class QueuesController {
	
	@Autowired
	private RabbitMQService rabbitMQService;
	
	
	@PostMapping(path="/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createQueue(@RequestParam("exchangeName") @Valid @NotBlank String exchangeName,
								  @RequestParam("exchangeType") @NotNull @NotBlank String exchangeType,
								  @RequestParam("queueName") @NotNull @NotBlank String queueName,
						   		  @RequestParam("routingKey") String routingKey) {
		rabbitMQService.createQueue(exchangeName, exchangeType, queueName, routingKey);
	}
	
	@PostMapping(path="/sendAsynchronous")
	@ResponseStatus(HttpStatus.OK)
	public void sendAsynchronous(@RequestParam("exchangeName") @NotBlank String exchangeName,
							    @RequestParam("routingKey") @Nullable String routingKey, 
			 				    @RequestBody @NotBlank String msg) {
		rabbitMQService.sendAsynchronous(exchangeName, routingKey, msg);
	}

}
