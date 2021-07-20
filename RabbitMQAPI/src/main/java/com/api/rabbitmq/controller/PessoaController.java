package com.api.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.rabbitmq.constantes.RabbitMQConstantes;
import com.api.rabbitmq.dto.PessoaDTO;
import com.api.rabbitmq.service.RabbitMQService;

@RestController
@RequestMapping({"/rabbitMQAPI"})
public class PessoaController {
	
	@Autowired
	private RabbitMQService rabbitMQService;
	
	@PostMapping(path="/msgAssinc")
	@ResponseStatus(HttpStatus.OK)
	public void enviarMsgAssincrona(@RequestBody PessoaDTO pessoa){
		this.rabbitMQService.enviaMsgAssincrona(RabbitMQConstantes.FILA_1, pessoa);
	}
	
	@GetMapping(path="/msgSinc")
	public ResponseEntity<PessoaDTO> enviarMsgSincrona(@RequestBody PessoaDTO pessoa){
		PessoaDTO p = rabbitMQService.enviaMsgSincrona(RabbitMQConstantes.FILA_2, pessoa);
		
		return new ResponseEntity<PessoaDTO>(p, HttpStatus.OK);
	}

}
