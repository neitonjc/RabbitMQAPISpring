package com.api.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rabbitmq.constantes.RabbitMQConstantes;
import com.api.rabbitmq.dto.PessoaDTO;
import com.api.rabbitmq.service.RabbitMQService;

@RestController
@RequestMapping({"/pessoa"})
public class PessoaController {
	
	@Autowired
	private RabbitMQService rabbitMQService;
	
	@PostMapping(path="/incluirObj")
	public ResponseEntity<PessoaDTO> incluir(@RequestBody PessoaDTO pessoa){
		//return new ResponseEntity<PessoaDTO>(service.incluir(pessoa), HttpStatus.CREATED);
		this.rabbitMQService.enviaMsg(RabbitMQConstantes.FILA_1, pessoa);
		return new ResponseEntity<PessoaDTO>(pessoa, HttpStatus.OK);
	}

}
